package com.async.nonblocking.springboot_async_nonblocking_demo.business;

import com.async.nonblocking.springboot_async_nonblocking_demo.domain.Customer;
import com.async.nonblocking.springboot_async_nonblocking_demo.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;


@Service
@Slf4j
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;



    public List<Customer> getCustomerByName(String name) {
        log.info("Getting customer {} from the repository.", name);

        List<Customer> customerList = customerRepository.findByName(name);

        if (CollectionUtils.isEmpty(customerList)) {
            log.info("No customer found by name {}", name);
            return new ArrayList<Customer>();
        }
        log.info("found {} customers by name {}", customerList.size(), name);
        return customerList;
    }

    public Customer addCustomer(Customer customer) {
        log.info("Adding customer {} to database", customer.getName());
        Customer customer2 = customerRepository.save(customer);
        log.info("Added customer {} successfully", customer2.getName());
        return customer2;
    }
}
