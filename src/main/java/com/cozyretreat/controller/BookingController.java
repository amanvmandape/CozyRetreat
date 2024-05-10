package com.cozyretreat.controller;

import com.cozyretreat.entity.AppUser;
import com.cozyretreat.entity.Booking;
import com.cozyretreat.payload.BookingDTO;
import com.cozyretreat.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("app/booking")
public class BookingController {

    private final BookingService bookService;


    @PostMapping("/add")
    public ResponseEntity<Booking> addBooking(
            @AuthenticationPrincipal AppUser user,
            @RequestBody BookingDTO dto,
            @RequestParam("propertyid") long propertyId
            )
    {
        Booking booking = bookService.addBooking(dto, propertyId, user);
        return new ResponseEntity<>(booking, HttpStatus.CREATED);
    }
}
