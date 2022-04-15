package com.Barsukova_Varenik;

import java.util.List;
import java.util.Set;

public class productShop extends Shop implements Manager, Cashier, Till {

    public void Buy(String item,String price1){
        product.add(item);
        System.out.println(item+" is bought");
        System.out.println("Price - "+price1);
        getPrice(price1);
    }
    public void Selling(){
        product.stream().forEach(p -> System.out.println("Selling - "+p));
        System.out.println("Total sell "+product.size()+" product(s)");
    }
    public void Info() {
        System.out.println("Name of shop - "+name+", type of shop - "+typeOfShop+", square of shop - "+square+", address - "+address);
    }

    public void addToBasket(String item) {
        if(product.contains(item)){
            set.add(item);
            System.out.println(item+" is add to basket");
            int i = product.indexOf(item);
            String price1= price.get(i);
            cost.add(price1);
        }
       else{
            System.out.println(item+" don't sell in this shop");
        }
    }
    public void removeFromBasket(String item){
        if(set.contains(item)){
            set.remove(item);
            int i = product.indexOf(item);
            String price1= price.get(i);
            cost.remove(price1);
            System.out.println(item+" is remove from basket");
        }
        else{
            System.out.println(item+" not found in basket");
        }

    }
    public void Opening() {
        if(open==false){
            open=true;
            System.out.println("Shop is open");
        }
        else{
            System.out.println("Shop is already open");
        }
    }
    public void Closing() {
        if (open == true) {
            open = false;
            System.out.println("Shop is closed");
        } else {
            System.out.println("Shop is already closed");
        }
    }

    public void givePacket() {
        switch (set.size()){
            case 0:
                System.out.println("Basket is empty");
                break;
            case 1:
                System.out.println("Give a tiny packet");
                set.add("Tiny packet");
                break;
            case 2:
                System.out.println("Give a small packet");
                set.add("Small packet");
                break;
            case 3:
                System.out.println("Give a medium packet");
                set.add("Medium packet");
                break;
            case 4:
                System.out.println("Give a large packet");
                set.add("Large packet");
                break;
            case 5:
                System.out.println("Give a extra large packet");
                set.add("Extra large packet");
                break;
            default:
                System.out.println("Give a extra extra large packet");
                set.add("Extra extra large packet");
                break;
        }
    }

    public void InfoBasket(){
        System.out.println(set+" - content of basket");
    }

    public void addToBalance(String money) {
        double money1 = Double.parseDouble(money);
        money = String.format("%.2f",money1);
        String[] MoneySplit = money.split(",");
        int integer = Integer.parseInt(MoneySplit[0]);
        int fraction = Integer.parseInt(MoneySplit[1]);
        double Balance1 = Double.parseDouble(Balance);
        Balance = String.format("%.2f",Balance1);
        String[] BalanceSplit = Balance.split(",");
        int integerBalance = Integer.parseInt(BalanceSplit[0]);
        int fractionBalance = Integer.parseInt(BalanceSplit[1]);
        integerBalance+=integer;
        fractionBalance+=fraction;
        if(fractionBalance>99){
            integerBalance+=fractionBalance/100;
            fractionBalance%=100;
        }
        Balance=Integer.toString(integerBalance)+"."+Integer.toString(fractionBalance);
    }
    public void takeFromUserBalance(String money){
        double money1 = Double.parseDouble(money);
        double Balance1 = Double.parseDouble(userBalance);
        money = String.format("%.2f",money1);
        userBalance = String.format("%.2f",Balance1);
        String[] MoneySplit = money.split(",");
        int integer = Integer.parseInt(MoneySplit[0]);
        int fraction = Integer.parseInt(MoneySplit[1]);
        String[] BalanceSplit = userBalance.split(",");
        int integerBalance = Integer.parseInt(BalanceSplit[0]);
        int fractionBalance = Integer.parseInt(BalanceSplit[1]);
        if(fractionBalance<fraction){
                integerBalance-=1;
                fractionBalance+=100;
        }
        integerBalance-=integer;
        fractionBalance-=fraction;
        userBalance=Integer.toString(integerBalance)+"."+Integer.toString(fractionBalance);

    }
    public void payment() {
        for (int i=0;i< cost.size();i++){
            addToBalance(cost.get(i));
            takeFromUserBalance(cost.get(i));
        }
        cost.clear();
        set.clear();

    }

    public void getPrice(String price1) {
        price.add(price1);
    }

    @Override
    public double getSquare() {
        return super.getSquare();
    }

    @Override
    public String getAddress() {
        return super.getAddress();
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public String getTypeOfShop() {
        return super.getTypeOfShop();
    }
    @Override
    public boolean isOpen() {
        return open;
    }
    @Override
    public void setOpen(boolean open) {
        this.open = open;
    }
    @Override
    public java.util.List<String> getPrice() {
        return price;
    }
    @Override
    public List<String> getProduct() {
        return product;
    }
    @Override
    public Set<String> getSet() {
        return set;
    }
    @Override
    public List<String> getCost() {
        return cost;
    }
}
