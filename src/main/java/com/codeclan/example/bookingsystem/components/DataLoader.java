package com.codeclan.example.bookingsystem.components;

import com.codeclan.example.bookingsystem.models.Booking;
import com.codeclan.example.bookingsystem.models.Course;
import com.codeclan.example.bookingsystem.models.Customer;
import com.codeclan.example.bookingsystem.repositories.BookingRepository;
import com.codeclan.example.bookingsystem.repositories.CourseRepository;
import com.codeclan.example.bookingsystem.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {
    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    CustomerRepository customerRepository;

    public DataLoader() {
    }

    public void run(ApplicationArguments args) {
        Customer max = new Customer("Max", "Edinburgh", 25);
        customerRepository.save(max);

        Customer ewan = new Customer("Ewan", "Edinburgh", 18);
        customerRepository.save(ewan);

        Customer hannah = new Customer("Hannah", "Crailarich", 24);
        customerRepository.save(hannah);

        Course PDA = new Course("PDA", "Edinburgh", 3);
        courseRepository.save(PDA);

        Course softwareDevelopment = new Course("Professional Software Development", "Glasgow", 5);
        courseRepository.save(softwareDevelopment);

        Course dataAnalysis = new Course("Professional Data Analysis", "Auchtermuchty", 1);
        courseRepository.save(dataAnalysis);

        Booking booking1 = new Booking("25-2-21", ewan, softwareDevelopment);
        bookingRepository.save(booking1);

        Booking booking2 = new Booking("26-2-21", max, dataAnalysis);
        bookingRepository.save(booking2);

        Booking booking3 = new Booking("26-2-21", hannah, PDA);
        bookingRepository.save(booking3);

    }
}
