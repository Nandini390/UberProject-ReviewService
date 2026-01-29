package org.example.uberreviewservice.Models;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Fetch;

@Entity
@Table(name="Booking_Review")
@Getter
@Setter
@Builder // for object creation, it needs below 2 constructor
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
//@DiscriminatorColumn(name="review_type", discriminatorType = DiscriminatorType.INTEGER)
public class Review extends BaseModel{

    @Column(nullable = false)
    private String content;

    @Column(nullable = true)
    private Double rating;

    //we have moved this mapping to review from booking as review cannot exist w/o a booking_id
    @OneToOne(cascade = {CascadeType.ALL}, fetch =FetchType.LAZY)
    @JoinColumn(nullable = false)
    private Booking booking; // we have defined a 1:1 relationship between booking and review

    @Override
    public String toString(){
        return "Review: " + this.content + " " + this.rating + " " + this.createdAt;
    }
}