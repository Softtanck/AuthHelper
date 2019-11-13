package com.example.demo1.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * 用户数据,转存数据库
 */
@Entity
@Table(name = "user_account")
public class UserAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //卡密
    private String cardNumber;
    //用户名
    private String userName;
    //过期时间
    private Date expireTime;
    //用户密码
    private String userPassword;
    //绑定的机器码
    private String bindNumber;
    //解除绑定次数
    private int tieBindNumber;
    //是否过期
    private boolean isExpired;
    //最后一次登录时间
    private Date lastLoginTime;

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getBindNumber() {
        return bindNumber;
    }

    public void setBindNumber(String bindNumber) {
        this.bindNumber = bindNumber;
    }

    public int getTieBindNumber() {
        return tieBindNumber;
    }

    public void setTieBindNumber(int tieBindNumber) {
        this.tieBindNumber = tieBindNumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }

    public boolean isExpired() {
        return isExpired = expireTime != null ? expireTime.before(new Date()) : isExpired;
    }

    public void setExpired(boolean expired) {
        isExpired = expired;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    @Override
    public String toString() {
        return "UserAccount{" +
                "id=" + id +
                ", cardNumber='" + cardNumber + '\'' +
                ", userName='" + userName + '\'' +
                ", expireTime=" + expireTime +
                ", userPassword='" + userPassword + '\'' +
                ", bindNumber='" + bindNumber + '\'' +
                ", tieBindNumber=" + tieBindNumber +
                ", isExpired=" + isExpired +
                ", lastLoginTime=" + lastLoginTime +
                '}';
    }
}
