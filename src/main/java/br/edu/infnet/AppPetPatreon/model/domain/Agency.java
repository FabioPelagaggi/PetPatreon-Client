package br.edu.infnet.AppPetPatreon.model.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.edu.infnet.AppPetPatreon.constants.CONST;

@Entity
@Table(name = "agency_db")
public class Agency implements Comparable<Agency> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String email;
    @OneToMany
    @JoinColumn(name = "agency_id")
    private List<Patreon> patreons = new ArrayList<Patreon>();
    @OneToMany
    @JoinColumn(name = "agency_id")
    private List<Pet> pets = new ArrayList<Pet>();

    public Agency() {
    }

    public Agency(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Patreon> getPatreons() {
        return patreons;
    }

    public void setPatreons(List<Patreon> patreons) {
        this.patreons = patreons;
    }

    public int getPatreonsSize() {
        return patreons.size();
    }

    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }

    public void addPatreon(Patreon patreons) {
        this.patreons.add(patreons);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(CONST.AGENCY_TAG);
        stringBuilder.append(";");
        stringBuilder.append(this.id);
        stringBuilder.append(";");
        stringBuilder.append(this.getName());
        stringBuilder.append(";");
        stringBuilder.append(this.email);
        stringBuilder.append(";");
        stringBuilder.append(this.patreons);
        return stringBuilder.toString();
    }

    @Override
    public int compareTo(Agency arg0) {
        throw new UnsupportedOperationException("Unimplemented method 'compareTo'");
    };
}
