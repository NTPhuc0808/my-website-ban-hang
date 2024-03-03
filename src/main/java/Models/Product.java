/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author xuan
 */
public class Product {

    private int pro_id;
    private int cat_id;
    private String pro_name;
    private Double pro_price;
    private String pro_picture;
    private int pro_quantity;
    private String pro_description;

    public Product(int pro_id, int cat_id, String pro_name, Double pro_price, String pro_picture, int pro_quantity, String pro_description) {
        this.pro_id = pro_id;
        this.cat_id = cat_id;
        this.pro_name = pro_name;
        this.pro_price = pro_price;
        this.pro_picture = pro_picture;
        this.pro_quantity = pro_quantity;
        this.pro_description = pro_description;
    }

    public Product() {
    }

    public String getPro_name() {
        return pro_name;
    }

    public void setPro_name(String pro_name) {
        this.pro_name = pro_name;
    }

    public int getPro_id() {
        return pro_id;
    }

    public void setPro_id(int pro_id) {
        this.pro_id = pro_id;
    }

    public int getCat_id() {
        return cat_id;
    }

    public void setCat_id(int cat_id) {
        this.cat_id = cat_id;
    }

    public Double getPro_price() {
        return pro_price;
    }

    public void setPro_price(Double pro_price) {
        this.pro_price = pro_price;
    }

    public String getPro_picture() {
        return pro_picture;
    }

    public void setPro_picture(String pro_picture) {
        this.pro_picture = pro_picture;
    }

    public int getPro_quantity() {
        return pro_quantity;
    }

    public void setPro_quantity(int pro_quantity) {
        this.pro_quantity = pro_quantity;
    }

    public String getPro_description() {
        return pro_description;
    }

    public void setPro_description(String pro_description) {
        this.pro_description = pro_description;
    }

}
