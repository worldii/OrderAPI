package com.example.demo.orders;

import java.time.LocalDateTime;

public class Order {
    // seq, userSeq, productSeq, reviewSeq, state(enum), requestMsg, rejectMsg, completedAt, rejectedAt, createdAt
    private Long seq;
    private Long userSeq;
    private Long productSeq;
    private Long reviewSeq;
    private OrderState state;
    private String requestMsg;
    private String rejectMsg;
    private LocalDateTime completedAt;
    private LocalDateTime rejectedAt;
    private LocalDateTime createdAt;

    public Order(Long seq, Long userSeq, Long productSeq, Long reviewSeq, OrderState state, String requestMsg, String rejectMsg, LocalDateTime completedAt, LocalDateTime rejectedAt, LocalDateTime createdAt) {
        this.seq = seq;
        this.userSeq = userSeq;
        this.productSeq = productSeq;
        this.reviewSeq = reviewSeq;
        this.state = state;
        this.requestMsg = requestMsg;
        this.rejectMsg = rejectMsg;
        this.completedAt = completedAt;
        this.rejectedAt = rejectedAt;
        this.createdAt = createdAt;
    }
    public OrderState getState() {
        return state;
    }

    public Long getSeq() {
        return seq;
    }
    public Long getUserSeq() {
        return userSeq;
    }
    public Long getProductSeq() {
        return productSeq;
    }
    public Long getReviewSeq() {
        return reviewSeq;
    }

    public String getRequestMsg() {
        return requestMsg;
    }
    public String getRejectMsg() {
        return rejectMsg;
    }
    public LocalDateTime getCompletedAt() {
        return completedAt;
    }
    public LocalDateTime getRejectedAt() {
        return rejectedAt;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setState(OrderState orderState) {
        this.state = orderState;
    }


    static class Builder {
        private Long seq;
        private Long userSeq;
        private Long productSeq;
        private Long reviewSeq;
        private OrderState state;
        private String requestMsg;
        private String rejectMsg;
        private LocalDateTime completedAt;
        private LocalDateTime rejectedAt;
        private LocalDateTime createdAt;

        Builder seq(Long seq) {
            this.seq = seq;
            return this;
        }

        Builder userSeq(Long userSeq) {
            this.userSeq = userSeq;
            return this;
        }

        Builder productSeq(Long productSeq) {
            this.productSeq = productSeq;
            return this;
        }

        Builder reviewSeq(Long reviewSeq) {
            this.reviewSeq = reviewSeq;
            return this;
        }

        Builder state(OrderState state) {
            this.state = state;
            return this;
        }
        Builder requestMsg(String requestMsg) {
            this.requestMsg = requestMsg;
            return this;
        }
        Builder rejectMsg(String rejectMsg) {
            this.rejectMsg = rejectMsg;
            return this;
        }
        Builder completedAt(LocalDateTime completedAt) {
            this.completedAt = completedAt;
            return this;
        }
        Builder rejectedAt(LocalDateTime rejectedAt) {
            this.rejectedAt = rejectedAt;
            return this;
        }
        Builder createdAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        Order build() {
            return new Order(seq, userSeq, productSeq, reviewSeq, state, requestMsg, rejectMsg, completedAt, rejectedAt, createdAt);
        }

    }

    // to String 직접 구현

}
