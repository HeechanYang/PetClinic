package yang.springframework.petclinic.controllers;

import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import yang.springframework.petclinic.services.OwnerService;

@Controller
@RequestMapping("/owners")
public class OwnerController {

    private OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @RequestMapping(value = {"", "/", "/index", "/index.html"}, method = RequestMethod.GET)
    @ApiOperation(position = 1, value = "주인 홈", notes = "")
    public String getOwnerList(Model model){
        model.addAttribute("owners",ownerService.findAll());
        return "owners/index";
}
}
