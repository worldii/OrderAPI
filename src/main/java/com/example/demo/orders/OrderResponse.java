package com.example.demo.orders;

import java.time.LocalDateTime;

public class OrderResponse {

    private long  seq;
    private long productId;
    private Review review;
    private OrderState state;
    private String requestMessage;
    private String rejectMessage;
    private LocalDateTime completedAt;
    private LocalDateTime rejectedAt;
    private LocalDateTime createdAt;
    OrderResponse (long seq, long productId, OrderState state, String requestMessage, String rejectMessage, LocalDateTime completedAt, LocalDateTime rejectedAt, LocalDateTime createdAt) {
        this.seq = seq;
        this.productId = productId;
        this.state = state;
        this.requestMessage = requestMessage;
        this.rejectMessage = rejectMessage;
        this.completedAt = completedAt;
        this.rejectedAt = rejectedAt;
        this.createdAt = createdAt;
    }

    public void setReview(Review review) {
        this.review = review;
    }


    static class Builder {
        private long seq;
        private long productId;
        private OrderState state;
        private String requestMessage;
        private String rejectMessage;
        private LocalDateTime completedAt;
        private LocalDateTime rejectedAt;
        private LocalDateTime createdAt;

        public Builder seq(long seq) {
            this.seq = seq;
            return this;
        }
        public Builder productId(long productId) {
            this.productId = productId;
            return this;
        }
        public Builder state(OrderState state) {
            this.state = state;
            return this;
        }
        public Builder requestMessage(String requestMessage) {
            this.requestMessage = requestMessage;
            return this;
        }
        public Builder rejectMessage(String rejectMessage) {
            this.rejectMessage = rejectMessage;
            return this;
        }
        public Builder completedAt(LocalDateTime completedAt) {
            this.completedAt = completedAt;
            return this;
        }
        public Builder rejectedAt(LocalDateTime rejectedAt) {
            this.rejectedAt = rejectedAt;
            return this;
        }
        public Builder createdAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }
        public OrderResponse build() {
            OrderResponse orderResponse = new OrderResponse(seq, productId, state, requestMessage, rejectMessage, completedAt, rejectedAt, createdAt);
            return orderResponse;
        }

    }

}
