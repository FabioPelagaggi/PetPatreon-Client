package br.edu.infnet.AppPetPatreon.repository;

import org.springframework.data.repository.CrudRepository;

import br.edu.infnet.AppPetPatreon.model.domain.Donation;

public interface DonationRepository extends CrudRepository<Donation, Integer> {
}
