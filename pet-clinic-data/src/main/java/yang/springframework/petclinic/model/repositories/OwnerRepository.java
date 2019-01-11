package yang.springframework.petclinic.model.repositories;

import org.springframework.data.repository.CrudRepository;
import yang.springframework.petclinic.model.Owner;

import java.util.List;

public interface OwnerRepository extends CrudRepository<Owner,Long> {

    public Owner findByLastName(String lastName);

    public List<Owner> findAllByLastNameContaining(String lastName);
}
