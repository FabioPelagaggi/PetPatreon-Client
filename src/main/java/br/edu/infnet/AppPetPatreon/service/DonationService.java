package br.edu.infnet.AppPetPatreon.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.AppPetPatreon.model.domain.Donation;
import br.edu.infnet.AppPetPatreon.model.domain.Patreon;
import br.edu.infnet.AppPetPatreon.repository.DonationRepository;

@Service
public class DonationService {

    @Autowired
    private DonationRepository donationRepository;

    public Donation add(Donation donation) {
        return donationRepository.save(donation);
    }

    public void remove(Integer id) {
        donationRepository.deleteById(id);
    }

    public Donation get(Integer id) {
        return donationRepository.findById(id).get();
    }

    public List<Donation> getDonations() {
        return (List<Donation>) donationRepository.findAll();
    }

    public List<Donation> getDonations(Patreon patreon) {

        List<Donation> donationsPatreon = new ArrayList<Donation>();
        List<Donation> donations = (List<Donation>) donationRepository.findAll();

        for (Donation donation : donations) {
            if (donation.getPatreon().getId().equals(patreon.getId())) {
                donationsPatreon.add(donation);
            }
        }

        donationsPatreon.sort(Comparator.comparingDouble(Donation::getDonationAmount).reversed());
        
        return donationsPatreon;
    }
}
