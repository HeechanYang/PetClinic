package yang.springframework.petclinic.controllers;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping(value = "/")
public class IndexController {
//    private OwnerService ownerService;

//    // Inject Dependency automatically
//    public IndexController(@Qualifier("ownerServiceImpl") OwnerService ownerService) {
//        this.ownerService = ownerService;
//    }

    @GetMapping(value = {"/","index", "index.html", ""})
    @ApiOperation(position = 1, value = "홈", notes = "")
    public String index() {
        log.debug("This is Main Index");

        return "index";
    }

    @GetMapping(value = "/oops")
    @ApiOperation(position = 2, value = "웁스", notes = "")
    public String oops() {
        log.debug("This is Oops page");
        return "notimplemented";
    }
}
