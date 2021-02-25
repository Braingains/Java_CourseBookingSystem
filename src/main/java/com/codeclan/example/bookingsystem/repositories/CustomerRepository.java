package com.codeclan.example.bookingsystem.repositories;

import com.codeclan.example.bookingsystem.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    List<Customer> findAllByBookingsCourseId (Long Id);
    //course_id is stored in bookings table
}