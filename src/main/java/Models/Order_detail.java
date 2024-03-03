/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author xuan
 */
public class Order_detail {

    private int o_id;
    private int pro_id;
    private String pro_name;
    private Double pro_price;
    private int pro_quantity;
    private Double total_price;

    public Order_detail() {
    }

 

    public Order_detail(int o_id, int pro_id, String pro_name, Double pro_price, int pro_quantity) {
        this.o_id = o_id;
        this.pro_id = pro_id;
        this.pro_name = pro_name;
        this.pro_price = pro_price;
        this.pro_quantity = pro_quantity;
        this.total_price = this.pro_price * this.pro_quantity;
    }

    public int getO_id() {
        return o_id;
    }

    public void setO_id(int o_id) {
        this.o_id = o_id;
    }

    public int getPro_id() {
        return pro_id;
    }

    public void setPro_id(int pro_id) {
        this.pro_id = pro_id;
    }

    public Double getPro_price() {
        return pro_price;
    }

    public void setPro_price(Double pro_price) {
        this.pro_price = pro_price;
    }

    public int getPro_quantity() {
        return pro_quantity;
    }

    public void setPro_quantity(int pro_quantity) {
        this.pro_quantity = pro_quantity;
    }

    public Double getTotal_price() {
        return total_price;
    }

    public void setTotal_price(Double total_price) {
        this.total_price = total_price;
    }

    public String getPro_name() {
        return pro_name;
    }

    public void setPro_name(String pro_name) {
        this.pro_name = pro_name;
    }

}
