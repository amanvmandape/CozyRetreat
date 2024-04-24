package com.cozyretreat.service;

import com.cozyretreat.entity.AppUser;
import com.cozyretreat.entity.Favourite;

import java.util.List;

public interface FavouriteService {
    Favourite setFavourite(AppUser user, long id);

    List<Favourite> getUserWishlist(AppUser user);
}
