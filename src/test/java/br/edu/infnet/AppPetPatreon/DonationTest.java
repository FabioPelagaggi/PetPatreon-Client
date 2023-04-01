package br.edu.infnet.AppPetPatreon;

import java.util.List;

import br.edu.infnet.AppPetPatreon.model.domain.Bird;
import br.edu.infnet.AppPetPatreon.model.domain.Dog;
import br.edu.infnet.AppPetPatreon.model.domain.Donation;
import br.edu.infnet.AppPetPatreon.model.domain.Horse;
import br.edu.infnet.AppPetPatreon.model.domain.Patreon;
import br.edu.infnet.AppPetPatreon.model.domain.Pet;

public class DonationTest {
    public static void main(String[] args) {
        try {
            Dog dog1 = new Dog("Pongo", "Dog", 7, "Male", 232.5f, "Colie", "Large", false, 23.4f, 16.7f);
            Horse horse1 = new Horse("Sansao", "horse", 15, "Male", 332.3f, "Arabian", 10.3f, 26.7f, 70);
            Bird bird3 = new Bird("Ferdinando", "Bird", 5, "Male", 3.5f, "Small", 1.4f, 5.9f);
            Patreon patreon01 = new Patreon("Ernesto", "ernesto@gmail.com", "552197621566");

            List<Pet> petsList1;
            petsList1 = List.of(dog1, horse1, bird3);

            Donation donation01 = new Donation(0f, patreon01, petsList1);

            donation01.print();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("[ERROR] - " + e.getMessage());
        }
        
        try {
            Dog dog1 = new Dog("Pongo", "Dog", 7, "Male", 232.5f, "Colie", "Large", false, 23.4f, 16.7f);
            Horse horse1 = new Horse("Sansao", "horse", 15, "Male", 332.3f, "Arabian", 10.3f, 26.7f, 70);
            Bird bird3 = new Bird("Ferdinando", "Bird", 5, "Male", 3.5f, "Small", 1.4f, 5.9f);

            List<Pet> petsList1;
            petsList1 = List.of(dog1, horse1, bird3);

            Donation donation01 = new Donation(1200f, null, petsList1);

            donation01.print();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("[ERROR] - " + e.getMessage());
        }

        try {
            Patreon patreon02 = new Patreon("Ferdinando", "ferdinandinho@gmail.com", "552378787878");
            Donation donation02 = new Donation(100f, patreon02, null);

            donation02.print();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("[ERROR] - " + e.getMessage());
        }

        try {
            Dog dog2 = new Dog("Pingo", "Dog", 14, "Female", 132.5f, "Poodle", "Small", true, 23.4f, 16.7f);
            Horse horse2 = new Horse("Eris", "horse", 22, "Felame", 406.4f, "Thoroughbred", 13.4f, 15.7f, 30);
            Bird bird2 = new Bird("Astrogimecleuda", "Bird", 27, "Female", 16.5f, "Large", 3.4f, 5.7f);
            Patreon patreon02 = new Patreon("Ferdinanda Jr", "ferdinandinho@gmail.com", "552378787878");

            List<Pet> petsList2;
            petsList2 = List.of(dog2, horse2, bird2);

            Donation donation02 = new Donation(135.78f, patreon02, petsList2);

            donation02.print();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("[ERROR] - " + e.getMessage());
        }
    }
}