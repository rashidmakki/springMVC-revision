package com.rating.service.ratingservice.services;

import com.rating.service.ratingservice.entities.Rating;

import java.util.List;

public interface RatingService {
    List<Rating> getAllRatings();
    Rating findRatingById(String id);
    Rating saveRating(Rating rating);
    List<Rating> findRatingsByUserId(String userId);
    List<Rating> findRatingsByHotelId(String hotelId);
}
