package org.example.uberreviewservice.Models;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@DiscriminatorValue("2")
public class PassengerReview extends Review{
    private String passengerReviewComment;
}
