package com.cozyretreat.controller;

import com.cozyretreat.entity.AppUser;
import com.cozyretreat.entity.Review;
import com.cozyretreat.payload.ReviewDTO;
import com.cozyretreat.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/app/reviews")
public class ReviewController {
    private final ReviewService reviewService;

    @PostMapping("/property/{id}/add")
    public ResponseEntity<?> addReview(@AuthenticationPrincipal AppUser user,
                                            @PathVariable("id") long id,
                                            @RequestBody ReviewDTO dto)
    {
        Review review = reviewService.addReview(user, id, dto);
        if(review != null)
        {
            return new ResponseEntity<>(review, HttpStatus.OK);
        }
        return new ResponseEntity<>("Cannot create review",HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/delete")
    public ResponseEntity<?> deleteReviewById(@RequestParam long id)
    {
        Review review = reviewService.delById(id);
        if(review!= null)
        {
            return new ResponseEntity<>(review, HttpStatus.OK);
        }
        return new ResponseEntity<>("Cannot delete review",HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/property/{id}/delete")
    public ResponseEntity<?> deleteUserReview(@AuthenticationPrincipal AppUser user, @PathVariable("id") long id)
    {
        Review review = reviewService.delUserReview(id, user);
        if(review!= null)
        {
            return new ResponseEntity<>(review, HttpStatus.OK);
        }
        return new ResponseEntity<>("Cannot delete review",HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/property/{id}/update")
    public ResponseEntity<?> updateReview(@AuthenticationPrincipal AppUser user,
                                          @PathVariable("id") long id,
                                          @RequestBody ReviewDTO dto)
    {
        Review review = reviewService.updateReview(id, user, dto);
        if(review!= null)
        {
            return new ResponseEntity<>(review, HttpStatus.OK);
        }
        return new ResponseEntity<>("Cannot update review",HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/property/{id}/find")
    public ResponseEntity<?> findReview(@AuthenticationPrincipal AppUser user,
                                          @PathVariable("id") long id)
    {
        ReviewDTO dto = reviewService.findReview(id, user);
        if(dto!= null)
        {
            return new ResponseEntity<>(dto, HttpStatus.OK);
        }
        return new ResponseEntity<>("Cannot update review",HttpStatus.BAD_REQUEST);
    }
}
