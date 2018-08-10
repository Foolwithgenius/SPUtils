package com.example.clp.sharedpreferencesutils;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by 大鹏 on 2018/5/4.
 */

public class UserBean implements Serializable {
    @Expose
    @SerializedName("all_money")
    private int all_money;
    @Expose
    @SerializedName("user_phone")
    private String user_phone;
    @Expose
    @SerializedName("evaluation")
    private String evaluvtion;
    @Expose
    @SerializedName("money_freeze")
    private int money_freeze;
    @Expose
    @SerializedName("capital_collection")
    private int capital_collection;
    @Expose
    @SerializedName("can_use_money")
    private int can_use_money;
    @Expose
    @SerializedName("interest")
    private int interest;
    @Expose
    @SerializedName("interest_collection")
    private int interest_collection;
    @Expose
    @SerializedName("id_status")
    private int id_status;
    @Expose
    @SerializedName("phone_status")
    private String phone_status;
    @Expose
    @SerializedName("bank_status")
    private int bank_status;
    @Expose
    @SerializedName("login_pass_status")
    private int login_pass_status;
    @Expose
    @SerializedName("pin_pass_status")
    private int pin_pass_status;
    @Expose
    @SerializedName("kfphone")
    private String kfphone;

    public int getAll_money() {
        return all_money;
    }

    public void setAll_money(int all_money) {
        this.all_money = all_money;
    }

    public int getCan_use_money() {
        return can_use_money;
    }

    public void setCan_use_money(int can_use_money) {
        this.can_use_money = can_use_money;
    }

    public int getInterest() {
        return interest;
    }

    public void setInterest(int interest) {
        this.interest = interest;
    }

    public int getInterest_collection() {
        return interest_collection;
    }

    public void setInterest_collection(int interest_collection) {
        this.interest_collection = interest_collection;
    }

    public int getId_status() {
        return id_status;
    }

    public void setId_status(int id_status) {
        this.id_status = id_status;
    }

    public String getPhone_status() {
        return phone_status;
    }

    public void setPhone_status(String phone_status) {
        this.phone_status = phone_status;
    }

    public int getBank_status() {
        return bank_status;
    }

    public void setBank_status(int bank_status) {
        this.bank_status = bank_status;
    }

    public int getLogin_pass_status() {
        return login_pass_status;
    }

    public void setLogin_pass_status(int login_pass_status) {
        this.login_pass_status = login_pass_status;
    }

    public int getPin_pass_status() {
        return pin_pass_status;
    }

    public void setPin_pass_status(int pin_pass_status) {
        this.pin_pass_status = pin_pass_status;
    }

    public String getKfphone() {
        return kfphone;
    }

    public void setKfphone(String kfphone) {
        this.kfphone = kfphone;
    }


    public int getMoney_freeze() {
        return money_freeze;
    }

    public void setMoney_freeze(int money_freeze) {
        this.money_freeze = money_freeze;
    }

    public int getCapital_collection() {
        return capital_collection;
    }

    public void setCapital_collection(int capital_collection) {
        this.capital_collection = capital_collection;
    }

    public String getUser_phone() {
        return user_phone;
    }

    public void setUser_phone(String user_phone) {
        this.user_phone = user_phone;
    }

    public String getEvaluvtion() {
        return evaluvtion;
    }

    public void setEvaluvtion(String evaluvtion) {
        this.evaluvtion = evaluvtion;
    }
}
