package com.example.demo.orders;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/orders")
public class ReviewRestController {
  // TODO review 메소드 구현이 필요합니다.

    private final ReviewService reviewService;
    public ReviewRestController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping("/{id}/review")
    public Map<String, Object> review (@RequestBody ReviewRequest reviewRequest) {

        Map<String, Object> result = new HashMap<>();


        return result;
    }

}