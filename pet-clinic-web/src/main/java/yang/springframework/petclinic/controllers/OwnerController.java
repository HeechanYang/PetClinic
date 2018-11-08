package yang.springframework.petclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import yang.springframework.petclinic.services.OwnerService;

@Controller
@RequestMapping("/owners")
public class OwnerController {

    private OwnerService ownerService;

    public OwnerController() {
    }

    @RequestMapping(value = {"", "/", "/index", "/index.html"})
    public ModelAndView getOwnerList(ModelAndView modelAndView){

        modelAndView.setViewName("owners/index");
        return modelAndView;
    }
}
