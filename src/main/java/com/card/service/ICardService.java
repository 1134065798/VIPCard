package com.card.service;


import com.card.entity.Card;

public interface ICardService {
    public Card findCard(String activeCode);
    public boolean delectCard(String cardId);
}
