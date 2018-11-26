package yang.springframework.petclinic.model.repositories;

import org.springframework.data.repository.CrudRepository;
import yang.springframework.petclinic.model.Speciality;

public interface SpecialityRepository extends CrudRepository<Speciality,Long> {
}
