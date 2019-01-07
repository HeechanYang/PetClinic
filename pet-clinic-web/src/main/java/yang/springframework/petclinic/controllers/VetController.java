package yang.springframework.petclinic.controllers;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import yang.springframework.petclinic.services.VetService;

@Controller
@Slf4j
@RequestMapping("/vets")
public class VetController {

    private VetService vetService;

    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    @GetMapping(value = {"", "/", "/index", "/index.html"})
    @ApiOperation(position = 1, value = "수의사 홈", notes = "")
    public String getPetList(Model model){
        log.debug("This is Vet's Index");
        model.addAttribute("vets",vetService.findAll());
        return "vets/index";
    }
}
