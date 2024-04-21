package com.cozyretreat.repository;

import com.cozyretreat.entity.AppUser;
import com.cozyretreat.entity.Property;
import com.cozyretreat.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Map;
import java.util.Optional;

public interface ReviewRepository extends JpaRepository<Review, Long> {


    Boolean existsByPropertyAndAppUser(Property property, AppUser appUser);

    Optional<Review> findByPropertyAndAppUser(Property property, AppUser user);
}