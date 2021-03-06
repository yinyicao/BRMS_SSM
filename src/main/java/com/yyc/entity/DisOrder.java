package com.yyc.entity;

import java.util.Date;

/**
 * @program: SSM
 * @description: 订单实体
 * @author: yyc
 * @create: 2019-11-22 16:43
 **/
public class DisOrder {
    private int id;
    private int disNo;
    private int bookNo;
    private Date ordDateTime;
    private int ordNumber;
    private int ordOperateUser;
    private double ordPrice;
    private double ordTotalPrice;
    private String ordStatus;
    private Date ordEndDateTime;
    private int isCancel; //是否已经取消订单

    public DisOrder() { //需要实体类有无参构造方法,否者MyBatis会报nested exception is org.apache.ibatis.executor.ExecutorException: No constructor found in com.yyc.entity.DisOrder matching
    }

    public DisOrder(int disNo, int bookNo, Date ordDateTime, int ordNumber, int ordOperateUser,
                    double ordPrice, double ordTotalPrice, String ordStatus) {
        this.disNo = disNo;
        this.bookNo = bookNo;
        this.ordDateTime = ordDateTime;
        this.ordNumber = ordNumber;
        this.ordOperateUser = ordOperateUser;
        this.ordPrice = ordPrice;
        this.ordTotalPrice = ordTotalPrice;
        this.ordStatus = ordStatus;
    }

    public DisOrder(int id, int disNo, int bookNo, Date ordDateTime, int ordNumber,
                    int ordOperateUser, double ordPrice, double ordTotalPrice, String ordStatus,
                    Date ordEndDateTime, int isCancel) {
        this.id = id;
        this.disNo = disNo;
        this.bookNo = bookNo;
        this.ordDateTime = ordDateTime;
        this.ordNumber = ordNumber;
        this.ordOperateUser = ordOperateUser;
        this.ordPrice = ordPrice;
        this.ordTotalPrice = ordTotalPrice;
        this.ordStatus = ordStatus;
        this.ordEndDateTime = ordEndDateTime;
        this.isCancel = isCancel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDisNo() {
        return disNo;
    }

    public void setDisNo(int disNo) {
        this.disNo = disNo;
    }

    public int getBookNo() {
        return bookNo;
    }

    public void setBookNo(int bookNo) {
        this.bookNo = bookNo;
    }

    public Date getOrdDateTime() {
        return ordDateTime;
    }

    public void setOrdDateTime(Date ordDateTime) {
        this.ordDateTime = ordDateTime;
    }

    public int getOrdNumber() {
        return ordNumber;
    }

    public void setOrdNumber(int ordNumber) {
        this.ordNumber = ordNumber;
    }

    public int getOrdOperateUser() {
        return ordOperateUser;
    }

    public void setOrdOperateUser(int ordOperateUser) {
        this.ordOperateUser = ordOperateUser;
    }

    public double getOrdPrice() {
        return ordPrice;
    }

    public void setOrdPrice(double ordPrice) {
        this.ordPrice = ordPrice;
    }

    public double getOrdTotalPrice() {
        return ordTotalPrice;
    }

    public void setOrdTotalPrice(double ordTotalPrice) {
        this.ordTotalPrice = ordTotalPrice;
    }

    public String getOrdStatus() {
        return ordStatus;
    }

    public void setOrdStatus(String ordStatus) {
        this.ordStatus = ordStatus;
    }

    public Date getOrdEndDateTime() {
        return ordEndDateTime;
    }

    public void setOrdEndDateTime(Date ordEndDateTime) {
        this.ordEndDateTime = ordEndDateTime;
    }

    public int getIsCancel() {
        return isCancel;
    }

    public void setIsCancel(int isCancel) {
        this.isCancel = isCancel;
    }

    @Override
    public String toString() {
        return "DisOrder{" +
                "id=" + id +
                ", disNo=" + disNo +
                ", bookNo=" + bookNo +
                ", ordDateTime=" + ordDateTime +
                ", ordNumber=" + ordNumber +
                ", ordOperateUser=" + ordOperateUser +
                ", ordPrice=" + ordPrice +
                ", ordTotalPrice=" + ordTotalPrice +
                ", ordStatus='" + ordStatus + '\'' +
                '}';
    }
}
