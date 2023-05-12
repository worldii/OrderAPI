package com.example.demo.orders;

import java.util.List;

public interface OrderRepository {
    Order findBySeq(Long seq);
    List<Order> findAll();
    OrderResponse findWithReviewById(Long id);
    boolean update (Order order);
}
