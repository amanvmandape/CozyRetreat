package com.cozyretreat.service;

import com.cozyretreat.entity.AppUser;
import com.cozyretreat.entity.Booking;
import com.cozyretreat.payload.BookingDTO;

public interface BookingService {
    Booking addBooking(BookingDTO dto, long propertyId, AppUser users);
}
