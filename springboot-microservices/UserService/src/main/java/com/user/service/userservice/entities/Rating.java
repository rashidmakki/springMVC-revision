package com.user.service.userservice.entities;

import lombok.*;
import org.springframework.data.annotation.Transient;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Rating {
    private String ratingId;
    private String userId;
    private String hotelId;
    private int rating;
    private String feedback;
    private Hotel hotelDetails;
}
