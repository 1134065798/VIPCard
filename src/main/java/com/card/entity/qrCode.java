package com.card.entity;

/**
 * Created by ypj on 2017/11/11.
 */
public class qrCode {
    private User user;
    private String cardId;
    public qrCode(){}

    public qrCode(User user, String cardId) {
        this.user = user;
        this.cardId = cardId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

}
