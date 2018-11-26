package yang.springframework.petclinic.model.repositories;

import org.springframework.data.repository.CrudRepository;
import yang.springframework.petclinic.model.PetType;

public interface PetTypeRepository extends CrudRepository<PetType,Long> {
}
