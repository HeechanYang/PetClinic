package yang.springframework.petclinic.controllers;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import yang.springframework.petclinic.services.PetService;

@Controller
@Slf4j
@RequestMapping("/pets")
public class PetController {

    private PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    @GetMapping(value = {"", "/", "/index", "/index.html"})
    @ApiOperation(position = 1, value = "애완동물 홈", notes = "")
    public String getPetList(Model model){
        log.debug("This is Pet's Index");
        model.addAttribute("pets",petService.findAll());
        return "pets/index";
    }
}
