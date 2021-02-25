package com.codeclan.example.bookingsystem;

import com.codeclan.example.bookingsystem.models.Booking;
import com.codeclan.example.bookingsystem.models.Course;
import com.codeclan.example.bookingsystem.models.Customer;
import com.codeclan.example.bookingsystem.repositories.BookingRepository;
import com.codeclan.example.bookingsystem.repositories.CourseRepository;
import com.codeclan.example.bookingsystem.repositories.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase
@SpringBootTest
class BookingsystemApplicationTests {

	@Autowired
	BookingRepository bookingRepository;

	@Autowired
	CourseRepository courseRepository;

	@Autowired
	CustomerRepository customerRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void canFindCourseByRating() {
		List<Course> foundCourses = courseRepository.findCourseNameByRating(5);
		assertEquals("Professional Software Development", foundCourses.get(0).getName());
	}

	@Test
	public void canFindCustomerByCourse() {
		List<Customer> foundCustomers = customerRepository.findAllByBookingsCourseId(2L);
		assertEquals("Ewan", foundCustomers.get(0).getName());
	}

	@Test
	public void canFindCoursesByGivenCustomer() {
		List<Course> foundCourses = courseRepository.findAllByBookingsCustomerId(1L);
		assertEquals("Professional Data Analysis", foundCourses.get(0).getName());
	}

	@Test
	public void canFindBookingsByDate() {
		List<Booking> foundBookings = bookingRepository.findAllBookingsByDate("25-2-21");
		assertEquals(1, foundBookings.size());
	}

}
