package yang.springframework.petclinic.controllers;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import yang.springframework.petclinic.model.Owner;
import yang.springframework.petclinic.services.OwnerService;

import java.util.List;

@Controller
@Slf4j
@RequestMapping("/owners")
public class OwnerController {

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
    @ApiOperation(position = 2, value = "주인 찾기 페이지", notes = "")
    public String findOwners(Model model) {
        model.addAttribute("owner", new Owner());
        return "owners/findOwners";
    }

    @GetMapping(value = {"", "/", "/index", "/index.html"})
    @ApiOperation(position = 2, value = "주인 찾기 페이지", notes = "")
    public String processFindForm(Owner owner, BindingResult result, Model model) {
        // allow parameterless GET request for /owners to return all records
        if (owner.getLastName() == null) {
            owner.setLastName("");
        }

        //find owners by last name
        List<Owner> resultOwners = this.ownerService.findAllByLastNameLike(owner.getLastName());
        if (resultOwners.isEmpty()) {
            // no owners found
            result.rejectValue("lastName", "notFound", "not found");
            return "owners/findOwners";
        } else if (resultOwners.size() == 1) {
            owner = resultOwners.get(0);
            return "redirect:/owners/" + owner.getId();
        } else {
            model.addAttribute("selections", resultOwners);
            return "owners/ownerList";
        }
    }

    @GetMapping(value = "/{ownerId}")
//    @ApiOperation(position = 2, value = "주인 찾기 페이지", notes = "")
    public ModelAndView showOwner(@PathVariable Long ownerId) {
        log.debug("This is showOwner Id : " + ownerId);

        ModelAndView mav = new ModelAndView("/owners/ownerDetails");
        mav.addObject(ownerService.findById(ownerId));

        return mav;
    }
}
