package org.example.uberreviewservice.Models;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="BookingReview")
@Getter
@Setter
@Builder // for object creation, it needs below 2 constructor
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="review_type", discriminatorType = DiscriminatorType.INTEGER)
public class Review extends BaseModel{

    @Column(nullable = false)
    private String content;

    private double rating;

    @Override
    public String toString(){
        return "Review: " + this.content + " " + this.rating + " " + this.createdAt;
    }
}