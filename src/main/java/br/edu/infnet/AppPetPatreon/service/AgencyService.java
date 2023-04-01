package br.edu.infnet.AppPetPatreon.service;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.AppPetPatreon.client.IAgencyClient;
import br.edu.infnet.AppPetPatreon.model.domain.Agency;
import br.edu.infnet.AppPetPatreon.repository.AgencyRepository;

@Service
public class AgencyService {

    @Autowired
    private AgencyRepository agencyRepository;

    @Autowired
    private IAgencyClient agencyClient;

    public Agency add(Agency agency) {
        return agencyRepository.save(agency);
    }

    public void remove(Integer id) {
        agencyRepository.deleteById(id);
    }

    public Agency get(Integer id) {
        List<Agency> agencies = (List<Agency>) agencyClient.getAgencies();

        for (Agency agency : agencies) {
            if (agency.getId() == id) {
                return agency;
            }
        }

        return null;
    }

    public List<Agency> getAgencies() {
        List<Agency> agencies = (List<Agency>) agencyClient.getAgencies();

        agencies.sort(Comparator.comparingInt(Agency::getPatreonsSize).reversed());
        
        return agencies;
    }

    public List<Agency> getAgenciesAlpha() {
        List<Agency> agencies = (List<Agency>) agencyClient.getAgencies();

        agencies.sort((a1, a2) -> a1.getName().compareTo(a2.getName()));

        return agencies;
    }

}
