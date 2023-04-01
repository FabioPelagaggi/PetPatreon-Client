package br.edu.infnet.AppPetPatreon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import br.edu.infnet.AppPetPatreon.model.domain.Bird;
import br.edu.infnet.AppPetPatreon.model.domain.Dog;
import br.edu.infnet.AppPetPatreon.model.domain.Donation;
import br.edu.infnet.AppPetPatreon.model.domain.Horse;
import br.edu.infnet.AppPetPatreon.model.domain.Patreon;
import br.edu.infnet.AppPetPatreon.model.domain.Pet;
import br.edu.infnet.AppPetPatreon.model.methods.ConvertString;

public class FileTest {
    public static void main(String[] args) {

        String file = "Donation.txt";
        
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            FileWriter fileWriter = new FileWriter("OUT_" + file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            String line = bufferedReader.readLine();

            String[] fields = null;

            List<Pet> petsList = null;
            Patreon patreon = null;
            Donation donation = null;

            while (line!= null) {
                fields = line.split(";");
                
                switch (fields[0].toUpperCase()) {
                    case "DONATION":
                        petsList = new ArrayList<Pet>();
                        patreon = new Patreon();
                        try{
                            donation = new Donation(ConvertString.toFloat(fields[2]), patreon, petsList);
                            System.out.println(donation.toString());
                        } catch (Exception e) {
                            e.printStackTrace();
                            System.out.println("[ERROR] - " + e.getMessage());
                        }
                        break;
                        
                    case "PATREON":
                        try {
                            patreon.setName(fields[1]);
                            patreon.setEmail(fields[2]);
                            patreon.setPhone(fields[3]);                            
                            System.out.println(patreon.toString());
                        } catch (Exception e) {
                            e.printStackTrace();
                            System.out.println("[ERROR] - " + e.getMessage());
                        }
                        break;

                    case "DOG":
                        try {
                            boolean castrated = false;
                            if (fields[8].equalsIgnoreCase("Yes")) {
                                castrated = true;
                            }
                            Dog dog = new Dog(fields[1], fields[2], ConvertString.toInt(fields[3]), fields[4], ConvertString.toFloat(fields[5]), fields[6], fields[7], castrated, ConvertString.toFloat(fields[9]), ConvertString.toFloat(fields[10]));
                            petsList.add(dog);
                            System.out.println(dog.toString());
                        } catch (Exception e) {
                            e.printStackTrace();
                            System.out.println("[ERROR] - " + e.getMessage());
                        }
                       break;

                    case "HORSE":
                        try {
                            Horse horse = new Horse(fields[1], fields[2], ConvertString.toInt(fields[3]), fields[4], ConvertString.toFloat(fields[5]), fields[6], ConvertString.toFloat(fields[7]), ConvertString.toFloat(fields[8]), ConvertString.toFloat(fields[9]));
                            petsList.add(horse);
                            System.out.println(horse.toString());
                        } catch (Exception e) {
                            e.printStackTrace();
                            System.out.println("[ERROR] - " + e.getMessage());
                        }
                        break;

                    case "BIRD":
                        try{
                            Bird bird = new Bird(fields[1], fields[2], ConvertString.toInt(fields[3]), fields[4], ConvertString.toFloat(fields[5]), fields[6], ConvertString.toFloat(fields[7]), ConvertString.toFloat(fields[8]));
                            petsList.add(bird);
                            System.out.println(bird.toString());
                        } catch (Exception e) {
                            e.printStackTrace();
                            System.out.println("[ERROR] - " + e.getMessage());
                        }
                        break;

                    default:
                        System.out.println("Data Unknown");
                        break;
                }
                line = bufferedReader.readLine();
            }

            try{
                donation.print();
                bufferedWriter.write(donation.writeFile());
            } catch (Exception e){
                System.out.println("[ERROR] - " + e.getMessage());
            }
            
            bufferedReader.close();
            fileReader.close();
            bufferedWriter.close();
            fileWriter.close();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("[ERROR] - " + e.getMessage());
        }
    }
}
