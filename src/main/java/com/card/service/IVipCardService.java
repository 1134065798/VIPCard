package com.card.service;


import com.card.entity.VipCard;

public interface IVipCardService {
    public boolean saveVipCard(VipCard vipCard);
    public VipCard loadqrCodeByopenId(String openId);
    //二维码新添加
    public String findCardIdByOpenId(String openId);
}
