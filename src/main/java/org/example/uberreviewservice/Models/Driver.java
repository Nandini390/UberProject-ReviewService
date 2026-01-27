package org.example.uberreviewservice.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

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

    //1:n, driver:booking
//    1. @OneToMany(mappedBy = "driver", fetch = FetchType.EAGER)
    @OneToMany(mappedBy = "driver", fetch = FetchType.LAZY)
    @Fetch(FetchMode.SUBSELECT)
    private List<Booking> bookings= new ArrayList<>();
}
