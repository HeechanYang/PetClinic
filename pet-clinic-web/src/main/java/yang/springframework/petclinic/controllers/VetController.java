package yang.springframework.petclinic.controllers;

import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import yang.springframework.petclinic.services.VetService;

@Controller
@RequestMapping("/vets")
public class VetController {

    private VetService vetService;

    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    @RequestMapping(value = {"", "/", "/index", "/index.html"}, method = RequestMethod.GET)
    @ApiOperation(position = 1, value = "수의사 홈", notes = "")
    public String getPetList(Model model){
        model.addAttribute("vets",vetService.findAll());
        return "vets/index";
    }
}
