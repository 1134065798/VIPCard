package com.card.service.impl;


import com.card.dao.IVipCardDao;
import com.card.entity.VipCard;
import com.card.service.IVipCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("vipCardService")
public class VipCardService implements IVipCardService{
    @Autowired
    private IVipCardDao vipCardDao;

    @Transactional(propagation= Propagation.REQUIRED,timeout=60000)
    public boolean saveVipCard(VipCard vipCard){
        boolean bool=false;
        if (vipCardDao.saveVipCard(vipCard)==1){
            bool=true;
        }
        return bool;
    }

    @Transactional(propagation= Propagation.REQUIRES_NEW,
            isolation= Isolation.READ_COMMITTED,
            readOnly=true, timeout=60000)
    public VipCard loadqrCodeByopenId(String openId) {

        return vipCardDao.loadqrCodeByopenId(openId);
    }

    @Transactional(propagation= Propagation.REQUIRES_NEW,
            isolation= Isolation.READ_COMMITTED,
            readOnly=true, timeout=60000)
    public String findCardIdByOpenId(String openId) {
        return vipCardDao.findCardIdByOpenId(openId);
    }
}
