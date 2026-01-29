package org.example.uberreviewservice.Adapters;

import lombok.Getter;
import lombok.Setter;
import org.example.uberreviewservice.Dtos.CreateReviewDto;
import org.example.uberreviewservice.Models.Review;

public interface CreateReviewDtoToReviewAdapter {
     public Review convertDto(CreateReviewDto createReviewDto);
}
