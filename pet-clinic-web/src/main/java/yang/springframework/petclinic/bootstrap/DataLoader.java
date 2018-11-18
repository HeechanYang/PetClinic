package yang.springframework.petclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import yang.springframework.petclinic.model.*;
import yang.springframework.petclinic.services.*;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final PetService petService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;

    public DataLoader(OwnerService ownerService, PetService petService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService) {
        this.ownerService = ownerService;
        this.petService = petService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
    }

    @Override
    public void run(String... args) {
        loadData();
    }

    private void loadData() {
        PetType petType1 = new PetType();
        petType1.setName("Dog");
        PetType petType2 = new PetType();
        petType2.setName("Cat");
        PetType petType3 = new PetType();
        petType3.setName("Snake");
        PetType petType4 = new PetType();
        petType4.setName("Najaeeun");

        Owner owner3 = new Owner();
        owner3.setFirstName("Heechan");
        owner3.setLastName("Yang");
        owner3.setAddress("Seoul, Nowon");
        owner3.setCity("Seoul");
        owner3.setTelephone("01011111111");

        Pet pet1 = new Pet();
        pet1.setPetType(petType1);
        pet1.setOwner(owner3);
        pet1.setName("Mong-ee");
        pet1.setBirthDate(LocalDate.now());
        owner3.getPets().add(pet1);

        Pet pet2 = new Pet();
        pet2.setPetType(petType1);
        pet2.setName("bag-goo");
        pet2.setOwner(owner3);
        pet2.setBirthDate(LocalDate.now());
        owner3.getPets().add(pet2);

        ownerService.save(owner3);

        Owner owner1 = new Owner();
        owner1.setFirstName("Jemin");
        owner1.setLastName("Song");
        owner1.setAddress("Seoul, Nowon");
        owner1.setCity("Seoul");
        owner1.setTelephone("01011111111");

        Pet pet3 = new Pet();
        pet3.setOwner(owner1);
        pet3.setName("Mew");
        pet3.setBirthDate(LocalDate.now());
        pet3.setPetType(petType2);
        owner1.getPets().add(pet3);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Jaieun");
        owner2.setLastName("Na");
        owner2.setAddress("Seoul, Nowon");
        owner2.setCity("Seoul");
        owner2.setTelephone("01011111111");

        Pet pet4 = new Pet();
        pet4.setName("Uhm");
        pet4.setOwner(owner2);
        pet4.setBirthDate(LocalDate.now());
        pet4.setPetType(petType3);
        owner2.getPets().add(pet4);

        ownerService.save(owner2);

        System.out.println("###############PetType###############");
        for(PetType pt : petTypeService.findAll()){
            System.out.println(pt.getId() +" "+ pt.getName());
        }

        System.out.println("###############Owner###############");
        for(Owner o : ownerService.findAll()){
            System.out.println(o.getId() +" "+ o.getFirstName()+" " + o.getLastName());
        }

        System.out.println("###############Pet###############");
        for(Pet p : petService.findAll()){
            System.out.println(p.getId() +" "+ p.getOwner().getFirstName()+" " + p.getBirthDate());
        }

        Speciality speciality1 = new Speciality();
        speciality1.setDescription("radiology");
        Speciality savedSpeciality1 = specialityService.save(speciality1);
        Speciality speciality2 = new Speciality();
        speciality2.setDescription("surgery");
        Speciality savedSpeciality2 = specialityService.save(speciality2);
        Speciality speciality3 = new Speciality();
        speciality3.setDescription("dentistry");
        Speciality savedSpeciality3 = specialityService.save(speciality3);

        Vet vet1 = new Vet();
        vet1.setFirstName("Jo");
        vet1.setLastName("Eunsu");
        vet1.getSpecialities().add(savedSpeciality1);
        vet1.getSpecialities().add(savedSpeciality2);
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("uhmm");
        vet2.setLastName("mmm");
        vet2.getSpecialities().add(savedSpeciality1);
        vet2.getSpecialities().add(savedSpeciality3);
        vetService.save(vet2);

        System.out.println("############### Speciality ###############");
        for(Speciality s : specialityService.findAll()){
            System.out.println(s.getId() +" "+ s.getDescription());
        }

        System.out.println("###############Vet###############");
        for(Vet v : vetService.findAll()){
            System.out.println(v.getId() +" "+ v.getFirstName()+" " + v.getLastName());
        }
    }
}
