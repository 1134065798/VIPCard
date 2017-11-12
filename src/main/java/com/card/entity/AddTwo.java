package com.card.entity;

/**
 * Created by ypj on 2017/10/29.
 */
public class AddTwo {
    private User user;
    private VipCard vipCard;
    private String ctime;
    public AddTwo(){}

    public AddTwo(User user, VipCard vipCard, String ctime) {
        this.user = user;
        this.vipCard = vipCard;
        this.ctime = ctime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public VipCard getVipCard() {
        return vipCard;
    }

    public void setVipCard(VipCard vipCard) {
        this.vipCard = vipCard;
    }

    public String getCtime() {
        return ctime;
    }

    public void setCtime(String ctime) {
        this.ctime = ctime;
    }

    @Override
    public String toString() {
        return "{" +
                "user=" + user +
                ", vipCard=" + vipCard +
                ", ctime='" + ctime + '\'' +
                '}';
    }
}
