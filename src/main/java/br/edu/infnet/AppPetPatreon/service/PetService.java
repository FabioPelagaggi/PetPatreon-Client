package br.edu.infnet.AppPetPatreon.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.AppPetPatreon.model.domain.Agency;
import br.edu.infnet.AppPetPatreon.model.domain.Pet;
import br.edu.infnet.AppPetPatreon.repository.PetRepository;

@Service
public class PetService {
    
    @Autowired
    private PetRepository petRepository;

    public Pet add(Pet pet) {
        return petRepository.save(pet);
    }

    public void remove(Integer id) {
        petRepository.deleteById(id);
    }

    public Pet get(Integer id) {
        return petRepository.findById(id).get();
    }

    public List<Pet> getPets() {
        List<Pet> pets = (List<Pet>) petRepository.findAll();
        pets.sort(Comparator.comparingDouble(Pet::calcMonthlyCost).reversed());
        return pets;
    }

    
    public List<Pet> getPets(Agency agency) {

        List<Pet> petsAgency = new ArrayList<Pet>();
        List<Pet> pets = (List<Pet>) petRepository.findAll();

        for (Pet pet : pets) {
            if (pet.getAgency().getName().equalsIgnoreCase(agency.getName())) {
                petsAgency.add(pet);
            }
        }

        petsAgency.sort(Comparator.comparingDouble(Pet::calcMonthlyCost).reversed());

        return petsAgency;
    }

    public List<Pet> getDogs() {

        List<Pet> dogs = new ArrayList<Pet>();
        List<Pet> pets = (List<Pet>) petRepository.findAll();

        for (Pet pet : pets) {
            if (pet.getAnimalType().equalsIgnoreCase("DOG")) {
                dogs.add(pet);
            }
        }

        dogs.sort(Comparator.comparingDouble(Pet::calcMonthlyCost).reversed());

        return dogs;
    }

    public List<Pet> getBirds() {

        List<Pet> birds = new ArrayList<Pet>();
        List<Pet> pets = (List<Pet>) petRepository.findAll();

        for (Pet pet : pets) {
            if (pet.getAnimalType().equalsIgnoreCase("BIRD")) {
                birds.add(pet);
            }
        }

        birds.sort(Comparator.comparingDouble(Pet::calcMonthlyCost).reversed());

        return birds;
    }

    public List<Pet> getHorses() {

        List<Pet> horses = new ArrayList<Pet>();
        List<Pet> pets = (List<Pet>) petRepository.findAll();

        for (Pet pet : pets) {
            if (pet.getAnimalType().equalsIgnoreCase("HORSE")) {
                horses.add(pet);
            }
        }

        horses.sort(Comparator.comparingDouble(Pet::calcMonthlyCost).reversed());

        return horses;
    }
}
