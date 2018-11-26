package yang.springframework.petclinic.model;

import lombok.Data;

import javax.persistence.Column;

@Data
public class Speciality extends BaseEntity{

    @Column(name = "description")
    private String description;
}
