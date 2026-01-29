package org.example.uberreviewservice.Services;

import org.example.uberreviewservice.Models.Review;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ReviewService {

    public Optional<Review> findReviewById(Long reviewId);

    public List<Review> findAllReviews();

    public boolean deleteReviewById(Long id);

    public Review createReview(Review request);

    public Review updateReview(Long id, Review request);
}
