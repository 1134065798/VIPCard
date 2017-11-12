package com.card.service.impl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.card.service.IVipCardService;
import com.card.entity.VipCard;
import com.card.dao.IVipCardDao;

@Service("vipCardService")
public class VipCardService implements IVipCardService{
    @Autowired
    private IVipCardDao vipCardDao;

    public boolean saveVipCard(VipCard vipCard){
        boolean bool=false;
        if (vipCardDao.insert(vipCard)==1){
            bool=true;
        }
        return bool;
    }
    public VipCard loadqrCodeByopenId(String openId) {

        return vipCardDao.loadqrCodeByopenId(openId);
    }

    public String findCardIdByOpenId(String openId) {
        return vipCardDao.findCardIdByOpenId(openId);
    }
}
