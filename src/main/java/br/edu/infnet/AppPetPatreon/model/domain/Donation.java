package br.edu.infnet.AppPetPatreon.model.domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.edu.infnet.AppPetPatreon.constants.CONST;
import br.edu.infnet.AppPetPatreon.model.exceptions.InvalidDonation;

@Entity
@Table(name = "donation_db")
public class Donation implements Comparable<Donation> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private float donationAmount;
    private LocalDateTime dateTime;
    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "patreon_id")
    private Patreon patreon;
    @ManyToMany(cascade = CascadeType.DETACH)
    private List<Pet> pets = new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "agency_id")
    private Agency agency;

    public Donation() {
    }

    public Donation(float donationAmount, Patreon patreon, List<Pet> pets) throws Exception {

        if (donationAmount > 0) {
            this.donationAmount = donationAmount;
        } else {
            throw new InvalidDonation("The donation amount must be greater than 0");
        }

        if (patreon != null) {
            this.patreon = patreon;
        } else {
            throw new InvalidDonation("The patreon must not be null");
        }

        if (pets != null) {
            this.pets = pets;
        } else {
            throw new InvalidDonation("The pets must not be null");
        }
    }
    
    public void setId(Integer id) {
        this.id = id;
    };

    public Integer getId() {
        return id;
    };

    public float getDonationAmount() {
        return donationAmount;
    }

    public void setDonationAmount(float donationAmount) {
        this.donationAmount = donationAmount;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Patreon getPatreon() {
        return patreon;
    }

    public void setPatreon(Patreon patreon) {
        this.patreon = patreon;
    }

    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }

    public void addPet(Pet pet) {
        this.pets.add(pet);
    }

    public Agency getAgency() {
        return agency;
    }

    public void setAgency(Agency agency) {
        this.agency = agency;
    }

    public void print() {
        System.out.println();
        System.out.println("Donation Data: " + this);
        System.out.println("-----------------------");
        System.out.println("Patreon: " + this.patreon.getName());
        System.out.println("Donation Amount: " + this.donationAmount);
        System.out.println("Pets Qty.: " + this.pets.size());
        for (Pet pet : this.pets) {
            System.out.println("- " + pet.getName());
            System.out.println("- " + pet.getAnimalType());
            pet.print();
        }
    }

    private float calcPetsTotalMonthlyCost() {
        float total = 0;
        for (Pet pet : this.getPets()) {
            total += pet.calcMonthlyCost();
        }
        return total;
    }

    public String writeFile() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(CONST.DONATION_TAG);
        stringBuilder.append(";");
        stringBuilder.append(this.dateTime.format(formatter));
        stringBuilder.append(";");
        stringBuilder.append(this.calcPetsTotalMonthlyCost());
        stringBuilder.append(";");
        stringBuilder.append("\r\n");

        return stringBuilder.toString();
    }

    @Override
    public String toString() {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        String stringData = String.format("%s;%f;%f;%s;%s;%s", CONST.DONATION_TAG, 
                this.donationAmount, this.dateTime.format(formatter), this.patreon, this.pets.toString());

        return stringData.toString();
    }

    @Override
    public int compareTo(Donation arg0) {
        throw new UnsupportedOperationException("Unimplemented method 'compareTo'");
    }
}