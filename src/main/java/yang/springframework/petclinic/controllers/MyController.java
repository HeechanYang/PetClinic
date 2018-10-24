package yang.springframework.petclinic.controllers;

import org.springframework.stereotype.Controller;
import yang.springframework.petclinic.services.MyService;

@Controller
public class MyController {
    private MyService myService;

    // Inject Dependency automatically
    public MyController(MyService myService) {
        this.myService = myService;
    }

    public String helloSpring() {
        System.out.println(myService.helloSpring());

        return "foo";
    }
}
