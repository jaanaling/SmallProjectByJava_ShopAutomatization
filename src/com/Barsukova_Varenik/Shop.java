package com.Barsukova_Varenik;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
import java.util.Set;

public abstract class Shop {
    protected String name;
    protected String typeOfShop;
    protected double square;
    protected String address;
    protected boolean open = false;
    protected String Balance="100.45";
    protected String userBalance;

    public void setUserBalance(String userBalance) {
        this.userBalance = userBalance;
    }
    public String getUserBalance(){
        return  userBalance;
    }

    public String getBalance() {
        return Balance;
    }

    List <String> price = new ArrayList<>();
    List <String> product = new ArrayList<>();
    List <String> cost = new ArrayList<>();
    List <String> set = new ArrayList<>();
    List <String> amount = new ArrayList<>();
    List <String> UserAmount = new ArrayList<>();

    public void setName(String name) {
        this.name = name;
    }
    public String getName(){
        return  name;
    }

    public void setTypeOfShop(String typeOfShop) {
        this.typeOfShop = typeOfShop;
    }

    public String getTypeOfShop() {
        return typeOfShop;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress(){
        return address;
    }

    public void setSquare(double square) {
        this.square = square;
    }

    public double getSquare() {
        return square;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public void setAmount(List<String> amount) {
        this.amount = amount;
    }
    public List<String> getAmount(){return amount;}

    public List<String> getCost() {
        return cost;
    }

    public List<String> getPrice() {
        return price;
    }

    public List<String> getProduct() {
        return product;
    }

    public List<String> getSet() {
        return set;
    }

    public void setBalance(String balance) {
        Balance = balance;
    }

    public void setCost(List<String> cost) {
        this.cost = cost;
    }

    public void setPrice(List<String> price) {
        this.price = price;
    }

    public void setProduct(List<String> product) {
        this.product = product;
    }

    public void setUserAmount(List<String> userAmount) {
        UserAmount = userAmount;
    }
    public List<String> getUserAmount() {
        return UserAmount;
    }
}
