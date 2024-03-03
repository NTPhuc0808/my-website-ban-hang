/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import Models.Categories;
import Models.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dell
 */
public class CategoriesDAO {

    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;

    public CategoriesDAO() {
        conn = DB.DBConnection.connect();
    }

    public LinkedList<Categories> GetListCat() {
        LinkedList<Categories> list = new LinkedList<>();
        String sql = "select * from categories";

        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Categories cat = new Categories(rs.getInt("cat_id"), rs.getNString("cat_name"),
                        rs.getString("cat_picture"), rs.getNString("cat_description"));
                list.add(cat);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoriesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public Categories GetCatById(int id) {
        Categories cat = null;
        String sql = "select * from categories where cat_id=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                cat = new Categories(rs.getInt("cat_id"), rs.getNString("cat_name"),
                        rs.getString("cat_picture"), rs.getNString("cat_description"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return cat;
    }

    public static void main(String[] args) {
        CategoriesDAO dao = new CategoriesDAO();
        ProductDAO pdao = new ProductDAO();
        LinkedList<Categories> cat = dao.GetListCat();

        Map<Categories, LinkedList<Product>> map = new HashMap<>();
        LinkedList<Product> pro = new LinkedList<>();
        for (Categories c : cat) {
            pro = pdao.Get3ProductByCatId(c.getCat_id());
            System.out.println("size product" + pro.size());
            map.put(c, pro);
            pro = new LinkedList<>();
        }

        for (Map.Entry<Categories, LinkedList<Product>> entry : map.entrySet()) {
            System.out.println("first" + entry.getKey().getCat_id());
//            System.out.println(entry.getValue().size());
            for (Product product : entry.getValue()) {
                System.out.println(product.getCat_id());
            }

        }
    }

}
