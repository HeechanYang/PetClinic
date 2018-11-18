package yang.springframework.petclinic.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

//Exclude Circular dependency
@EqualsAndHashCode(exclude = "owner", callSuper = true)
@Data
public class Pet extends BaseEntity{
    private PetType petType;
    private Owner owner;
    private LocalDate birthDate;
    private String name;
}
