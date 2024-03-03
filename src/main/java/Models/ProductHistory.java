/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.sql.Date;

/**
 *
 * @author Dell
 */
public class ProductHistory {

    private int pro_id;
    private String pro_name;
    private int quanInStock;
    private int quanOnOrder;
    private int quanAdded;
    private int quanDelete;
    private int quanOrderCancel;
    private Date date_update;

    public ProductHistory() {
    }

    public ProductHistory(int pro_id, String pro_name, int quanInStock, int quanOnOrder, int quanAdded, int quanDelete, int quanOrderCancel, Date date_update) {
        this.pro_id = pro_id;
        this.pro_name = pro_name;
        this.quanInStock = quanInStock;
        this.quanOnOrder = quanOnOrder;
        this.quanAdded = quanAdded;
        this.quanDelete = quanDelete;
        this.quanOrderCancel = quanOrderCancel;
        this.date_update = date_update;
    }

    public int getPro_id() {
        return pro_id;
    }

    public void setPro_id(int pro_id) {
        this.pro_id = pro_id;
    }

    public String getPro_name() {
        return pro_name;
    }

    public void setPro_name(String pro_name) {
        this.pro_name = pro_name;
    }

    public int getQuanInStock() {
        return quanInStock;
    }

    public void setQuanInStock(int quanInStock) {
        this.quanInStock = quanInStock;
    }

    public int getQuanOnOrder() {
        return quanOnOrder;
    }

    public void setQuanOnOrder(int quanOnOrder) {
        this.quanOnOrder = quanOnOrder;
    }

    public int getQuanAdded() {
        return quanAdded;
    }

    public void setQuanAdded(int quanAdded) {
        this.quanAdded = quanAdded;
    }

    public int getQuanDelete() {
        return quanDelete;
    }

    public void setQuanDelete(int quanDelete) {
        this.quanDelete = quanDelete;
    }

    public int getQuanOrderCancel() {
        return quanOrderCancel;
    }

    public void setQuanOrderCancel(int quanOrderCancel) {
        this.quanOrderCancel = quanOrderCancel;
    }

    
    public Date getDate_update() {
        return date_update;
    }

    public void setDate_update(Date date_update) {
        this.date_update = date_update;
    }

}
