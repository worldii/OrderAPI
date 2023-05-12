package com.example.demo.orders;

import java.util.List;

public interface OrderRepository {
    Orders findBySeq(Long seq);
    List<Orders> findAll();
    OrderResponse findWithReviewById(Long id);
    boolean update (Orders order);
}
