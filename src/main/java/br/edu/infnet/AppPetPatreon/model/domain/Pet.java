package br.edu.infnet.AppPetPatreon.model.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.edu.infnet.AppPetPatreon.model.validation.Valid;

@Entity
@Table(name = "pet_db")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Pet implements Comparable<Pet>  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String animalType;
    private int age;
    private String gender;
    private float foodCost;
    @ManyToOne
    @JoinColumn(name = "agency_id")
    private Agency agency;
    @ManyToMany(mappedBy = "pets")
    private List<Donation> donations = new ArrayList<>();

    public Pet() {
    }

    public Pet(String name, String animalType, int age, String gender, float foodCost) throws Exception {
        this.name = Valid.name(name);
        this.age = Valid.age(age);
        this.foodCost = Valid.cost(foodCost);
        this.gender = gender;
        this.animalType = animalType;
    }

    public void setId(Integer id) {
        this.id = id;
    };

    public Integer getId() {
        return id;
    };

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAnimalType(String animalType) {
        this.animalType = animalType;
    }

    public String getAnimalType() {
        return animalType;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    public void setFoodCost(float foodCost) {
        this.foodCost = foodCost;
    }

    public float getFoodCost() {
        return foodCost;
    }

    public void setAgency(Agency agency) {
        this.agency = agency;
    }

    public Agency getAgency() {
        return agency;
    }

    public void setDonations(List<Donation> donations) {
        this.donations = donations;
    }

    public List<Donation> getDonations() {
        return donations;
    }

    public abstract float calcMonthlyCost();

    public abstract void print();

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(name);
        stringBuilder.append(";");
        stringBuilder.append(animalType);
        stringBuilder.append(";");
        stringBuilder.append(age);
        stringBuilder.append(";");
        stringBuilder.append(gender);
        stringBuilder.append(";");
        stringBuilder.append(foodCost);
        stringBuilder.append(";");
        stringBuilder.append(agency);
        stringBuilder.append(";");
        stringBuilder.append(donations);
        stringBuilder.append(";");
        return stringBuilder.toString();
    }
}