package com.example.demo.orders;

public class ReviewService {
    private ReviewRepository reviewRepository;
    private OrderRepository orderRepository;


    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }
    public void review (long id, Review review) {

        // 주문 가져 오기
        Orders order = orderRepository.findBySeq(id);

        // 주문 상태 COMPLETELD 일때 리뷰 작성 가능
        // 작성 되면 Produc review Count 값이 증가한다.
    }


}
