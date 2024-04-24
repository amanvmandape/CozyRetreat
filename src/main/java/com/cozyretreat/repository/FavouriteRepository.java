package com.cozyretreat.repository;

import com.cozyretreat.entity.AppUser;
import com.cozyretreat.entity.Favourite;
import com.cozyretreat.entity.Property;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FavouriteRepository extends JpaRepository<Favourite, Long> {

    Favourite findByAppUserAndProperty(AppUser appUser, Property property);

    boolean existsByAppUserAndProperty(AppUser appUser, Property property);

    List<Favourite> findByAppUser(AppUser appUser);

}