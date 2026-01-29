package org.example.uberreviewservice.Repositories;

import org.example.uberreviewservice.Models.Booking;
import org.example.uberreviewservice.Models.Driver;
import org.example.uberreviewservice.Models.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking,Long> {

//    @Query("SELECT r from Booking b inner join Review r on b.review=r WHERE b.Id=:bookingId")
//    Review findByBookingId(Long bookingId);
}
