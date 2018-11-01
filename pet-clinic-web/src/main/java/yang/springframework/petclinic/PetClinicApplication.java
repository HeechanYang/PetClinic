package yang.springframework.petclinic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import yang.springframework.petclinic.controllers.MyController;

@SpringBootApplication
public class PetClinicApplication {

    public static void main(String[] args) {
        // get the ApplicationContext
        ApplicationContext applicationContext = SpringApplication.run(PetClinicApplication.class, args);

        // get a Bean using name of bean from ApplicationContext
        MyController myController = (MyController) applicationContext.getBean("myController");
        myController.helloSpring();

    }
}
