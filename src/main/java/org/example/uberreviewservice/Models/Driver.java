package org.example.uberreviewservice.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Driver extends BaseModel{
    private String name;

    @Column(nullable = false, unique = true)
    private String licenseNumber;

    @OneToMany
    private List<Booking> bookings= new ArrayList<>();
}
