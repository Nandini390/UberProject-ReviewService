package org.example.uberreviewservice.Repositories;

import org.example.uberreviewservice.Models.Booking;
import org.example.uberreviewservice.Models.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DriverRepository extends JpaRepository<Driver, Long> {
        Optional<Driver> findByIdAndLicenseNumber(Long Id, String LicenseNumber);
}
