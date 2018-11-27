package yang.springframework.petclinic.services.map;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import yang.springframework.petclinic.model.Vet;
import yang.springframework.petclinic.services.SpecialityService;
import yang.springframework.petclinic.services.VetService;

import java.util.Set;

@Service
@Profile({"default","map"})
public class VetMapService extends AbstractMapService<Vet, Long> implements VetService {
    private SpecialityService specialityService;

    public VetMapService(SpecialityService specialityService) {
        this.specialityService = specialityService;
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public Vet save(Vet object) {
        if (object != null) {
            if (object.getSpecialities().size() > 0) {
                object.getSpecialities().forEach(speciality -> {
                    if (speciality != null) {
                        if (speciality.getId() == null) {
                            object.getSpecialities().add(specialityService.save(speciality));
                        }
                    } else {
                        throw new RuntimeException("Speciality is required");
                    }
                });
            }
            return super.save(object);
        } else {
            return null;
        }
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }
}
