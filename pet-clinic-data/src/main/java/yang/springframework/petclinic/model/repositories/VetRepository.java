package yang.springframework.petclinic.model.repositories;

import org.springframework.data.repository.CrudRepository;
import yang.springframework.petclinic.model.Vet;

public interface VetRepository extends CrudRepository<Vet,Long> {
}
