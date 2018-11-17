package yang.springframework.petclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import yang.springframework.petclinic.model.Owner;
import yang.springframework.petclinic.model.Pet;
import yang.springframework.petclinic.model.PetType;
import yang.springframework.petclinic.model.Vet;
import yang.springframework.petclinic.services.OwnerService;
import yang.springframework.petclinic.services.PetService;
import yang.springframework.petclinic.services.VetService;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final PetService petService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, PetService petService, VetService vetService) {
        this.ownerService = ownerService;
        this.petService = petService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) {
        Owner owner3 = new Owner();
        owner3.setId(1L);
        owner3.setFirstName("Heechan");
        owner3.setLastName("Yang");
        ownerService.save(owner3);

        Owner owner1 = new Owner();
        owner1.setId(2L);
        owner1.setFirstName("Jemin");
        owner1.setLastName("Song");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(3L);
        owner2.setFirstName("Jaieun");
        owner2.setLastName("Na");
        ownerService.save(owner2);

        System.out.println("###############Owner###############");
        for(Owner o : ownerService.findAll()){
            System.out.println(o.getId() +" "+ o.getFirstName()+" " + o.getLastName());
        }

        Pet pet1 = new Pet();
        pet1.setId(1L);
        pet1.setOwner(owner1);
        pet1.setBirthDate(LocalDate.now());
        pet1.setPetType(new PetType("웰시코기"));
        petService.save(pet1);

        Pet pet2 = new Pet();
        pet2.setId(2L);
        pet2.setOwner(owner3);
        pet2.setBirthDate(LocalDate.now());
        pet2.setPetType(new PetType("푸들"));
        petService.save(pet2);

        Pet pet3 = new Pet();
        pet3.setId(3L);
        pet3.setOwner(owner3);
        pet3.setBirthDate(LocalDate.now());
        pet3.setPetType(new PetType("나재은"));
        petService.save(pet3);

        System.out.println("###############Pet###############");
        for(Pet p : petService.findAll()){
            System.out.println(p.getId() +" "+ p.getOwner().getFirstName()+" " + p.getBirthDate());
        }

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Jo");
        vet1.setLastName("Eunsu");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("uhmm");
        vet2.setLastName("mmm");
        vetService.save(vet2);

        System.out.println("###############Vet###############");
        for(Vet v : vetService.findAll()){
            System.out.println(v.getId() +" "+ v.getFirstName()+" " + v.getLastName());
        }
    }
}
