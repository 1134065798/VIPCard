package com.card.service.impl;


import com.card.dao.ICardDao;
import com.card.entity.Card;
import com.card.service.ICardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("cardService")
public class CardService implements ICardService{
    @Autowired
    private ICardDao cardDao;

    @Transactional(propagation= Propagation.REQUIRES_NEW,
            isolation= Isolation.READ_COMMITTED,
            readOnly=true, timeout=60000)
    public Card findCard(String activeCode){
        Card card=new Card();
        card=cardDao.findCard(activeCode);
        return card;
    }

    @Transactional(propagation= Propagation.REQUIRED,timeout=60000)
    public boolean deleteCard(String cardId){
        boolean bool=false;
        if(cardDao.deleteCard(cardId)==1){
            bool=true;
        }
        return bool;
    }
}
