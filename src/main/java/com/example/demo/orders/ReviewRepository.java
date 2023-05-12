package com.example.demo.orders;

import java.util.Optional;

public interface ReviewRepository {
    Review save(Review review);
    Optional<Review> findById(long id);
}
