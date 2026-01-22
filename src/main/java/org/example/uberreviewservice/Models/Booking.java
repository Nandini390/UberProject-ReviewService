package org.example.uberreviewservice.Models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Booking extends BaseModel{

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private Review review; // we have defined a 1:1 relationship between booking and review

    @Enumerated(value= EnumType.STRING)
    private BookingStatus bookingStatus;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private Long totalDistance;
}
