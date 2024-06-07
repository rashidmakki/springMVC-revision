package com.user.service.userservice.external.services;

import com.user.service.userservice.entities.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "HOTELSERVICE")
public interface HotelService {
    @GetMapping("hotels/{hotelId}")
    Hotel findHotelById(@PathVariable("hotelId") String id);
}
