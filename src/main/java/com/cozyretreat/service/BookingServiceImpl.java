package com.cozyretreat.service;

import com.cozyretreat.entity.AppUser;
import com.cozyretreat.entity.Booking;
import com.cozyretreat.entity.Property;
import com.cozyretreat.payload.BookingDTO;
import com.cozyretreat.repository.BookingRepository;
import com.cozyretreat.repository.PropertyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {
    private final BookingRepository bookRepository;
    private final PropertyRepository propertyRepository;

    public Booking addBooking(BookingDTO dto, long propertyId, AppUser user)
    {
        Booking booking = new Booking();
        booking.setAppUser(user);
        Property property = propertyRepository.findById(propertyId).get();
        booking.setProperty(property);
        booking.setCheckInDate(dto.getCheckInDate());
        booking.setCheckOutDate(dto.getCheckOutDate());
        int days = booking.getCheckOutDate().getDayOfYear() - booking.getCheckInDate().getDayOfYear();
        double price = days * property.getNightlyPrice();
        double totalPrice = price + price * 0.18;
        booking.setTotalPrice(totalPrice);
        Booking savedBook = bookRepository.save(booking);
        return savedBook;
    }
}
