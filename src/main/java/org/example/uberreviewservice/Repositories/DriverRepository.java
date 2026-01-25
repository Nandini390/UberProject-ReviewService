package org.example.uberreviewservice.Repositories;

import org.example.uberreviewservice.Models.Booking;
import org.example.uberreviewservice.Models.CustomDriver;
import org.example.uberreviewservice.Models.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface DriverRepository extends JpaRepository<Driver, Long> {

        Optional<Driver> findByIdAndLicenseNumber(Long Id, String LicenseNumber);

        //raw SQL
        @Query(nativeQuery = true, value="SELECT * FROM driver WHERE id= :id AND license_number= :ln")
        Optional<Driver> rawFindByIdAndLicenseNumber(@Param("id") Long id, @Param("ln") String license);
          //OR

        //This can only work with DTO
//        @Query(nativeQuery=true, value="SELECT d.id, d.license_number FROM driver as d WHERE d.id= :id AND d.license_number= :license")
//        Optional<Driver> rawFindByIdAndLicenseNumber(Long id, String license);



        //hibernate Ql
//         @Query("SELECT d FROM Driver as d WHERE d.id= :id AND d.licenseNumber= :license")
//         Optional<Driver> hqlFindByIdAndLicense(Long id, String license);
        //OR
//        @Query("FROM Driver as d where id= :id AND licenseNumber= :license")
//        Optional<Driver> hqlFindByIdAndLicense(Long id, String license);
        //OR

        //This only works with DTO
//        @Query("SELECT d.id, d.name, d.createdAt FROM Driver as d where d.id= :id AND d.licenseNumber= :license")
//        Optional<Driver> hqlFindByIdAndLicense(Long id, String license);
        //OR

        @Query("SELECT new org.example.uberreviewservice.Models.CustomDriver(d.id,d.name) FROM Driver as d WHERE d.id= :id AND d.licenseNumber= :license")
        Optional<CustomDriver> hqlFindByIdAndLicense(Long id, String license);



}
