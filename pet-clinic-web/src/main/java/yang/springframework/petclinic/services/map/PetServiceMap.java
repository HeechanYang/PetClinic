package yang.springframework.petclinic.services.map;

import yang.springframework.petclinic.model.Pet;
import yang.springframework.petclinic.services.CrudService;

import java.util.Set;

public class PetServiceMap extends AbstractMapService<Pet,Long> implements CrudService<Pet,Long> {


    @Override
    public Set<Pet> findAll() {
        return super.findALl();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Pet object) {
        super.delete(object);
    }

    @Override
    public Pet save(Pet object) {
        return super.save(object.getId(),object);
    }

    @Override
    public Pet findById(Long id) {
        return super.findById(id);
    }
}
