package com.library.managementsystemproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.managementsystemproject.entities.Address;

public interface AddressRepository extends JpaRepository<Address, Long>{

}
