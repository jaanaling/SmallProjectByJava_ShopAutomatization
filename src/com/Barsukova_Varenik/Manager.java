package com.Barsukova_Varenik;

public interface Manager <Money> {
    void Buy(String item,String price, String amount);
    void Selling();
    void Info();
    void Opening();
    void Closing();
    void getPrice(String price1);
}
