package org.example.uberreviewservice.Controllers;

import org.example.uberreviewservice.Adapters.CreateReviewDtoToReviewAdapter;
import org.example.uberreviewservice.Dtos.CreateReviewDto;
import org.example.uberreviewservice.Dtos.ReviewDto;
import org.example.uberreviewservice.Models.Review;
import org.example.uberreviewservice.Services.ReviewService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/review")
public class ReviewController {
    private ReviewService reviewService;
    private CreateReviewDtoToReviewAdapter createReviewDtoToReviewAdapter;
    public ReviewController(ReviewService reviewService, CreateReviewDtoToReviewAdapter createReviewDtoToReviewAdapter){
        this.reviewService=reviewService;
        this.createReviewDtoToReviewAdapter=createReviewDtoToReviewAdapter;
    }

    @PostMapping
    public ResponseEntity<? > publishReview(@RequestBody CreateReviewDto request){
        Review incomingReview= createReviewDtoToReviewAdapter.convertDto(request);
        if(incomingReview==null){
            return new ResponseEntity<>("Invalid Arguments",HttpStatus.BAD_REQUEST);
        }
        Review review= reviewService.createReview(incomingReview);
        ReviewDto response = ReviewDto.builder()
                .id(review.getId())
                .rating(review.getRating())
                .content(review.getContent())
                .booking(review.getBooking().getId())
                .createdAt(review.getCreatedAt())
                .updatedAt(review.getUpdatedAt())
                .build();
       return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Review>> getAllReviews(){
        List<Review> reviews=reviewService.findAllReviews();
        return new ResponseEntity<>(reviews,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getReviewById(@PathVariable Long id){
        try{
            Optional<Review> review=reviewService.findReviewById(id);
            return new ResponseEntity<>(review,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteReviewById(@PathVariable Long id){
        try{
            boolean isDeleted= reviewService.deleteReviewById(id);
            if(!isDeleted){
                return new ResponseEntity<>("Unable to find Review",HttpStatus.INTERNAL_SERVER_ERROR);
            }
            return new ResponseEntity<>("Review deleted successfully",HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateReview(Long id, @RequestBody Review request){
        try{
            Review review=reviewService.updateReview(id,request);
            return new ResponseEntity<>(review,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Unable to update review",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
