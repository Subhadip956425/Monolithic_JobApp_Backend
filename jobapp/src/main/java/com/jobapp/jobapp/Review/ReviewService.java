package com.jobapp.jobapp.Review;

import java.util.List;

public interface ReviewService {
    List<Review> getAllReviews(Long companyId);

    boolean addReview(Long companyId, Review review);

    Review getReview(Long companyId, Long reviewId);

    boolean updateReview(Long companyId, Long reviewId, Review updatedReview);

    boolean deletedReview(Long companyId, Long reviewId);
}
