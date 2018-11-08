package yang.springframework.petclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import yang.springframework.petclinic.services.VetService;

@Controller
@RequestMapping("/vets")
public class VetController {

    private VetService vetService;

    public VetController() {
    }

    @RequestMapping(value = {"", "/", "/index", "/index.html"})
    public ModelAndView getVetList(ModelAndView modelAndView){

        modelAndView.setViewName("vets/index");
        return modelAndView;
    }
}
