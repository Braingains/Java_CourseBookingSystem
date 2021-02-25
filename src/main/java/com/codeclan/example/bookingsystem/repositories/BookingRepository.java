package com.codeclan.example.bookingsystem.repositories;

import com.codeclan.example.bookingsystem.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository <Booking, Long> {
}
