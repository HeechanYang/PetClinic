package yang.springframework.petclinic.controllers;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import yang.springframework.petclinic.model.Owner;
import yang.springframework.petclinic.model.PetType;
import yang.springframework.petclinic.services.OwnerService;
import yang.springframework.petclinic.services.PetService;
import yang.springframework.petclinic.services.PetTypeService;

import java.util.Collection;

@Controller
@Slf4j
@RequestMapping("/pets")
public class PetController {

    private static final String VIEWS_PET_CREATE_OR_UPDATE_FORM = "/pets/createOrUpdateForm";

    private final OwnerService ownerService;
    private final PetService petService;
    private final PetTypeService petTypeService;

    public PetController(OwnerService ownerService, PetService petService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.petService = petService;
        this.petTypeService = petTypeService;
    }

    @GetMapping(value = {"", "/", "/index", "/index.html"})
    @ApiOperation(position = 1, value = "애완동물 홈", notes = "")
    public String getPetList(Model model){
        log.debug("This is Pet's Index");
        model.addAttribute("pets",petService.findAll());
        return "pets/index";
    }


    @ModelAttribute("types")
    public Collection<PetType> popularPetTypes(){
        return this.petTypeService.findAll();
    }

    @ModelAttribute("owner")
    public Owner findOwner(@PathVariable("ownerId") Long ownerId){
        return this.ownerService.findById(ownerId);
    }

    @InitBinder("owner")
    public void initOwnerBinder(WebDataBinder dataBinder){
        dataBinder.setDisallowedFields("id");
    }
}
