package com.Barsukova_Varenik;

import java.util.List;
import java.util.Set;

public class productShop extends Shop implements Manager, Cashier, Till {

    protected double Price1=0;
    protected String Packet;

    public void Buy(String item,String price1,String amount1){
        product.add(item);
        System.out.println(item+" is bought");
        System.out.println("Price - "+price1);
        amount.add(amount1);
        getPrice(price1);
    }
    public void Selling(){
        product.stream().forEach(p -> System.out.println("Selling - "+p));
        System.out.println("Total sell "+product.size()+" product(s)");
    }
    public void Info() {
        System.out.println("Name of shop - "+name+", type of shop - "+typeOfShop+", square of shop - "+square+", address - "+address);
    }

    public void addToBasket(String item,String amount1) {
        if(product.contains(item)){
            set.add(item);
            System.out.println(item+" is add to basket");
            int i = product.indexOf(item);
            String price1= Double.toString (Double.parseDouble(price.get(i))*Double.parseDouble(amount1));
            cost.add(price1);
            UserAmount.add(amount1);
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
            int i1 = set.indexOf(item);
            String amount1= UserAmount.get(i1);
            UserAmount.remove(amount1);
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

    public void givePacket(int l) {
        switch (l){
            case 0:
                System.out.println("Basket is empty");
                break;
            case 1:
                System.out.println("Give a tiny packet");
                set.add("Tiny packet");
                UserAmount.add("1");
                cost.add("0");
                setPacket("Tiny packet");
                break;
            case 2:
                System.out.println("Give a small packet");
                set.add("Small packet");
                UserAmount.add("1");
                cost.add("0");
                setPacket("Small packet");
                break;
            case 3:
                System.out.println("Give a medium packet");
                set.add("Medium packet");
                UserAmount.add("1");
                cost.add("0");
                setPacket("Medium packet");
                break;
            case 4:
                System.out.println("Give a large packet");
                set.add("Large packet");
                UserAmount.add("1");
                cost.add("0");
                setPacket("Large packet");
                break;
            case 5:
                System.out.println("Give a extra large packet");
                set.add("Extra large packet");
                UserAmount.add("1");
                cost.add("0");
                setPacket("Extra large packet");
                break;
            default:
                System.out.println("Give a extra extra large packet");
                set.add("Extra extra large packet");
                UserAmount.add("1");
                cost.add("0");
                setPacket("Extra extra large packet");
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
    public void TakeAmount(String uamount, int j){
        int uamount1 = Integer.parseInt(uamount);

        int amount1 = Integer.parseInt(amount.get(j));
        int namount = amount1 - uamount1;
        ;
        amount.set(j, Integer.toString(namount));
    }
    public void payment() {
        for (int i=0;i< cost.size();i++){
            addToBalance(cost.get(i));
            takeFromUserBalance(cost.get(i));
        }

        for (int i=0;i< cost.size();i++){
            for (int j=0;j< product.size();j++)   {
             if(set.get(i)==product.get(j))
            TakeAmount(UserAmount.get(i), j);
            }
        }
        cost.clear();
        set.clear();
        UserAmount.clear();

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
    public List<String> getSet() {
        return set;
    }
    @Override
    public List<String> getCost() {
        return cost;
    }
    public double getPrice1(){return Price1;}

    @Override
    public List<String> getAmount() {
        return super.getAmount();
    }

    @Override
    public void setAmount(List<String> amount) {
        super.setAmount(amount);
    }

    public void setPrice1(double Price1) {
        this.Price1 = Price1;
    }

    public String getPacket(){return Packet;}


    public void setPacket(String Packet) {
        this.Packet = Packet;
    }

}
