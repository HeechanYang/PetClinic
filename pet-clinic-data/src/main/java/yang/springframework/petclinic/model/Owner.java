package yang.springframework.petclinic.model;


import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
public class Owner extends Person {
    private Set<Pet> pets;
}
