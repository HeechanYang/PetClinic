package yang.springframework.petclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import yang.springframework.petclinic.services.PetService;

@Controller
@RequestMapping("/pets")
public class PetController {

    private PetService petService;

    public PetController() {
    }

    @RequestMapping(value = {"", "/", "/index", "/index.html"})
    public ModelAndView getPetList(ModelAndView modelAndView){

        modelAndView.setViewName("pets/index");
        return modelAndView;
    }
}
