package com.codeclan.example.bookingsystem.controllers;

import com.codeclan.example.bookingsystem.models.Course;
import com.codeclan.example.bookingsystem.repositories.CourseRepository;
import com.codeclan.example.bookingsystem.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    CustomerRepository customerRepository;


    // GET /courses?rating=1
    // GET /courses?customerId=1

    @GetMapping(value = "/courses")
    public ResponseEntity <List<Course>> getAllCoursesAndFilters(

            @RequestParam(required = false, name = "rating") Integer rating,
            @RequestParam(required = false, name = "customerId") Long Id
    ){
        if (rating != null){
            return new ResponseEntity<>(courseRepository.findCourseNameByRating(rating), HttpStatus.OK);
        }
        if (Id != null){
            return new ResponseEntity<>(courseRepository.findAllByBookingsCustomerId(Id), HttpStatus.OK);
        }
        return new ResponseEntity<>(courseRepository.findAll(), HttpStatus.OK);

    }
}
