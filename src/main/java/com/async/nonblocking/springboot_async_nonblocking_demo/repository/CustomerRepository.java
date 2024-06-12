package com.async.nonblocking.springboot_async_nonblocking_demo.repository;


import com.async.nonblocking.springboot_async_nonblocking_demo.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    List<Customer> findByName(String name);
    List<Customer> findByRole(String role);

}
