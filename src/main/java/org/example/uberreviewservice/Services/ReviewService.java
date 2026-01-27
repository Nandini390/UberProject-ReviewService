package org.example.uberreviewservice.Services;

import jakarta.transaction.Transactional;
import org.example.uberreviewservice.Models.Booking;
import org.example.uberreviewservice.Models.Driver;
import org.example.uberreviewservice.Repositories.BookingRepository;
import org.example.uberreviewservice.Repositories.DriverRepository;
import org.example.uberreviewservice.Repositories.ReviewRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
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
    @Transactional
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
 //        Optional<Booking> b2= bookingRepository.findById(3l);                                                /*1. */
 //        if(b2.isPresent()){                                                   /*1. */
 //            bookingRepository.delete(b2.get());                               /*1. */
//        }                                                                      /*1.*/




//        Optional<Driver> driver= driverRepository.findByIdAndLicenseNumber(1l, "DL1212");        /*2*/
//        if(driver.isPresent()){                                                                                   /*2*/
//            System.out.println(driver.get().getName());                                                           /*2*/
//            List<Booking> bookings= bookingRepository.findAllByDriverId(1l);                                      /*2*/
//            for(Booking booking: bookings){                                                                       /*2*/
//                System.out.println(booking.getBookingStatus());                                                   /*2*/
//            }
//        }




//        Optional<Driver> driver= driverRepository.findById(1l);                      /*3*/
//        if(driver.isPresent()){                                                      /*3*/
//            System.out.println(driver.get().getName());                             /*3*/
//            List<Booking> bookings= bookingRepository.findAllByDriverId(1l);         /*3*/
//             for(Booking booking: bookings){                                         /*3*/
//                 System.out.println(booking.getBookingStatus());                     /*3*/
//             }                                                                       /*3*/
//        }                                                                            /*3*/
//    }                                                                                /*3*/
//
//    Optional<Booking> bookins=bookingRepository.findById(1l);                        /*3*/
//    //in this query lot of joins are going on, all which are OneToOne and ManyToOne mapped,driver, booking_review,passenger, passengerReview






//         Optional<Driver> driver= driverRepository.findById(1l);                /*4*/
//         if(driver.isPresent()){                                                /*4*/
//             System.out.println(driver.get().getName());                        /*4*/
//             List<Booking> b= driver.get().getBookings();                       /*4*/
//             for(Booking booking: b){                                           /*4*/
//                 System.out.println(booking.getId());                           /*4*/
//             }                                                                  /*4*/
//         }



//        Optional<Driver> d=driverRepository.rawFindByIdAndLicenseNumber(1l, "DL1212");   /*5*/
//        System.out.println(d.get().getName());                                                      /*5*/
//
//        Optional<Driver> d2= driverRepository.hqlFindByIdAndLicense(1l,"DL1212");        /*5*/
//        System.out.println(d2.get().getName());                                                     /*5*/


        List<Long> driver_ids=new ArrayList<>(Arrays.asList(1L, 2L));
        List<Driver> drivers= driverRepository.findAllByIdIn(driver_ids);
//        List<Booking> bookings=bookingRepository.findAllByDriverIn(drivers);
//        bookings.forEach(booking -> System.out.println(booking.getId()));

        for(Driver driver:drivers){
            List<Booking> bookings=driver.getBookings();
            bookings.forEach(booking -> System.out.println(booking.getId()));
        }
    }
}
