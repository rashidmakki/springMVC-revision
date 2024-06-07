package com.rating.service.ratingservice.controllers;

import com.rating.service.ratingservice.entities.Rating;
import com.rating.service.ratingservice.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    private RatingService ratingService;


    @PostMapping
    public ResponseEntity<Rating> createUser(@RequestBody Rating rating) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.saveRating(rating));
    }

    @GetMapping("/{ratingId}")
    public ResponseEntity<Rating> getRating(@PathVariable String ratingId) {
        return ResponseEntity.ok(ratingService.findRatingById(ratingId));
    }

    @GetMapping("users/{userId}")
    public ResponseEntity<List<Rating>> findRatingByUserId(@PathVariable String userId) {
        return ResponseEntity.ok(ratingService.findRatingsByUserId(userId));
    }

    @GetMapping("hotels/{hotelId}")
    public ResponseEntity<List<Rating>> findRatingByHotelId(@PathVariable String hotelId) {
        return ResponseEntity.ok(ratingService.findRatingsByHotelId(hotelId));
    }

    @GetMapping
    public ResponseEntity<List<Rating>> getAllRatings() {
        return ResponseEntity.ok(ratingService.getAllRatings());
    }

}
