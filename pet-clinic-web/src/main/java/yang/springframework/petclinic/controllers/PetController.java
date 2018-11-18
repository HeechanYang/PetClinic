package yang.springframework.petclinic.controllers;

import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import yang.springframework.petclinic.services.PetService;

@Controller
@RequestMapping("/pets")
public class PetController {

    private PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    @RequestMapping(value = {"", "/", "/index", "/index.html"}, method = RequestMethod.GET)
    @ApiOperation(position = 1, value = "애완동물 홈", notes = "")
    public String getPetList(Model model){
        model.addAttribute("pets",petService.findAll());
        return "pets/index";
    }
}
