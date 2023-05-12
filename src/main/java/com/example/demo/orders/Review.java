package com.example.demo.orders;

import java.time.LocalDateTime;

public class Review {
    // seq, userSeq, productSeq, content, createAt
    private Long seq;
    private Long userSeq;
    private Long productSeq;
    private String content;
    private LocalDateTime createAt;
    Review(Long seq, Long userSeq, Long productSeq, String content, LocalDateTime createAt){
        this.seq= seq;
        this.userSeq= userSeq;
        this.productSeq= productSeq;
        this.content= content;
        this.createAt= createAt;
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

    public String getContent() {
        return content;
    }
    public LocalDateTime getCreateAt() {
        return createAt;
    }

    static class Builder {
        private Long seq;
        private Long userSeq;
        private Long productSeq;
        private String content;
        private LocalDateTime createAt;

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
        Builder content(String content) {
            this.content = content;
            return this;
        }
        Builder createAt(LocalDateTime createAt) {
            this.createAt = createAt;
            return this;
        }
        Builder fromPrototype(Review prototype) {
            seq = prototype.seq;
            userSeq = prototype.userSeq;
            productSeq = prototype.productSeq;
            content = prototype.content;
            createAt = prototype.createAt;
            return this;
        }
        Review build() {
            return new Review(seq, userSeq, productSeq, content, createAt);
        }
    }
}
