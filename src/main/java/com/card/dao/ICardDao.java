package com.card.dao;


import com.card.entity.Card;

public interface ICardDao {
    public Card findCard(String activeCode);
    public int deleteCard(String cardId);
}
