package com.user.service.userservice.external.services;

import com.user.service.userservice.entities.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "RATINGSERVICE")
public interface RatingService {
    @GetMapping("ratings/{ratingId}")
    Rating findRatingById(@PathVariable("ratingId") String id);
    @GetMapping("ratings/users/{userId}")
    List<Rating> findRatingsByUserId(@PathVariable("userId")String userId);
    @GetMapping("ratings/hotels/{hotelId}")
    List<Rating> findRatingsByHotelId(@PathVariable("hotelId")String hotelId);
}
