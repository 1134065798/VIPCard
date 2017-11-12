package com.card.entity;

/**
 * Created by ypj on 2017/10/26.
 */
public class VipCard {

    private String cardId;
    private String openId;
    private String qrCode;
    private String createTime;

    public VipCard(){}

    public VipCard(String cardId, String openId, String qrCode, String createTime) {
        this.cardId = cardId;
        this.openId = openId;
        this.qrCode = qrCode;
        this.createTime = createTime;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "VipCard{" +
                "cardId='" + cardId + '\'' +
                ", openId='" + openId + '\'' +
                ", qrCode='" + qrCode + '\'' +
                ", createTime='" + createTime + '\'' +
                '}';
    }
}
