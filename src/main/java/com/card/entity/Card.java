package com.card.entity;


public class Card {
    private String activeCode;
    private String cardId;

    public Card() {
    }

    public Card(String activeCode, String cardId) {
        this.activeCode = activeCode;
        this.cardId = cardId;
    }

    public String getActiveCode() {
        return activeCode;
    }

    public void setActiveCode(String activeCode) {
        this.activeCode = activeCode;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    @Override
    public String toString() {
        return "Card{" +
                "activeCode='" + activeCode + '\'' +
                ", cardId='" + cardId + '\'' +
                '}';
    }
}
