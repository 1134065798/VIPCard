package com.card.dao;

import com.card.entity.VipCard;

public interface IVipCardDao {
    public int saveVipCard(VipCard vipCard);
    public VipCard loadqrCodeByopenId(String openId);
    //二维码新添加
    public String findCardIdByOpenId(String openId);
}
