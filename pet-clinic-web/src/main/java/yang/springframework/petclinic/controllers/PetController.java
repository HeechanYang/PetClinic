package yang.springframework.petclinic.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import yang.springframework.petclinic.model.Owner;
import yang.springframework.petclinic.model.Pet;
import yang.springframework.petclinic.model.PetType;
import yang.springframework.petclinic.services.OwnerService;
import yang.springframework.petclinic.services.PetService;
import yang.springframework.petclinic.services.PetTypeService;

import javax.validation.Valid;
import java.util.Collection;

@Controller
@Slf4j
@RequestMapping("/owners/{ownerId}/pets")
public class PetController {

    private static final String VIEWS_PET_CREATE_OR_UPDATE_PET_FORM = "pets/createOrUpdatePetForm";

    private final OwnerService ownerService;
    private final PetService petService;
    private final PetTypeService petTypeService;

    public PetController(OwnerService ownerService, PetService petService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.petService = petService;
        this.petTypeService = petTypeService;
    }

//    @GetMapping(value = {"", "/", "/index", "/index.html"})
//    @ApiOperation(position = 1, value = "애완동물 홈", notes = "")
//    public String getPetList(Model model) {
//        log.debug("This is Pet's Index");
//        model.addAttribute("pets", petService.findAll());
//        return "pets/index";
//    }

    // What is this?
    @InitBinder("owner")
    public void initOwnerBinder(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

    @ModelAttribute("types")
    public Collection<PetType> popularPetTypes() {
        return this.petTypeService.findAll();
    }

    @ModelAttribute("owner")
    public Owner findOwner(@PathVariable("ownerId") Long ownerId) {
        return this.ownerService.findById(ownerId);
    }

    @GetMapping("/new")
    public String initCreationForm(Owner owner, Model model) {
        Pet pet = new Pet();
        pet.setOwner(owner);
        model.addAttribute("pet", pet);
        return VIEWS_PET_CREATE_OR_UPDATE_PET_FORM;
    }

    @PostMapping("/new")
    public String processCreationForm(Owner owner, @Valid Pet pet, BindingResult result, Model model) {
        if (StringUtils.hasLength(pet.getName()) && pet.isNew() && owner.getPet(pet.getName(), true) != null) {
            result.rejectValue("name", "duplicate", "already exist");
        }
        owner.getPets().add(pet);
        pet.setOwner(owner);
        if (result.hasErrors()) {
            model.addAttribute("pet", pet);
            return VIEWS_PET_CREATE_OR_UPDATE_PET_FORM;
        } else {
            this.ownerService.save(owner);
            return "redirect:/owners/{ownerId}";
        }
    }

    @GetMapping("/{petId}/edit")
    public String initUpdateForm(@PathVariable Long petId, Model model) {
        Pet pet = petService.findById(petId);
        model.addAttribute("pet", pet);

        return VIEWS_PET_CREATE_OR_UPDATE_PET_FORM;
    }

    @PostMapping("/{petId}/edit")
    public String processUpdateForm(@Valid Pet pet, BindingResult result, Owner owner, Model model) {
        if (result.hasErrors()) {
            pet.setOwner(owner);
            model.addAttribute("pet", pet);
            return VIEWS_PET_CREATE_OR_UPDATE_PET_FORM;
        } else {
            // TODO: I hope to remove this
            // Why have to setOwner again???
            // I guess JSP makes new object
            pet.setOwner(owner);
            petService.save(pet);
            return "redirect:/owners/" + owner.getId();
        }
    }
}
