package org.example.uberreviewservice.Services;

import org.example.uberreviewservice.Models.Booking;
import org.example.uberreviewservice.Models.Driver;
import org.example.uberreviewservice.Models.Review;
import org.example.uberreviewservice.Repositories.BookingRepository;
import org.example.uberreviewservice.Repositories.DriverRepository;
import org.example.uberreviewservice.Repositories.ReviewRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewService implements CommandLineRunner{
    private ReviewRepository reviewRepository;
    private BookingRepository bookingRepository;
    private DriverRepository driverRepository;

    public ReviewService(ReviewRepository reviewRepository, BookingRepository bookingRepository, DriverRepository driverRepository){
        this.reviewRepository=reviewRepository;
        this.bookingRepository=bookingRepository;
        this.driverRepository=driverRepository;
    }

    @Override
    public void run(String... args) throws Exception {
//        Review r= Review
//                .builder()
//                .content("Amazing ride quality")
//                .rating(5.0)
//                .build();  // code to create plain java object
//
//        Booking b= Booking
//                .builder()
//                .endTime(LocalDateTime.now())
//                .review(r)
//                .build();
//
////        reviewRepository.save(r);   //this code executes sql query
//        bookingRepository.save(b);
//
//        List<Review> reviews= reviewRepository.findAll();
//
//        for(Review review: reviews){
//            System.out.println(r.getContent());
//        }
//
////        reviewRepository.deleteById(2L);
//
//
//        Optional<Booking> b2=bookingRepository.findById(3L);
//        if(b2.isPresent()){
//            bookingRepository.delete(b2.get());
//        }

         Optional<Driver> driver= driverRepository.findById(1l);
         if(driver.isPresent()){
             System.out.println(driver.get().getName());
//             List<Booking> bookings= bookingRepository.findAllByDriverId(1l);
//             for(Booking booking: bookings){
//                 System.out.println(booking.getBookingStatus());
//             }
         }

         Optional<Booking> bookins=bookingRepository.findById(1l);
         //in this query lot of joins are going on, all which are OneToOne and ManyToOne mapped,driver, booking_review,passenger, passengerReview
    }
}
