package yang.springframework.petclinic.model;


import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

//Exclude Circular dependency
@EqualsAndHashCode(exclude = "pets", callSuper = true)
@Data
@Entity
@Table(name = "owners")
public class Owner extends Person {
    @Column(name = "id")
    private Long id;
    @Column(name = "address")
    private String address;
    @Column(name = "city")
    private String city;
    @Column(name = "telephone")
    private String telephone;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    private Set<Pet> pets = new HashSet<>();

    public Pet getPet(String petName) {
        return getPet(petName, false);
    }

    public Pet getPet(String petName, boolean ignoreNew) {
        petName = petName.toLowerCase();

        for (Pet pet : this.getPets()) {
            if (!ignoreNew || !pet.isNew()) {
                String compName = pet.getName();
                compName = compName.toLowerCase();
                if(compName.equals(petName)){
                    return pet;
                }
            }
        }

        return null;
    }
}
