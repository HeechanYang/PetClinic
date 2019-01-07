package yang.springframework.petclinic.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@EqualsAndHashCode(exclude = {"pet"}, callSuper = true)
@Entity
@Table(name = "visits")
public class Visit extends BaseEntity{
    @Column(name = "date")
    private LocalDate date;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;
}
