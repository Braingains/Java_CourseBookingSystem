package com.codeclan.example.bookingsystem.controllers;

import com.codeclan.example.bookingsystem.models.Customer;
import com.codeclan.example.bookingsystem.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    // GET /customers?course=PDA

    @GetMapping(value = "/customers")
    public ResponseEntity <List<Customer>> getAllCustomersAndFilters (

            @RequestParam(required = false, name = "course") Long Id
    ){
        if (Id != null){
            return new ResponseEntity<>(customerRepository.findAllByBookingsCourseId(Id), HttpStatus.OK);
        }

        return new ResponseEntity<>(customerRepository.findAll(), HttpStatus.OK);

    }
}
