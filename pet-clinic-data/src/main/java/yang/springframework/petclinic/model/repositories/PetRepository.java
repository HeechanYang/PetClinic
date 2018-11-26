package yang.springframework.petclinic.model.repositories;

import org.springframework.data.repository.CrudRepository;
import yang.springframework.petclinic.model.Pet;

public interface PetRepository extends CrudRepository<Pet,Long> {
}
