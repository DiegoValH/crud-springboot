package com.diegovalencia.crudsystem.repository;

import com.diegovalencia.crudsystem.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}
