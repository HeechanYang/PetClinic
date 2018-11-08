package yang.springframework.petclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/")
public class IndexController {
//    private OwnerService ownerService;

//    // Inject Dependency automatically
//    public IndexController(@Qualifier("ownerServiceImpl") OwnerService ownerService) {
//        this.ownerService = ownerService;
//    }

    @RequestMapping(value = {"/","index", "index.html", ""}, method = RequestMethod.GET)
    public String index() {

        return "index";
    }
}
