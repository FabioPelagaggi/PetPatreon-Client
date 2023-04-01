package br.edu.infnet.AppPetPatreon.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.AppPetPatreon.model.domain.Address;

@Repository
public interface AddressRepository extends CrudRepository<Address, Integer> {
}