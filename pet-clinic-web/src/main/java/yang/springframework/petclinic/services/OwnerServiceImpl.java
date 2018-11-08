package yang.springframework.petclinic.services;

import org.springframework.stereotype.Service;

import java.security.acl.Owner;
import java.util.Set;

@Service
public class OwnerServiceImpl implements OwnerService {
    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }

    @Override
    public Owner findById(Long id) {
        return null;
    }

    @Override
    public Set<Owner> findAll() {
        return null;
    }

    @Override
    public Owner save(Owner owner) {
        return null;
    }
}
