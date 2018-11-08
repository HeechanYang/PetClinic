package yang.springframework.petclinic.services;

import yang.springframework.petclinic.model.Vet;

import java.util.Set;

public interface VetService {
    public Vet findById(Long id);

    public Set<Vet> findAll();

    public Vet save(Vet owner);
}
