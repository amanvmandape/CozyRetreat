package com.cozyretreat.service;

import com.cozyretreat.entity.AppUser;
import com.cozyretreat.entity.Review;
import com.cozyretreat.payload.ReviewDTO;

public interface ReviewService {

    Review addReview(AppUser user, Long id, ReviewDTO dto);

    Review delById(long id);

    Review delUserReview(long id, AppUser user);

    Review updateReview(long id, AppUser user, ReviewDTO dto);

    ReviewDTO findReview(long id, AppUser user);
}
