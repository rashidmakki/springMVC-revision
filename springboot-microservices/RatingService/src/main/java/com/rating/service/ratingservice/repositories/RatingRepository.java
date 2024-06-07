package com.rating.service.ratingservice.repositories;

import com.rating.service.ratingservice.entities.Rating;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository extends MongoRepository<Rating, String> {
    List<Rating> findRatingsByUserId(String userId);
    List<Rating> findRatingsByHotelId(String hotelId);
}
