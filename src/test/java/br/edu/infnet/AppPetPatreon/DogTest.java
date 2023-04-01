package br.edu.infnet.AppPetPatreon;

import br.edu.infnet.AppPetPatreon.model.domain.Dog;

public class DogTest {
    public static void main(String[] args) {
        try {
            Dog dog1 = new Dog("Drogon", "Dog", 7, "Male", 232.5f, "Bernese", "Large", false, 23.4f, 16.7f);
            System.out.println(dog1);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("[ERROR] - " + e.getMessage());
        }

        try{
            Dog dog2 = new Dog("M0m0", "Dog", 14, "Female", 132.5f, "Lulu", "Small", true, 23.4f, 16.7f);
            System.out.println(dog2);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("[ERROR] - " + e.getMessage());
        }

        try{
            Dog dog3 = new Dog("Simba", "Dog", 112, "Male", 232.5f, "Goldem", "Medium", false, 23.4f, 16.7f);
            System.out.println(dog3);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("[ERROR] - " + e.getMessage());
        }

        try{
            Dog dog4 = new Dog("Adolf", "Dog", 12, "Male", -232.5f, "Husky", "Medium", false, 23.4f, 16.7f);
            System.out.println(dog4);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("[ERROR] - " + e.getMessage());
        }

        try{
            Dog dog5 = new Dog("Apa", "Dog", 12, "Male", 232.5f, "Malamute", null, false, 23.4f, 16.7f);
            System.out.println(dog5);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("[ERROR] - " + e.getMessage());
        }

        try{
            Dog dog6 = new Dog("Apa", "Dog", 12, "Male", 232.5f, "Malamute", "Medium", false, 23.4f, 16.7f);
            System.out.println(dog6);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("[ERROR] - " + e.getMessage());
        }
    }    
}