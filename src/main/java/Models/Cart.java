/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author xuan
 */
public class Cart {

    private int cart_id;
    private int acc_id;
    private int pro_id;
    private String pro_name;
    private int pro_quantity;
    private Double price;
    private Double total_price;

    public Cart() {
    }

    public Cart(int cart_id, int acc_id, int pro_id, String pro_name, int pro_quantity, Double price) {
        this.cart_id = cart_id;
        this.acc_id = acc_id;
        this.pro_id = pro_id;
        this.pro_name = pro_name;
        this.pro_quantity = pro_quantity;
        this.price = price;
        this.total_price = this.price*this.pro_quantity;
    }

   

    public int getCart_id() {
        return cart_id;
    }

    public void setCart_id(int cart_id) {
        this.cart_id = cart_id;
    }

    public int getAcc_id() {
        return acc_id;
    }

    public void setAcc_id(int acc_id) {
        this.acc_id = acc_id;
    }

    public int getPro_id() {
        return pro_id;
    }

    public void setPro_id(int pro_id) {
        this.pro_id = pro_id;
    }

    public int getPro_quantity() {
        return pro_quantity;
    }

    public void setPro_quantity(int pro_quantity) {
        this.pro_quantity = pro_quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getTotal_price() {
        return price * pro_quantity;
    }

    public String getPro_name() {
        return pro_name;
    }

    public void setPro_name(String pro_name) {
        this.pro_name = pro_name;
    }

}
