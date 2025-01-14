package com.async.nonblocking.springboot_async_nonblocking_demo.controller;

import com.async.nonblocking.springboot_async_nonblocking_demo.business.AsyncService;
import com.async.nonblocking.springboot_async_nonblocking_demo.business.FileService;
import com.async.nonblocking.springboot_async_nonblocking_demo.domain.Customer;
import com.async.nonblocking.springboot_async_nonblocking_demo.domain.FileData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@Slf4j
@RequestMapping("/nonblocking")
public class NonBlockingController {

    @Autowired
    AsyncService asyncService;

    @Autowired
    FileService fileService;

    @GetMapping("/customers/{name}")
    public CompletableFuture<List<Customer>> getCustomerByName(@PathVariable String name) {
        log.info("Getting customer by name {} ", name);
        CompletableFuture<List<Customer>> listCompletableFuture = asyncService.getCustomerByName(name);
        return listCompletableFuture;
    }

    @PostMapping("/customers/save")
    public CompletableFuture<Customer> addCustomer(@RequestBody Customer customer) {
        log.info("Adding user {} to the Database", customer.getName());
        return asyncService.saveCustomer(customer);
    }

    @GetMapping("/fileread")
    public CompletableFuture<String> readFile() {
        log.info("reading file request");
        return asyncService.readFile();
    }

    @PostMapping("/filewrite")
    public CompletableFuture<Boolean> writeFile(@RequestBody FileData fileData) {
        log.info("Write data {} to File", fileData);
        return asyncService.writeFile(fileData);
    }


}
