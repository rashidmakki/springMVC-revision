package com.hotel.service.hotelservice.services;

import com.hotel.service.hotelservice.entities.Hotel;

import java.util.List;

public interface HotelService {
    Hotel addHotel(Hotel hotel);

    Hotel getHotelById(String id);

    List<Hotel> getAllHotels();
}