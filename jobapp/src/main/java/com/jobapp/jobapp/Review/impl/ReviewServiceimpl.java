package com.jobapp.jobapp.Review.impl;

import com.jobapp.jobapp.Company.Company;
import com.jobapp.jobapp.Company.CompanyService;
import com.jobapp.jobapp.Review.Review;
import com.jobapp.jobapp.Review.ReviewRepository;
import com.jobapp.jobapp.Review.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceimpl implements ReviewService {

    private final ReviewRepository reviewRepository;
    private final CompanyService companyService;

    public ReviewServiceimpl(ReviewRepository reviewRepository, CompanyService companyService) {
        this.reviewRepository = reviewRepository;
        this.companyService = companyService;
    }

    @Override
    public List<Review> getAllReviews(Long companyId) {
        List<Review> reviews = reviewRepository.findByCompanyId(companyId);
        return reviews;
    }

    @Override
    public boolean addReview(Long companyId, Review review) {
        Company company = companyService.getCompanyById(companyId);
        if(company != null) {
            review.setCompany(company);
            reviewRepository.save(review);
            return true;
        }
        return false;
    }

    @Override
    public Review getReview(Long companyId, Long reviewId) {
        List<Review> reviews = reviewRepository.findByCompanyId(companyId);
        return reviews.stream().filter(review -> review.getId().equals(reviewId)).findFirst().orElse(null);
    }

    @Override
    public boolean updateReview(Long companyId, Long reviewId, Review updatedReview) {
        if (companyService.getCompanyById(companyId) != null) {
            Optional<Review> existingReview = reviewRepository.findById(reviewId);
            if (existingReview.isPresent()) {
                updatedReview.setCompany(companyService.getCompanyById(companyId));
                updatedReview.setId(reviewId);
                reviewRepository.save(updatedReview);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean deletedReview(Long companyId, Long reviewId) {
        if(companyService.getCompanyById(companyId) != null && reviewRepository.existsById(reviewId)) {
            Review review = reviewRepository.findById(reviewId).orElse(null);
            Company company = review.getCompany();
            company.getReviews().remove(review);
            review.setCompany(null);
            companyService.updateCompany(company, companyId);
            reviewRepository.deleteById(reviewId);
            return true;
        }
        return false;
    }
}
