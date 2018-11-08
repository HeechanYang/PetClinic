package yang.springframework.petclinic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class PetClinicApplication {

    public static void main(String[] args) {
        // get the ApplicationContext
        ApplicationContext applicationContext = SpringApplication.run(PetClinicApplication.class, args);

        // get a Bean using name of bean from ApplicationContext
//        IndexController indexController = (IndexController) applicationContext.getBean("indexController");
//        indexController.helloSpring();

    }
}
