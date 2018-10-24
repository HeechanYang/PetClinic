package yang.springframework.petclinic.services;

import org.springframework.stereotype.Service;

@Service
public class MyServiceImpl implements MyService {
    @Override
    public String helloSpring() {
        return "Hello Spring!";
    }
}
