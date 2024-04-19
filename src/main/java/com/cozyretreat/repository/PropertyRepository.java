package com.cozyretreat.repository;

import com.cozyretreat.entity.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PropertyRepository extends JpaRepository<Property, Long> {
    @Query("select p from Property p join p.location l join p.country c where l.locationName=:place or c.countryName=:place")
    List<Property> listPropertyByLocationOrCountry(@Param("place") String place);
}