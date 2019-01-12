package yang.springframework.petclinic.controllers;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import yang.springframework.petclinic.model.Owner;
import yang.springframework.petclinic.services.OwnerService;

import javax.validation.Valid;
import java.util.List;

@Controller
@Slf4j
@RequestMapping("/owners")
public class OwnerController {

    private static final String VIEWS_OWNER_LIST = "owners/ownerList";
    private static final String VIEWS_OWNER_DETAIL = "owners/ownerDetails";
    private static final String VIEWS_OWNER_FIND = "owners/findOwners";
    private static final String VIEWS_OWNER_CREATE_OR_UPDATE_FORM = "owners/createOrUpdateOwnerForm";

    private OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

//    @GetMapping(value = {"", "/", "/index", "/index.html"})
//    @ApiOperation(position = 1, value = "주인 홈", notes = "")
//    public String getOwnerList(Model model) {
//        log.debug("This is Owner's Index");
//        model.addAttribute("owners", ownerService.findAll());
//        return "owners/index";
//    }

    @GetMapping(value = "/find")
    @ApiOperation(position = 2, value = "주인 찾기 페이지", notes = "uhmm")
    public String findOwners(Model model) {
        model.addAttribute("owner", new Owner());
        return VIEWS_OWNER_FIND;
    }

    @GetMapping(value = {"", "/", "/index", "/index.html"})
    @ApiOperation(position = 2, value = "주인 찾기 페이지", notes = "uhmm")
    public String processFindForm(Owner owner, BindingResult result, Model model) {
        // allow parameterless GET request for /owners to return all records
        if (owner.getLastName() == null) {
            owner.setLastName("");
        }

        //find owners by last name
        List<Owner> resultOwners = this.ownerService.findAllByLastNameContaining(owner.getLastName());
        if (resultOwners.isEmpty()) {
            // no owners found
            result.rejectValue("lastName", "notFound", "not found");
            return VIEWS_OWNER_FIND;
        } else if (resultOwners.size() == 1) {
            owner = resultOwners.get(0);
            return "redirect:owners/" + owner.getId();
        } else {
            model.addAttribute("selections", resultOwners);
            return VIEWS_OWNER_LIST;
        }
    }

    @GetMapping(value = "/{ownerId}")
//    @ApiOperation(position = 2, value = "주인 찾기 페이지", notes = "")
    public ModelAndView showOwner(@PathVariable Long ownerId) {
        log.debug("This is showOwner Id : " + ownerId);

        ModelAndView mav = new ModelAndView(VIEWS_OWNER_DETAIL);
        mav.addObject(ownerService.findById(ownerId));

        return mav;
    }

    @GetMapping("/new")
    public String initCreationForm(Model model) {
        model.addAttribute("owner", new Owner());
        return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping("/new")
    public String processCreationForm(@Valid Owner owner, BindingResult result) {
        if (result.hasErrors()) {
            return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
        } else {
            Owner savedOwner =  ownerService.save(owner);
            return "redirect:owners/" + savedOwner.getId();
        }
    }
}
