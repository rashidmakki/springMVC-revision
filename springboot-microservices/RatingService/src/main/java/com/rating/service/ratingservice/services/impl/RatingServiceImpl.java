package com.rating.service.ratingservice.services.impl;

import com.rating.service.ratingservice.entities.Rating;
import com.rating.service.ratingservice.repositories.RatingRepository;
import com.rating.service.ratingservice.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    RatingRepository ratingRepository;

    @Override
    public List<Rating> getAllRatings() {
        return ratingRepository.findAll();
    }

    @Override
    public Rating findRatingById(String id) {
        return ratingRepository.findById(id).orElseThrow(() -> new RuntimeException("Rating not found"));
    }

    @Override
    public Rating saveRating(Rating rating) {
        return ratingRepository.save(rating);
    }

    @Override
    public List<Rating> findRatingsByUserId(String userId) {
        return ratingRepository.findRatingsByUserId(userId);
    }

    @Override
    public List<Rating> findRatingsByHotelId(String hotelId) {
        return ratingRepository.findRatingsByHotelId(hotelId);
    }
}
