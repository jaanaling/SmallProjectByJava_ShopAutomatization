package com.Barsukova_Varenik;
import java.io.Console;
import java.sql.Connection;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import  java.awt.event.ActionEvent;
import  java.awt.event.ActionListener;

import java.sql.*;

public class Main {




    public static void main(String[] args) {



        productShop shop = new productShop();
 int c=0;
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

        try {
            //connection to database
            Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/product", "root", "root");
            System.out.println("Подключение успешно установлено");
            //create statement
            Statement myStmt = myConn.createStatement();

            //execute sql query
            ResultSet myRs = myStmt.executeQuery("SELECT * FROM `price`");
            while (myRs.next()) {
                shop.setPrice1(Double.parseDouble(myRs.getString("price")));
                //results set
            }

        }
        catch (Exception exc) {
            System.out.println("Подключение не удалось");
            exc.printStackTrace();
        }


        try {
            //connection to database
            Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/product", "root", "root");
            System.out.println("Подключение успешно установлено");
            //create statement
            Statement myStmt = myConn.createStatement();

            //execute sql query
            ResultSet myRs = myStmt.executeQuery("SELECT * FROM `Balance`");
            while (myRs.next()) {
                shop.setBalance(String.valueOf(myRs.getString("balance")));
                //results set
            }

        }
        catch (Exception exc) {
            System.out.println("Подключение не удалось");
            exc.printStackTrace();
        }


        try {
            //connection to database
            Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/product", "root", "root");
            System.out.println("Подключение успешно установлено");
            //create statement
            Statement myStmt = myConn.createStatement();

            //execute sql query
            ResultSet myRs = myStmt.executeQuery("SELECT * FROM `UBalance`");
            while (myRs.next()) {
                shop.setUserBalance(String.valueOf(myRs.getString("ubalance")));
                //results set
            }

        }
        catch (Exception exc) {
            System.out.println("Подключение не удалось");
            exc.printStackTrace();
        }



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

        JLabel labelCost = new JLabel("Cost: "+shop.getPrice1() +"$");
        labelCost.setBounds(280,525,190,15);
        start.add(labelCost);

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
        fieldProd.setBounds(10,100,60,15);
        start.add(fieldProd);

        JTextField fieldPrice = new JTextField();
        fieldPrice.setBounds(75,100,40,15);
        start.add(fieldPrice);


        JTextField fieldProd1 = new JTextField();
        fieldProd1.setBounds(10,380,60,15);
        start.add(fieldProd1);

        JTextField fieldRem = new JTextField();
        fieldRem.setBounds(10,405,90,15);
        start.add(fieldRem);

        JTextField fieldUBalance = new JTextField();
        fieldUBalance.setBounds(150,525,90,15);
        start.add(fieldUBalance);

        JTextField fieldAmount = new JTextField();
        fieldAmount.setBounds(120,100,30,15);
        start.add(fieldAmount);

        JTextField fieldUAmount = new JTextField();
        fieldUAmount.setBounds(73,380,30,15);
        start.add(fieldUAmount);

       Object[] columnsHeader = new String[] {"Наименование", "Ед.измерения",
                "Количество","Amount"};
        Object[][] array = new String[][] {{ "ID" , "Name", "Price","Amount" }};


        JTable jTable1 = new JTable(new DefaultTableModel(array, columnsHeader));
        jTable1.setBounds(280,20,300,200);
        start.add(jTable1);


        JTable jTable2 = new JTable(new DefaultTableModel(array, columnsHeader));
        jTable2.setBounds(280,300,300,200);
        start.add(jTable2);

        start.setVisible(true);





            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        try {
            //connection to database
            Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/product", "root", "root");
            System.out.println("Подключение успешно установлено");
            //create statement
            Statement myStmt = myConn.createStatement();

            //execute sql query
            ResultSet myRs = myStmt.executeQuery("SELECT * FROM `product`");

            //results set

            while (myRs.next()) {

                model.addRow(new Object[]{myRs.getString("ID") , myRs.getString("Name") , myRs.getString("Price") , myRs.getString("Amount")});
            }
        }
        catch (Exception exc) {
            System.out.println("Подключение не удалось");
            exc.printStackTrace();
        }


            DefaultTableModel model1 = (DefaultTableModel) jTable2.getModel();


        try {
            Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/product", "root", "root");
            Statement myStmt = myConn.createStatement();
            ResultSet myRs = myStmt.executeQuery("SELECT * FROM `bask`");
            System.out.println("Подключение успешно установлено");
            while (myRs.next()) {

                model1.addRow(new Object[]{myRs.getString("ID") , myRs.getString("Name") , myRs.getString("Price") , myRs.getString("Amount")});
            }
        }
        catch (Exception exc) {
            System.out.println("Подключение не удалось");
            exc.printStackTrace();
        }




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



        if(fieldPrice.getText().equals("") || fieldProd.getText().equals("") || fieldAmount.getText().equals("")){
            JOptionPane.showMessageDialog(null," Not all data is entered ");
        }
        else{
          try {
              Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/product", "root", "root");
              System.out.println("Подключение успешно установлено");
              //create statement
              Statement myStmt = myConn.createStatement();

              //execute sql query

                String a = fieldProd.getText();
                double b = Double.parseDouble(fieldPrice.getText()) ;
                int c = Integer.parseInt(fieldAmount.getText()) ;
                String rows = "INSERT product(Name, Price, Amount) VALUES ('"+  a +"', '" +b+"','"+ c+"')";
              model.getDataVector().removeAllElements();
                myStmt.execute(rows);
              model.fireTableDataChanged();
              model.addRow(new Object[]{"ID" , "Название", "Цена", "Amount"});
              ResultSet myRs = myStmt.executeQuery("SELECT * FROM `product`");
              System.out.println("Подключение успешно установлено");
              while (myRs.next()) {

                  model.addRow(new Object[]{myRs.getString("ID") , myRs.getString("Name") , myRs.getString("Price") , myRs.getString("Amount")});
              }
            }
            catch (SQLException ex) {
                ex.printStackTrace();
            }
            shop.Buy(fieldProd.getText(), fieldPrice.getText(), fieldAmount.getText());
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
           /* model.addRow(new Object[]{shop.getProduct().indexOf(fieldProd.getText()), fieldProd.getText(), fieldPrice.getText(),fieldAmount.getText()});*/
            JOptionPane.showMessageDialog(null,fieldProd.getText()+" is bought. Price - "+fieldPrice.getText()+".Amount - "+fieldAmount.getText());
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
                Metka:
                {
                    DefaultTableModel model1 = (DefaultTableModel) jTable1.getModel();
                    int p = 0;
                    for (int i1 = 0; i1 < model1.getRowCount(); i1++) {
                        System.out.println(model1.getRowCount());
                        if (fieldProd1.getText().equals(model1.getValueAt(i1, 1))) {

                            shop.addToBasket(fieldProd1.getText(), fieldUAmount.getText());

                            DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
                            String price1;
                            for (int i = 0; i < model1.getRowCount(); i++) {
                                if (fieldProd1.getText().equals(model1.getValueAt(i, 1))) {

                                    String val = String.valueOf(model1.getValueAt(i, 2));

                                    price1 = Double.toString(Double.parseDouble(val) * Double.parseDouble(fieldUAmount.getText()));
                                    String h = String.valueOf(model1.getValueAt(i, 3));

                                    try {
                                        String a = fieldProd1.getText();
                                        String s = String.valueOf(model1.getValueAt(i1, 0));
                                        int id = Integer.parseInt(s);
                                        int c = Integer.parseInt(fieldUAmount.getText());
                                        double b = Double.parseDouble(price1);

                                        Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/product", "root", "root");

                                        //create statement
                                        Statement myStmt = myConn.createStatement();

                                        //execute sql query


                                        String rows = "INSERT bask(ID,Name, Price, Amount) VALUES ('" + id + "','" + a + "', '" + b + "','" + c + "')";


                                        model.getDataVector().removeAllElements();
                                        /*  myStmt.execute(rows);*/
                                        model.fireTableDataChanged();
                                        model.addRow(new Object[]{"ID", "Название", "Цена", "Amount"});
                                        /* ResultSet myRs = myStmt.executeQuery("SELECT * FROM `product`");*/
                                        System.out.println("Подключение успешно установлено");
                                        myStmt.execute(rows);
                                        ResultSet myRs = myStmt.executeQuery("SELECT * FROM `bask`");
                                        while (myRs.next()) {

                                            model.addRow(new Object[]{myRs.getString("ID"), myRs.getString("Name"), myRs.getString("Price"), myRs.getString("Amount")});
                                        }

                                    } catch (SQLException ex) {
                                        ex.printStackTrace();
                                    }

                                    if (Integer.parseInt(h) - Integer.parseInt(fieldUAmount.getText()) > 0) {
                                        int v = Integer.parseInt(h) - Integer.parseInt(fieldUAmount.getText());

                                        try {
                                            Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/product", "root", "root");
                                            System.out.println("Подключение успешно установлено");
                                            //create statement
                                            Statement myStmt = myConn.createStatement();

                                            //execute sql query
                                            System.out.println(v);
                                            String s = String.valueOf(model1.getValueAt(i, 0));
                                            int id = Integer.parseInt(s);
                                            String rows = "UPDATE product SET Amount = '" + v + "' WHERE ID = '" + id + "'";
                                            model1.getDataVector().removeAllElements();
                                            myStmt.execute(rows);
                                            model1.fireTableDataChanged();
                                            model1.addRow(new Object[]{"ID", "Название", "Цена", "Amount"});
                                            ResultSet myRs = myStmt.executeQuery("SELECT * FROM `product`");
                                            System.out.println("Подключение успешно установлено");
                                            while (myRs.next()) {

                                                model1.addRow(new Object[]{myRs.getString("ID"), myRs.getString("Name"), myRs.getString("Price"), myRs.getString("Amount")});
                                            }
                                        } catch (SQLException ex) {
                                            ex.printStackTrace();
                                        }
                                    } else if (Integer.parseInt(h) - Integer.parseInt(fieldUAmount.getText()) == 0) {
                                        try {
                                            Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/product", "root", "root");
                                            System.out.println("Подключение успешно установлено4");
                                            //create statement
                                            Statement myStmt = myConn.createStatement();

                                            String s = String.valueOf(model1.getValueAt(i, 0));
                                            int id = Integer.parseInt(s);
                                            String rows = "DELETE FROM product WHERE ID = '" + id + "'";
                                            model1.getDataVector().removeAllElements();
                                            myStmt.execute(rows);
                                            model1.fireTableDataChanged();
                                            model1.addRow(new Object[]{"ID", "Название", "Цена", "Amount"});
                                            ResultSet myRs = myStmt.executeQuery("SELECT * FROM `product`");
                                            System.out.println("Подключение успешно установлено");
                                            while (myRs.next()) {

                                                model1.addRow(new Object[]{myRs.getString("ID"), myRs.getString("Name"), myRs.getString("Price"), myRs.getString("Amount")});
                                            }
                                        } catch (SQLException ex) {
                                            ex.printStackTrace();
                                        }
                                    } else {
                                        JOptionPane.showMessageDialog(null, fieldProd1.getText() + " Does not have such a quantity of goods in the store");
                                        break Metka;
                                    }



                                    double p1 = shop.getPrice1() + Double.parseDouble(price1);
                                    shop.setPrice1(p1);


                                    try {
                                        Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/product", "root", "root");

                                        //create statement

                                        Statement myStmt = myConn.createStatement();
                                        String rows = "UPDATE `price` SET `price` = ('" + shop.getPrice1() + "')";

                                        myStmt.execute(rows);
                                        labelCost.setText("Cost: " + shop.getPrice1() + '$');

                                    } catch (SQLException ex) {
                                        ex.printStackTrace();
                                    }
                                    /*   model.addRow(new Object[]{i, fieldProd1.getText(), price1, fieldUAmount.getText()});*/

                                    break;
                                }
                            }
                            p = 1;
                            break;
                        }
                    }

                    if (p == 1) {
                        JOptionPane.showMessageDialog(null, fieldProd1.getText() + " add to basket");
                    } else {
                        JOptionPane.showMessageDialog(null, fieldProd1.getText() + " don't sell in this shop");
                    }
                }
            }
        };
        buttonProd1.addActionListener(actionListener5);


