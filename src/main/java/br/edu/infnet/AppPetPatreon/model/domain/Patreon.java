package br.edu.infnet.AppPetPatreon.model.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.edu.infnet.AppPetPatreon.constants.CONST;
import br.edu.infnet.AppPetPatreon.model.validation.Valid;

@Entity
@Table(name = "patreon_db")
public class Patreon implements Comparable<Patreon> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String middleName = "";
    private String lastName = "";
    private String email;
    private String phone;
    private String password;
    private boolean admin = false;
    @ManyToOne
    @JoinColumn(name = "agency_id")
    private Agency agency;
    @OneToMany(mappedBy = "patreon")
    private List<Donation> donations = new ArrayList<>();
    private String cep;
    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

    public Patreon() {
    };

    public Patreon(String name, String email, String phone) throws Exception {
        this.setName(Valid.name(name));
        this.email = Valid.email(email);
        this.phone = Valid.phone(phone);
    };

    public void setId(Integer id) {
        this.id = id;
    };

    public Integer getId() {
        return id;
    };

    private void setFirstName(String inputFirstName) {
        this.firstName = inputFirstName;
    };

    private String getFirstName() {
        return firstName;
    };

    private void setMiddleName(String inputMiddleName) {
        this.middleName = inputMiddleName;
    };

    private String getMiddleName() {
        return middleName;
    };

    private void setLastName(String inputLastName) {
        this.lastName = inputLastName;
    };

    private String getLastName() {
        return lastName;
    };

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    };

    public void setPhone(String phone) {
        this.phone = phone;
    };

    public String getPhone() {
        return phone;
    };

    public void setPassword(String password) {
        this.password = password;
    };

    public String getPassword() {
        return password;
    };

    public void setAdmin(boolean isAdmin) {
        this.admin = isAdmin;
    };

    public boolean getAdmin() {
        return admin;
    };

    public void setAgency(Agency agency) {
        this.agency = agency;
    };

    public Agency getAgency() {
        return agency;
    };

    public void setDonations(List<Donation> donations) {
        this.donations = donations;
    };

    public List<Donation> getDonations() {
        return donations;
    };

    public List<Pet> getDonationsPets() {
        List<Donation> donations = getDonations();
        List<Pet> donationsPets = new ArrayList<>();

        for (Donation donation : donations) {
            List<Pet> pets = donation.getPets();
            for (Pet pet : pets) {
                donationsPets.add(pet);
            }
        }

        return donationsPets;
    };

    public void addDonation(Donation donation) {
        this.donations.add(donation);
    };

    public void setCep(String cep) {
        this.cep = cep;
    };

    public String getCep() {
        return cep;
    };

    public void setAddress(Address address) {
        this.address = address;
    };

    public Address getAddress() {
        return address;
    };

    public String getName() {
        StringBuilder fullName = new StringBuilder();

        String firstName = getFirstName();
        String middleName = getMiddleName();
        String lastName = getLastName();

        fullName.append(firstName);

        if (middleName != "") {
            fullName.append(" ");
            fullName.append(middleName);
        }
        if (lastName != "") {
            fullName.append(" ");
            fullName.append(lastName);
        }
        return fullName.toString();
    };

    public void setName(String inputFullName) {
        String[] nameArray = inputFullName.split(" ");

        setFirstName(nameArray[0]);
        if (nameArray.length > 2) {
            setMiddleName(middleNameBuilder(nameArray));
        }
        if (nameArray.length > 1) {
            setLastName(nameArray[nameArray.length - 1]);
        }
    };

    private String middleNameBuilder(String[] nameArray) {
        StringBuilder middleNameBuilder = new StringBuilder();

        for (int i = 1; i < nameArray.length - 1; i++) {
            middleNameBuilder.append(nameArray[i]);
            if (i < nameArray.length - 2) {
                middleNameBuilder.append(" ");
            }
        }
        return middleNameBuilder.toString();
    };

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(CONST.PATREON_TAG);
        stringBuilder.append(";");
        stringBuilder.append(this.id);
        stringBuilder.append(";");
        stringBuilder.append(this.getName());
        stringBuilder.append(";");
        stringBuilder.append(this.email);
        stringBuilder.append(";");
        stringBuilder.append(this.phone);
        stringBuilder.append(";");
        stringBuilder.append(this.password);
        stringBuilder.append(";");
        stringBuilder.append(this.admin);
        stringBuilder.append(";");
        stringBuilder.append(this.agency.getName());
        stringBuilder.append(";");
        stringBuilder.append(this.donations);
        stringBuilder.append(";");
        stringBuilder.append(this.cep);
        return stringBuilder.toString();
    }

    @Override
    public int compareTo(Patreon arg0) {
        throw new UnsupportedOperationException("Unimplemented method 'compareTo'");
    };
}