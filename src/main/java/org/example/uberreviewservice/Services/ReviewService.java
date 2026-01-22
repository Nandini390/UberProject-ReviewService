package org.example.uberreviewservice.Services;

import org.example.uberreviewservice.Models.Review;
import org.example.uberreviewservice.Repositories.ReviewRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService implements CommandLineRunner{
    private ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository){
        this.reviewRepository=reviewRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Review r= Review
                .builder()
                .content("Amazing ride quality")
                .rating(5.0)
                .build();  // code to create plain java object

        System.out.println(r);
        reviewRepository.save(r);   //this code executes sql query

        List<Review> reviews= reviewRepository.findAll();

        for(Review review: reviews){
            System.out.println(r.getContent());
        }

        reviewRepository.deleteById(2L);
    }
}
