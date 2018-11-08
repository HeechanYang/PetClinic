package yang.springframework.petclinic.services;

import yang.springframework.petclinic.model.Owner;


public interface OwnerService extends CrudService<Owner, Long>{
    public Owner findByLastName(String lastName);

}
