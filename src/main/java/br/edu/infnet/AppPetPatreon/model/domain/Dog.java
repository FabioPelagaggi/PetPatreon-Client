package br.edu.infnet.AppPetPatreon.model.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

import br.edu.infnet.AppPetPatreon.constants.CONST;
import br.edu.infnet.AppPetPatreon.model.exceptions.InvalidSize;

@Entity
@Table(name = "dog_db")
public class Dog extends Pet {

    private String breed;
    private String size;
    private boolean castrated;
    private float bathCost;
    private float toysCost;

    public Dog(){
    }

    public Dog(String name, String animalType, int age, String gender, float foodCost, String breed, String size,
            boolean castrated, float bathCost, float toysCost) throws Exception {
        super(name, animalType, age, gender, foodCost);
        this.breed = breed;
        this.castrated = castrated;
        this.bathCost = bathCost;
        this.toysCost = toysCost;

        if (size == null) {
            throw new InvalidSize("The size cannot be null");
        }

        this.size = size;
    }
    
    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getBreed() {
        return breed;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getSize() {
        return size;
    }

    public void setCastrated(boolean castrated) {
        this.castrated = castrated;
    }

    public boolean getCastrated() {
        return castrated;
    }

    public void setBathCost(float bathCost) {
        this.bathCost = bathCost;
    }

    public float getBathCost() {
        return bathCost;
    }

    public void setToysCost(float toysCost) {
        this.toysCost = toysCost;
    }

    public float getToysCost() {
        return toysCost;
    }

    @Override
    public float calcMonthlyCost() {
        float foodCost = getFoodCost();
        float bathCost = this.getBathCost();
        float toysCost = this.getToysCost();

        if ("small".equalsIgnoreCase(size)) {
            foodCost *= 0.5f;
            bathCost *= 0.5f;
            toysCost *= 0.5f;
        } else if ("medium".equalsIgnoreCase(size)) {
            bathCost *= 1.5f;
            toysCost *= 1.5f;
        } else if ("large".equalsIgnoreCase(size)) {
            foodCost *= 2f;
            bathCost *= 1.5f;
        }
        return foodCost + bathCost + toysCost;
    }

    public void print() {
        System.out.println("Dog Name: " + this.getName());
        System.out.println("Breed: " + this.getBreed());
        System.out.println("Gender: " + this.getGender());
        System.out.println("Age: " + this.getAge());
        System.out.println("Size: " + this.getSize());
        System.out.println("Monthly Cost: " + this.calcMonthlyCost());
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(CONST.DOG_TAG);
        stringBuilder.append(";");
        stringBuilder.append(super.toString());
        stringBuilder.append(";");
        stringBuilder.append(breed);
        stringBuilder.append(";");
        stringBuilder.append(size);
        stringBuilder.append(";");
        if (castrated) {
            stringBuilder.append("Yes;");
        } else {
            stringBuilder.append("No;");
        }
        stringBuilder.append(bathCost);
        stringBuilder.append(";");
        stringBuilder.append(toysCost);
        stringBuilder.append(";");
        stringBuilder.append(calcMonthlyCost());
        return stringBuilder.toString();
    }

    @Override
    public int compareTo(Pet arg0) {
        throw new UnsupportedOperationException("Unimplemented method 'compareTo'");
    }
}