/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.sql.Date;

/**
 *
 * @author xuan
 */
public class Orders {

    private int o_id;
    private int acc_id;
    private String o_address;
    private String o_phone;
    private Double total_price;
    private Date o_date;
    private String order_status; // Trường trạng thái đơn hàng

    public Orders() {
        this.order_status = "Order"; // Gán giá trị mặc định khi tạo đối tượng mới
    }

    public Orders(int o_id, int acc_id, String o_address, String o_phone, Double total_price, Date o_date) {
        this.o_id = o_id;
        this.acc_id = acc_id;
        this.o_address = o_address;
        this.o_phone = o_phone;
        this.total_price = total_price;
        this.o_date = o_date;
        this.order_status = "Order";
    }

    public int getO_id() {
        return o_id;
    }

    public void setO_id(int o_id) {
        this.o_id = o_id;
    }

    public int getAcc_id() {
        return acc_id;
    }

    public void setAcc_id(int acc_id) {
        this.acc_id = acc_id;
    }

    public String getO_address() {
        return o_address;
    }

    public void setO_address(String o_address) {
        this.o_address = o_address;
    }

    public String getO_phone() {
        return o_phone;
    }

    public void setO_phone(String o_phone) {
        this.o_phone = o_phone;
    }

    public Double getTotal_price() {
        return total_price;
    }

    public void setTotal_price(Double total_price) {
        this.total_price = total_price;
    }

    public Date getO_date() {
        return o_date;
    }

    public void setO_date(Date o_date) {
        this.o_date = o_date;
    }

    public String getOrder_status() {
        return order_status;
    }

    public void setOrder_status(String order_status) {
        this.order_status = order_status;
    }

}
