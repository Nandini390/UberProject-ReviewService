package org.example.uberreviewservice.Models;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@DiscriminatorValue("1")
public class DriverReview extends Review{
    private String driverReviewComment;
}
