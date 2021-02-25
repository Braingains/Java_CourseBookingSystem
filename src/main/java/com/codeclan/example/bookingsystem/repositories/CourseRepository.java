package com.codeclan.example.bookingsystem.repositories;

import com.codeclan.example.bookingsystem.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    List<Course> findCourseNameByRating (Integer rating);

    List<Course> findAllByBookingsCustomerId (Long Id);
}
