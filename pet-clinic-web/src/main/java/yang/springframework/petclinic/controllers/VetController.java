package yang.springframework.petclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import yang.springframework.petclinic.services.VetService;

@Controller
@RequestMapping("/vets")
public class VetController {

    private VetService vetService;

    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    @RequestMapping(value = {"", "/", "/index", "/index.html"})
    public String getPetList(Model model){
        model.addAttribute("vets",vetService.findAll());
        return "vets/index";
    }
}
