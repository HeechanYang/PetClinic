package yang.springframework.petclinic.controllers;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import yang.springframework.petclinic.services.OwnerService;

@Controller
@Slf4j
@RequestMapping("/owners")
public class OwnerController {

    private OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @GetMapping(value = {"", "/", "/index", "/index.html"})
    @ApiOperation(position = 1, value = "주인 홈", notes = "")
    public String getOwnerList(Model model) {
        log.debug("This is Owner's Index");
        model.addAttribute("owners", ownerService.findAll());
        return "owners/index";
    }

    @GetMapping(value = "/find")
    @ApiOperation(position = 2, value = "주인 찾기 페이지", notes = "")
    public String findOwners() {
        log.debug("This is Owner's Find");
        return "notimplemented";
    }

    @GetMapping(value = "/{ownerId}")
    @ApiOperation(position = 2, value = "주인 찾기 페이지", notes = "")
    public ModelAndView showOwner(@PathVariable Long ownerId) {
        log.debug("This is showOwner Id : " + ownerId);

        ModelAndView mav = new ModelAndView("/owners/ownerDetails");
        mav.addObject(ownerService.findById(ownerId));

        return mav;
    }
}
