package yang.springframework.petclinic.controllers;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import yang.springframework.petclinic.services.OwnerService;

@Controller
public class MyController {
    private OwnerService ownerService;

    // Inject Dependency automatically
    public MyController(@Qualifier("ownerServiceImpl") OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    public String helloSpring() {
//        System.out.println(ownerService.helloSpring());

        return "foo";
    }
}