        ActionListener actionListener6 =   new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int l=0;
                DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
                DefaultTableModel model1 = (DefaultTableModel) jTable1.getModel();
                for (int i1 = 0; i1 < model.getRowCount(); i1++) {
                    if (fieldRem.getText().equals(model.getValueAt(i1, 1))) {


                        for (int i = 0; i < model.getRowCount(); i++) {
                            if (fieldRem.getText().equals(model.getValueAt(i, 1))) {

                                String price1 = String.valueOf(model.getValueAt(i, 2));
                                double p1 = shop.getPrice1() - Double.parseDouble(price1);
                                System.out.println(p1);
                                shop.setPrice1(p1);

                                try {
                                    Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/product", "root", "root");

                                    //create statement

                                    Statement myStmt = myConn.createStatement();
                                    String rows = "UPDATE `price` SET `price` = ('" + shop.getPrice1() + "')";

                                    myStmt.execute(rows);
                                    labelCost.setText("Cost: " + shop.getPrice1() + '$');

                                } catch (SQLException ex) {
                                    ex.printStackTrace();
                                }

                                break;
                            }
                        }
                        for (int i = 0; i < model.getRowCount(); i++) {
                            for (int i2 = 0; i2 < model1.getRowCount(); i2++) {

                                if(fieldRem.getText().equals(model.getValueAt(i, 1))){
                                    if(fieldRem.getText().equals(model1.getValueAt(i2, 1))){

                                        int g = Integer.parseInt(String.valueOf(model1.getValueAt(i2, 3)))+Integer.parseInt(String.valueOf(model.getValueAt(i, 3)));
                                        System.out.println(fieldRem.getText().equals(model1.getValueAt(i, 1)));
                                        if (fieldRem.getText().equals(model1.getValueAt(i, 1))){


                                            try {
                                                Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/product", "root", "root");
                                                System.out.println("Подключение успешно установлено");
                                                //create statement
                                                Statement myStmt = myConn.createStatement();

                                                //execute sql query
                                                System.out.println(g);
                                                String s = String.valueOf(model1.getValueAt(i2, 0));
                                                int id = Integer.parseInt(s);
                                                String rows = "UPDATE product SET Amount = '" + g + "' WHERE ID = '" + id + "'";
                                                model1.getDataVector().removeAllElements();
                                                myStmt.execute(rows);
                                                model1.fireTableDataChanged();
                                                model1.addRow(new Object[]{"ID", "Название", "Цена", "Amount"});
                                                ResultSet myRs = myStmt.executeQuery("SELECT * FROM `product`");
                                                System.out.println("Подключение успешно установлено");
                                                while (myRs.next()) {

                                                    model1.addRow(new Object[]{myRs.getString("ID"), myRs.getString("Name"), myRs.getString("Price"), myRs.getString("Amount")});
                                                }
                                            } catch (SQLException ex) {
                                                ex.printStackTrace();
                                            }

                                        }
                                        else if (!fieldRem.getText().equals(model1.getValueAt(i2, 1))){

                                            try {
                                                Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/product", "root", "root");
                                                System.out.println("Подключение успешно установлено3");
                                                //create statement
                                                Statement myStmt = myConn.createStatement();

                                                //execute sql query
                                                String s = String.valueOf(model.getValueAt(i2, 0));
                                                int id = Integer.parseInt(s);
                                                String a = fieldRem.getText();



                                                double b = Double.parseDouble(String.valueOf(model.getValueAt(i2, 2)))/Double.parseDouble(String.valueOf(model.getValueAt(i2, 3))) ;
                                                int c = Integer.parseInt(String.valueOf(model.getValueAt(i2, 3))) ;
                                                System.out.println(id);
                                                System.out.println(a);
                                                System.out.println(b);
                                                System.out.println(c);
                                                String rows = "INSERT product(ID,Name, Price, Amount) VALUES ('"+  id +"','"+  a +"', '" +b+"','"+ c+"')";
                                                model1.getDataVector().removeAllElements();
                                                myStmt.execute(rows);
                                                model1.fireTableDataChanged();
                                                model1.addRow(new Object[]{"ID" , "Название", "Цена", "Amount"});
                                                ResultSet myRs = myStmt.executeQuery("SELECT * FROM `product`");
                                                System.out.println("Подключение успешно установлено");
                                                while (myRs.next()) {

                                                    model.addRow(new Object[]{myRs.getString("ID") , myRs.getString("Name") , myRs.getString("Price") , myRs.getString("Amount")});
                                                }
                                            }
                                            catch (SQLException ex) {
                                                ex.printStackTrace();
                                            }

                                        }


                                    }

                                }

                            }

                            if (fieldRem.getText().equals(model.getValueAt(i, 1))) {
                                /*model.removeRow(i);*/

                                try {
                                    Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/product", "root", "root");
                                    System.out.println("Подключение успешно установлено4");
                                    //create statement
                                    Statement myStmt = myConn.createStatement();
                                    String p = String.valueOf(model.getValueAt(i, 0));
                                    int id = Integer.parseInt(p);
                                    String rows = "DELETE FROM bask WHERE ID = '" + id + "'";
                                    model.getDataVector().removeAllElements();
                                    myStmt.execute(rows);
                                    model.fireTableDataChanged();
                                    model.addRow(new Object[]{"ID", "Название", "Цена", "Amount"});
                                    ResultSet myRs = myStmt.executeQuery("SELECT * FROM `bask`");
                                    System.out.println("Подключение успешно установлено");
                                    while (myRs.next()) {

                                        model.addRow(new Object[]{myRs.getString("ID"), myRs.getString("Name"), myRs.getString("Price"), myRs.getString("Amount")});
                                    }
                                } catch (SQLException ex) {
                                    ex.printStackTrace();
                                }

                                break;
                            }
                        }


                    }


                }
                if (l==0)
                {
                    JOptionPane.showMessageDialog(null, fieldRem.getText() + " is remove from basket");
                }
                else
                {
                    JOptionPane.showMessageDialog(null, fieldRem.getText() + " not found in basket");
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

                DefaultTableModel model = (DefaultTableModel) jTable2   .getModel();


                try {
                    Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/product", "root", "root");
                    System.out.println("Подключение успешно установлено4");
                    //create statement
                    Statement myStmt = myConn.createStatement();
                    String f = String.valueOf(model.getRowCount());
                    int l = Integer.parseInt(f);
                    shop.givePacket(l);
                    String rows = "INSERT bask(ID,Name, Price, Amount) VALUES ('" + 100+model.getRowCount() + "','" + shop.getPacket() + "', '" + 0 + "','" + 1 + "')";
                    model.getDataVector().removeAllElements();
                    myStmt.execute(rows);
                    model.fireTableDataChanged();
                    model.addRow(new Object[]{"ID", "Название", "Цена", "Amount"});
                    ResultSet myRs = myStmt.executeQuery("SELECT * FROM `bask`");
                    System.out.println("Подключение успешно установлено");
                    while (myRs.next()) {

                        model.addRow(new Object[]{myRs.getString("ID"), myRs.getString("Name"), myRs.getString("Price"), myRs.getString("Amount")});
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

                JOptionPane.showMessageDialog(null, shop.getPacket()+" is take");
            }
        };
        buttonPocket.addActionListener(actionListener8);



        ActionListener actionListener9 =   new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Double.parseDouble(shop.getUserBalance()) - shop.getPrice1()>0){

                    try {
                        Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/product", "root", "root");
                        System.out.println("Подключение успешно установлено4");
                        //create statement
                        Statement myStmt = myConn.createStatement();
                        String rows = "DELETE FROM bask ";
                        model1.getDataVector().removeAllElements();
                        myStmt.execute(rows);
                        model1.fireTableDataChanged();
                        model1.addRow(new Object[]{"ID", "Название", "Цена", "Amount"});
                        ResultSet myRs = myStmt.executeQuery("SELECT * FROM `bask`");
                        System.out.println("Подключение успешно установлено");
                        while (myRs.next()) {

                            model1.addRow(new Object[]{myRs.getString("ID"), myRs.getString("Name"), myRs.getString("Price"), myRs.getString("Amount")});
                        }
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }

                    shop.setBalance(String.valueOf(Double.parseDouble(shop.getBalance()) + shop.getPrice1()));
                    shop.setUserBalance(String.valueOf(Double.parseDouble(shop.getUserBalance()) - shop.getPrice1()));
                    shop.setPrice1(0);

                    try {
                        Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/product", "root", "root");

                        //create statement

                        Statement myStmt = myConn.createStatement();
                        String rows = "UPDATE `price` SET `price` = ('" + shop.getPrice1() + "')";

                        myStmt.execute(rows);
                        labelCost.setText("Cost: " + shop.getPrice1() + '$');

                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }

                    try {
                        Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/product", "root", "root");

                        //create statement

                        Statement myStmt = myConn.createStatement();
                        String rows = "UPDATE `ubalance` SET `ubalance` = ('" + shop.getUserBalance() + "')";

                        myStmt.execute(rows);
                        labelUBalance.setText("User balance: " + shop.getUserBalance()+"$");

                    }
                    catch (Exception exc) {
                        System.out.println("Подключение не удалось");
                        exc.printStackTrace();
                    }

                    try {
                        Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/product", "root", "root");

                        //create statement

                        Statement myStmt = myConn.createStatement();
                        String rows = "UPDATE `balance` SET `balance` = ('" + shop.getBalance() + "')";

                        myStmt.execute(rows);
                        labelBalance.setText("Balance: " + shop.getBalance()+"$");

                    }
                    catch (Exception exc) {
                        System.out.println("Подключение не удалось");
                        exc.printStackTrace();
                    }
              /*  for(int i = 0; i<shop.getProduct().size(); i++){
                    for (int j =0; j<shop.getSet().size();j++)
                    if(shop.getProduct().get(j).contains(shop.getSet().get(i))){
                        int uamount1 = Integer.parseInt(shop.getUserAmount().get(i));

                        int amount1 = Integer.parseInt(shop.getAmount().get(j));
                        int namount = amount1 - uamount1;
                        jTable1.setValueAt(namount, i+1, 3);
                    }
                }

                shop.payment();

                    DefaultTableModel model = (DefaultTableModel) jTable2   .getModel();
                    model.getDataVector().removeAllElements();
                    model.fireTableDataChanged();
                    model.addRow(new Object[]{"ID" , "Название", "Цена", "Amount"});
                labelBalance.setText("Balance: "+ shop.getBalance()+"$");
                labelUBalance.setText("User Balance: "+ shop.getUserBalance()+"$");

                */

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

                try {
                    Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/product", "root", "root");

                    //create statement

                    Statement myStmt = myConn.createStatement();
                    String rows = "UPDATE `ubalance` SET `ubalance` = ('" + shop.getUserBalance() + "')";

                    myStmt.execute(rows);
                    labelUBalance.setText("User balance: " + shop.getUserBalance()+"$");

                }
                catch (Exception exc) {
                    System.out.println("Подключение не удалось");
                    exc.printStackTrace();
                }

            }
        };
        buttonUBalance.addActionListener(actionListener10);


    }
}
