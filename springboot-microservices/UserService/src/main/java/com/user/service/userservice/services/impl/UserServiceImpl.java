package com.user.service.userservice.services.impl;

import com.user.service.userservice.entities.Hotel;
import com.user.service.userservice.entities.Rating;
import com.user.service.userservice.entities.User;
import com.user.service.userservice.external.services.HotelService;
import com.user.service.userservice.external.services.RatingService;
import com.user.service.userservice.repositories.UserRepository;
import com.user.service.userservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    RatingService ratingService;

    @Autowired
    HotelService hotelService;

    @Override
    public User saveUser(User user) {
        String userId = UUID.randomUUID().toString();
        user.setUserId(userId);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(String userId) {
        User user = userRepository.findById(userId).orElseThrow(()-> new RuntimeException("User Not Found with Id : "+userId ));
        List<Rating> ratingList = ratingService.findRatingsByUserId(userId);
        ratingList.stream().forEach(rating -> {
            Hotel hotel = hotelService.findHotelById(rating.getHotelId());
            rating.setHotelDetails(hotel);
        });
        user.setRatings(ratingList);
        return user;
    }
}
