package com.cozyretreat.service;

import com.cozyretreat.entity.AppUser;
import com.cozyretreat.entity.Favourite;
import com.cozyretreat.entity.Property;
import com.cozyretreat.repository.FavouriteRepository;
import com.cozyretreat.repository.PropertyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FavouriteServiceImpl implements FavouriteService {
    private final FavouriteRepository favouriteRepository;
    private final PropertyRepository propertyRepository;
    @Override
    public Favourite setFavourite(AppUser user, long id) {
        if(propertyRepository.existsById(id))
        {
            Property property = propertyRepository.findById(id).get();
            Favourite favourite;
            if(favouriteRepository.existsByAppUserAndProperty(user, property))
            {
                favourite = favouriteRepository.findByAppUserAndProperty(user, property);
                favouriteRepository.deleteById(favourite.getId());
            }
            else
            {
                favourite = new Favourite();
                favourite.setAppUser(user);
                favourite.setProperty(property);
                return favouriteRepository.save(favourite);
            }
        }
        return null;
    }

    @Override
    public List<Favourite> getUserWishlist(AppUser user) {
        return favouriteRepository.findByAppUser(user);
    }
}
