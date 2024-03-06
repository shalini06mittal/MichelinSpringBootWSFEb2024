package com.demo.SpringBootDemo.repo;

import com.demo.SpringBootDemo.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AddressRepository extends JpaRepository<Address,Integer > {

}
