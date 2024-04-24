package com.cozyretreat.controller;

import com.cozyretreat.entity.AppUser;
import com.cozyretreat.entity.Favourite;
import com.cozyretreat.service.FavouriteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/app/fav")
@RequiredArgsConstructor
public class FavouriteController {

    private final FavouriteService favouriteService;

    @PostMapping("/property/{id}/set")
    public ResponseEntity<Favourite> setFavourite(
            @AuthenticationPrincipal AppUser user,
            @PathVariable("id") long id)
    {
        Favourite favourite = favouriteService.setFavourite(user, id);
        return new ResponseEntity<>(favourite, HttpStatus.CREATED);
    }

    @GetMapping("/user/wishlist")
    public ResponseEntity<List<Favourite>> getUserWishlist(@AuthenticationPrincipal AppUser user)
    {
        List<Favourite> favourites = favouriteService.getUserWishlist(user);
        return new ResponseEntity<>(favourites, HttpStatus.OK);
    }
}
