package yang.springframework.petclinic.services.map;

import yang.springframework.petclinic.model.Owner;
import yang.springframework.petclinic.services.CrudService;

import java.util.Set;

public class OwnerServiceMap extends AbstractMapService<Owner,Long> implements CrudService<Owner,Long> {


    @Override
    public Set<Owner> findAll() {
        return super.findALl();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public Owner save(Owner object) {
        return super.save(object.getId(),object);
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }
}
