package yang.springframework.petclinic.services;

import yang.springframework.petclinic.model.Owner;

import java.util.List;


public interface OwnerService extends CrudService<Owner, Long>{
    public Owner findByLastName(String lastName);

    public List<Owner> findAllByLastNameLike(String lastName);

}
