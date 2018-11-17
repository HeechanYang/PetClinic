package yang.springframework.petclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import yang.springframework.petclinic.services.PetService;

@Controller
@RequestMapping("/pets")
public class PetController {

    private PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    @RequestMapping(value = {"", "/", "/index", "/index.html"})
    public String getPetList(Model model){
        model.addAttribute("pets",petService.findAll());
        return "pets/index";
    }
}
