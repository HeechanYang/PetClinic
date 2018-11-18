package yang.springframework.petclinic.controllers;

import io.swagger.annotations.ApiOperation;
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
    @ApiOperation(position = 1, value = "홈", notes = "")
    public String index() {

        return "index";
    }

    @RequestMapping(value = "/oops", method = RequestMethod.GET)
    @ApiOperation(position = 2, value = "웁스", notes = "")
    public String oops() {
        return "notimplemented";
    }
}
