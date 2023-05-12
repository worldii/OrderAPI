package com.example.demo.orders;

public enum OrderState {
    //REQUESTED, REJECTED, COMPLETED, ACCEPTED, SHIPPING,;

    REQUESTED("REQUESTED"),
    REJECTED("REJECTED"),
    COMPLETED("COMPLETED"),
    ACCEPTED("ACCEPTED"),
    SHIPPING("SHIPPING");

    private String state;
    OrderState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}
