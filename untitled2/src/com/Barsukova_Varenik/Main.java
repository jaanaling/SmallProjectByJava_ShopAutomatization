package com.Barsukova_Varenik;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import  java.awt.event.ActionEvent;
import  java.awt.event.ActionListener;

public class Main {

    public static void main(String[] args) {


        productShop shop = new productShop();

       /* shop.Info();

        shop.Closing();*/

    /*    shop.Buy("Sausages","15.4561");
        shop.Buy("Bread","5.1456");
        shop.Buy("Vegetables","7.5544");
        shop.Buy("Candies","10.65569");
        shop.Buy("Coca-cola","7.8586");
        shop.Buy("Cookies","6.5556");
        shop.Buy("Snacks","7.252565");*/

     /*   shop.Opening();*/

        /*shop.Selling();*/

       shop.setUserBalance("100.00");

       /*  shop.addToBasket("Coca-cola");
        shop.addToBasket("Pepsi");
        shop.addToBasket("Snacks");
        shop.addToBasket("Vegetables");
        shop.addToBasket("Sausages");

        shop.removeFromBasket("Vegetables");
        shop.removeFromBasket("Pepsi");*/

//        shop.givePacket();

//        shop.InfoBasket();
//
//        shop.payment();
//
//        System.out.println("Balance of shop - "+shop.getBalance());
//        System.out.println("Balance of user - "+shop.getUserBalance());


         Object[] array = new String[] { "Сахар" , "кг", "1.5" };


        JFrame start = new JFrame("Start");
        start.setBounds(900, 200, 600, 600);
        start.setLayout(null);

        JLabel label1 = new JLabel("Name");
        label1.setBounds(40,5,190,15);
        start.add(label1);

        JLabel label2 = new JLabel("Address");
        label2.setBounds(40,25,190,15);
        start.add(label2);

        JLabel label3 = new JLabel("Type");
        label3.setBounds(40,45,190,15);
        start.add(label3);

        JLabel label4 = new JLabel("Square");
        label4.setBounds(40,65,190,15);
        start.add(label4);

        JLabel label5 = new JLabel("Name: -");
        label5.setBounds(10,140+30,190,15);
        start.add(label5);

        JLabel label6 = new JLabel("Address: -");
        label6.setBounds(10,165+30,190,15);
        start.add(label6);

        JLabel label7 = new JLabel("Type: -");
        label7.setBounds(10,190+30,190,15);
        start.add(label7);

        JLabel label8 = new JLabel("Square: -");
        label8.setBounds(10,215+30,190,15);
        start.add(label8);

        JLabel labelStatus = new JLabel("Status: Close");
        labelStatus.setBounds(10,240+30,190,15);
        start.add(labelStatus);

        JLabel labelBalance = new JLabel("Balance: "+shop.getBalance()+" $");
        labelBalance.setBounds(10,265+30,190,15);
        start.add(labelBalance);

        JLabel labelUBalance = new JLabel("User Balance: "+shop.getUserBalance()+" $");
        labelUBalance.setBounds(1,525,190,15);
        start.add(labelUBalance);

        JButton button1 = new JButton("Field");
        button1.setBounds(80,100+30,110,30);
        start.add(button1);

        JButton buttonClose = new JButton("Close");
        buttonClose.setBounds(120,240+30,70,15);
        start.add(buttonClose);

        JButton buttonOpen = new JButton("Open");
        buttonOpen.setBounds(195,240+30,65,15);
        start.add(buttonOpen);

        JButton buttonProd = new JButton("Add Product");
        buttonProd.setBounds(155,100,105,15);
        start.add(buttonProd);

        JButton buttonVProd = new JButton("View Product in shop");
        buttonVProd.setBounds(5,325,255,15);
        start.add(buttonVProd);

        JButton buttonProd1 = new JButton("Add to basket");
        buttonProd1.setBounds(105,380,155,15);
        start.add(buttonProd1);

        JButton buttonRem = new JButton("Remove from basket");
        buttonRem.setBounds(105,405,155,15);
        start.add(buttonRem);

        JButton buttonPocket = new JButton("Take packet");
        buttonPocket.setBounds(5,435,255,15);
        start.add(buttonPocket);

        JButton buttonBasket = new JButton("View product(s) in basket");
        buttonBasket.setBounds(5,460,255,15);
        start.add(buttonBasket);

        JButton buttonBuy = new JButton("Buy product(s) in basket");
        buttonBuy.setBounds(5,480,255,15);
        start.add(buttonBuy);

        JButton buttonUBalance = new JButton("Set user balance");
        buttonUBalance.setBounds(5,545,255,15);
        start.add(buttonUBalance);

        JTextField field1 = new JTextField();
        field1.setBounds(115,5,110,15);
        start.add(field1);

        JTextField field2 = new JTextField();
        field2.setBounds(115,25,110,15);
        start.add(field2);

        JTextField field3 = new JTextField();
        field3.setBounds(115,45,110,15);
        start.add(field3);

        JTextField field4 = new JTextField();
        field4.setBounds(115,65,110,15);
        start.add(field4);

        JTextField fieldProd = new JTextField();
        fieldProd.setBounds(10,100,90,15);
        start.add(fieldProd);

        JTextField fieldPrice = new JTextField();
        fieldPrice.setBounds(105,100,40,15);
        start.add(fieldPrice);


        JTextField fieldProd1 = new JTextField();
        fieldProd1.setBounds(10,380,90,15);
        start.add(fieldProd1);

        JTextField fieldRem = new JTextField();
        fieldRem.setBounds(10,405,90,15);
        start.add(fieldRem);

        JTextField fieldUBalance = new JTextField();
        fieldUBalance.setBounds(150,525,90,15);
        start.add(fieldUBalance);

        JTable jTable1 = new JTable(new DefaultTableModel(1,3));
        jTable1.setBounds(280,20,300,200);
        start.add(jTable1);

        start.setVisible(true);


        ActionListener actionListener =    new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if ((field1.getText().equals("")||field2.getText().equals("")||field3.getText().equals("")||field4.getText().equals(""))||(field1.getText().equals("")&&field2.getText().equals("")&&field3.getText().equals("")&&field4.getText().equals(""))) {
                    JOptionPane.showMessageDialog(null," Not all data is entered ");

            }
            else{

                    shop.setName(field1.getText());
                    label5.setText("Name: " + shop.getName());

                    shop.setAddress(field2.getText());
                    label6.setText("Address: " + shop.getAddress());

                    shop.setTypeOfShop(field3.getText());
                    label7.setText("Type: " + shop.getTypeOfShop());

                    shop.setSquare(Double.parseDouble(field4.getText()));
                    label8.setText("Square: " + shop.getSquare());

                    JOptionPane.showMessageDialog(null, "Name of shop - " + shop.getName() + ", address of shop - " + shop.getAddress() + ", type of shop - " + shop.getTypeOfShop() + ", square of shop - " + shop.getSquare());
            }
            }
        };
        button1.addActionListener(actionListener);

        ActionListener actionListener1 =   new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (shop.isOpen() == true) {
                    shop.setOpen(false);
                    labelStatus.setText("Status: Close");
                    JOptionPane.showMessageDialog(null,"Shop is closing");
                } else {
                    JOptionPane.showMessageDialog(null,"Shop is already closed");
                }
            }
        };
        buttonClose.addActionListener(actionListener1);

        ActionListener actionListener2 =   new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (shop.isOpen() == false) {
                    shop.setOpen(true);
                    labelStatus.setText("Status: Open");
                    JOptionPane.showMessageDialog(null,"Shop is open");
                } else {
                    JOptionPane.showMessageDialog(null,"Shop is already open");
                }
            }
        };
        buttonOpen.addActionListener(actionListener2);

        ActionListener actionListener3 =   new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
        if(fieldPrice.getText()!=" " && fieldProd.getText()!=" "){
                shop.Buy(fieldProd.getText(), fieldPrice.getText());
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.addRow(new Object[]{shop.getProduct().indexOf(fieldProd.getText()), "Column 2", "Column 3"});
                JOptionPane.showMessageDialog(null,fieldProd.getText()+" is bought. Price - "+fieldPrice.getText());
        }
        else{
            JOptionPane.showMessageDialog(null," Not all data is entered ");
        }
            }
        };
        buttonProd.addActionListener(actionListener3);

        ActionListener actionListener4 =   new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                JOptionPane.showMessageDialog(null,shop.getProduct()+" in Shop. Price - "+shop.getPrice());
            }
        };
        buttonVProd.addActionListener(actionListener4);

        ActionListener actionListener5 =   new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(shop.getProduct().contains(fieldProd1.getText())){
                shop.addToBasket(fieldProd1.getText());
                JOptionPane.showMessageDialog(null,fieldProd1.getText()+" add to basket");}
                else {
                    JOptionPane.showMessageDialog(null,fieldProd1.getText()+" don't sell in this shop");
                }
            }
        };
        buttonProd1.addActionListener(actionListener5);

        ActionListener actionListener6 =   new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(shop.getSet().contains(fieldRem.getText())){
                    shop.removeFromBasket(fieldRem.getText());
                    JOptionPane.showMessageDialog(null,fieldRem.getText()+" is remove from basket");}
                else {
                    JOptionPane.showMessageDialog(null,fieldRem.getText()+" not found in basket");
                }
            }
        };
        buttonRem.addActionListener(actionListener6);

        ActionListener actionListener7 =   new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(null, shop.getSet()+" in basket");
            }
        };
        buttonBasket.addActionListener(actionListener7);

        ActionListener actionListener8 =   new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                shop.givePacket();
            }
        };
        buttonPocket.addActionListener(actionListener8);



        ActionListener actionListener9 =   new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                shop.payment();
                if (Double.parseDouble(shop.getUserBalance())>0){
                labelBalance.setText("Balance: "+ shop.getBalance()+"$");
                labelUBalance.setText("User Balance: "+ shop.getUserBalance()+"$");
                JOptionPane.showMessageDialog(null, " Product is buy");
            }
            else {
                    JOptionPane.showMessageDialog(null, " User don`t have money");
                }
            }
        };
        buttonBuy.addActionListener(actionListener9);

        ActionListener actionListener10 =   new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                shop.setUserBalance(fieldUBalance.getText());
                labelUBalance.setText("User balance: " + shop.getUserBalance()+"$");

            }
        };
        buttonUBalance.addActionListener(actionListener10);
    }
}
