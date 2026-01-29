package org.example.uberreviewservice.Adapters;

import org.example.uberreviewservice.Dtos.CreateReviewDto;
import org.example.uberreviewservice.Models.Booking;
import org.example.uberreviewservice.Models.Review;
import org.example.uberreviewservice.Repositories.BookingRepository;
import org.example.uberreviewservice.Repositories.ReviewRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CreaterReviewDtoToReviewAdapterImpl implements CreateReviewDtoToReviewAdapter{

    private BookingRepository bookingRepository;

    public CreaterReviewDtoToReviewAdapterImpl(BookingRepository bookingRepository){
        this.bookingRepository=bookingRepository;
    }
    @Override
    public Review convertDto(CreateReviewDto createReviewDto) {
        Optional<Booking> booking= bookingRepository.findById(createReviewDto.getBookingId());
        return booking.map(value-> Review.builder()
                           .rating(createReviewDto.getRating())
                           .booking(booking.get())
                           .content(createReviewDto.getContent())
                           .build()).orElse(null);
    }
}
