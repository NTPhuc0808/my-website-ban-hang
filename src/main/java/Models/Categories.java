/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author Xuan
 */
public class Categories {

    private int cat_id;
    private String cat_name;
    private String cat_picture;
    private String cat_description;

    public Categories() {
    }

    public Categories(int cat_id, String cat_name, String cat_picture, String cat_description) {
        this.cat_id = cat_id;
        this.cat_name = cat_name;
        this.cat_picture = cat_picture;
        this.cat_description = cat_description;
    }

    public int getCat_id() {
        return cat_id;
    }

    public void setCat_id(int cat_id) {
        this.cat_id = cat_id;
    }

    public String getCat_name() {
        return cat_name;
    }

    public void setCat_name(String cat_name) {
        this.cat_name = cat_name;
    }

    public String getCat_picture() {
        return cat_picture;
    }

    public void setCat_picture(String cat_picture) {
        this.cat_picture = cat_picture;
    }

    public String getCat_description() {
        return cat_description;
    }

    public void setCat_description(String cat_description) {
        this.cat_description = cat_description;
    }

}
