package com.example.demo.orders;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/orders")
public class OrderRestController {
    private final OrderService orderService;
    OrderRestController (OrderService orderService) {
        this.orderService = orderService;
    }
  // TODO findAll, findById, accept, reject, shipping, complete 메소드 구현이 필요합니다.
    // findAll 구현
    @GetMapping
    @Transactional(readOnly = true)
    public ResponseEntity<Map<String, Object>> findAll() {
        // 주문 목록을 가져온다.
        List<Orders> orderList = orderService.findAll();
        Map<String, Object> result = new HashMap<>();
        result.put("result", orderList);
        return ResponseEntity.ok(result);
    }

    // findById 구현
    @GetMapping("/{id}")
    @Transactional(readOnly = true)
    public ResponseEntity<Map<String, Object>> findById(@PathVariable Long id) {
        OrderResponse order = orderService.findWithReviewById(id);
        Map<String, Object> result = new HashMap<>();
        result.put("result", order);
        return ResponseEntity.ok(result);
    }

    // accept 구현

    @PatchMapping("/{id}/accept")
    @Transactional
    public ResponseEntity<Map<String, Object>> accept (@PathVariable Long id) {
        boolean result = orderService.accept(id);
        Map<String, Object> result2 = new HashMap<>();
        result2.put("result", result);
        return ResponseEntity.ok(result2);
    }


    // reject 구현
    @PatchMapping("/{id}/reject")
    @Transactional
    public ResponseEntity<Map<String, Object>> reject(@PathVariable Long id) {
        boolean result = orderService.reject(id);
        Map<String, Object> result2 = new HashMap<>();
        result2.put("result", result);
        return ResponseEntity.ok(result2);
    }

    // shipping 구현
    @PatchMapping("/{id}/shipping")
    @Transactional
    public ResponseEntity<Map<String, Object>> shipping(@PathVariable Long id) {
        boolean result = orderService.shipping(id);
        Map<String, Object> result2 = new HashMap<>();
        result2.put("result", result);
        return ResponseEntity.ok(result2);
    }

    // complete 구현

    @PatchMapping("/{id}/complete")
    @Transactional
    public ResponseEntity<Map<String, Object>> complete(@PathVariable Long id) {
        boolean result = orderService.complete(id);
        Map<String, Object> result2 = new HashMap<>();
        result2.put("result", result);
        return ResponseEntity.ok(result2);
    }



}