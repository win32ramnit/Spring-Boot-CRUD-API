package com.manish.sms.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manish.sms.entities.Address;

@Repository
public interface AddressRepo extends JpaRepository<Address, Integer> {

}
