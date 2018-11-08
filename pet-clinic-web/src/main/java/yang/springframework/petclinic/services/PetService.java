package yang.springframework.petclinic.services;

import yang.springframework.petclinic.model.Pet;

import java.util.Set;

public interface PetService {
    public Pet findById(Long id);

    public Set<Pet> findAll();

    public Pet save(Pet owner);
}
