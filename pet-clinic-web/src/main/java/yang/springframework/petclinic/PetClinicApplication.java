package yang.springframework.petclinic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

@SpringBootApplication
@ImportResource("classpath:swagger-config.xml")
public class PetClinicApplication {

    @Bean
    public LocaleResolver localeResolver() {
        SessionLocaleResolver slr = new SessionLocaleResolver();
        slr.setDefaultLocale(Locale.KOREA);
        return slr;
    }

    public static void main(String[] args) {
        // get the ApplicationContext
        ApplicationContext applicationContext = SpringApplication.run(PetClinicApplication.class, args);

        // get a Bean using name of bean from ApplicationContext
//        IndexController indexController = (IndexController) applicationContext.getBean("indexController");
//        indexController.helloSpring();

    }
}
