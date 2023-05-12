package com.example.demo.orders;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    OrderService (OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Orders> findAll() {
        return orderRepository.findAll();
    }

    public Orders findById(Long id) {
        return orderRepository.findBySeq(id);
    }

    public OrderResponse findWithReviewById(Long id) {
        return orderRepository.findWithReviewById(id);
    }

    public boolean accept(Long id) {
        Orders order = orderRepository.findBySeq(id);
        if (order.getState()!= OrderState.COMPLETED) {
            return false;
            //    throw new IllegalStateException("이미 처리된 주문입니다.");
        }

        order.setState(OrderState.ACCEPTED);
        orderRepository.update(order);
        return true;
    }
    public boolean reject(Long id) {
        Orders order = orderRepository.findBySeq(id);
        if (order.getState()!= OrderState.REQUESTED) {
            order.setState(OrderState.REJECTED);
            orderRepository.update(order);
            return true;
        }
        return  false;
    }

    public boolean shipping(Long id) {
        Orders order = orderRepository.findBySeq(id);
        if (order.getState()== OrderState.ACCEPTED) {
            order.setState(OrderState.SHIPPING);
            orderRepository.update(order);

            return true;
        }
        return false;
    }

    public boolean complete(Long id) {
        Orders order = orderRepository.findBySeq(id);
        if (order.getState()== OrderState.SHIPPING) {
            order.setState(OrderState.COMPLETED);
            orderRepository.update(order);
            return true;
        }
        return false;
    }

}
