package com.card.service.impl;


import com.card.dao.ICardDao;
import com.card.entity.Card;
import com.card.service.ICardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("cardService")
public class CardService implements ICardService{
    @Autowired
    private ICardDao cardDao;

    public Card findCard(String activeCode){
        Card card=new Card();
        card=cardDao.findCard(activeCode);
        return card;
    }

    public boolean delectCard(String cardId){
        boolean bool=false;
        if(cardDao.delectCard(cardId)==1){
            bool=true;
        }
        return bool;
    }
}
