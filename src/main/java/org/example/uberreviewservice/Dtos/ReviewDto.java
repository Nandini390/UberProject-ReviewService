package org.example.uberreviewservice.Dtos;

import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReviewDto {
    private Long id;
    private String content;
    private Double rating;
    private Long booking;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
