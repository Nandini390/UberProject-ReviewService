package org.example.uberreviewservice.Repositories;

import org.example.uberreviewservice.Models.Booking;
import org.example.uberreviewservice.Models.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface DriverRepository extends JpaRepository<Driver, Long> {
        Optional<Driver> findByIdAndLicenseNumber(Long Id, String LicenseNumber);

        //raw sql
        @Query(nativeQuery = true, value="SELECT * FROM driver WHERE id= :id AND license_number= :license")
        Optional<Driver> rawFindByIdAndLicenseNumber(Long id, String license);


        //hibernate Ql
//        @Query("SELECT d FROM Driver as d where id= :id AND licenseNumber= :license")
//        Optional<Driver> hqlFindByIdAndLicense(Long id, String license);
        //OR
        @Query("FROM Driver as d where id= :id AND licenseNumber= :license")
        Optional<Driver> hqlFindByIdAndLicense(Long id, String license);
}
