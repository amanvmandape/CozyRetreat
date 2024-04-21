package com.cozyretreat.service;

import com.cozyretreat.entity.AppUser;
import com.cozyretreat.entity.Property;
import com.cozyretreat.entity.Review;
import com.cozyretreat.payload.ReviewDTO;
import com.cozyretreat.repository.PropertyRepository;
import com.cozyretreat.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;
    private final PropertyRepository propertyRepository;

    @Override
    public Review addReview(AppUser user, Long id, ReviewDTO dto) {
        Optional<Property> opt = propertyRepository.findById(id);
        if(opt.isPresent())
        {
            Property property = opt.get();
            if(!reviewRepository.existsByPropertyAndAppUser(property, user))
            {
                Review review = new Review();
                review.setRating(dto.getRating());
                review.setContent(dto.getContent());
                review.setAppUser(user);
                review.setProperty(property);
                return reviewRepository.save(review);
            }
        }
        return null;
    }

    @Override
    public Review delById(long id) {
        Optional<Review> opt = reviewRepository.findById(id);
        if(opt.isPresent())
        {
            Review review = opt.get();
            reviewRepository.delete(review);
            return review;
        }
        return null;
    }

    @Override
    public Review delUserReview(long id, AppUser user) {
        Optional<Property> opt = propertyRepository.findById(id);
        if(opt.isPresent())
        {
            Property property = opt.get();
            if(reviewRepository.existsByPropertyAndAppUser(property, user))
            {
                Review review = reviewRepository.findByPropertyAndAppUser(property, user).get();
                reviewRepository.delete(review);
                return review;
            }
        }
        return null;
    }

    @Override
    public Review updateReview(long id, AppUser user, ReviewDTO dto) {
        Optional<Property> opt = propertyRepository.findById(id);
        if (opt.isPresent()) {
            Property property = opt.get();
            if (reviewRepository.existsByPropertyAndAppUser(property, user)) {
                Review review = reviewRepository.findByPropertyAndAppUser(property, user).get();
                review.setRating(dto.getRating());
                review.setContent(dto.getContent());
                reviewRepository.save(review);
                return review;
            }
        }
        return null;
    }

    @Override
    public ReviewDTO findReview(long id, AppUser user) {
        Optional<Property> opt = propertyRepository.findById(id);
        if (opt.isPresent()) {
            Property property = opt.get();
            if (reviewRepository.existsByPropertyAndAppUser(property, user)) {
                Review review = reviewRepository.findByPropertyAndAppUser(property, user).get();
                ReviewDTO dto = new ReviewDTO();
                dto.setRating(review.getRating());
                dto.setContent(review.getContent());
                return dto;
            }
        }
        return null;
    }
}
