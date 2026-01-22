package org.example.uberreviewservice.Models;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@DiscriminatorValue("1")
@PrimaryKeyJoinColumn(name="driver_review_Id")
public class DriverReview extends Review{
    private String driverReviewComment;
}
