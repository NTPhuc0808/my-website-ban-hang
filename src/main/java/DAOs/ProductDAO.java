/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import Models.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author xuan
 */
public class ProductDAO {

    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;

    public ProductDAO() {
        conn = DB.DBConnection.connect();
    }

    public Product GetProById(int id) {
        Product pro = null;
        String sql = "select * from product where pro_id=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                pro = new Product(rs.getInt("pro_id"),
                        rs.getInt("cat_id"), rs.getString("pro_name"), rs.getDouble("pro_price"), rs.getString("pro_picture"),
                        rs.getInt("pro_quantity"), rs.getNString("pro_description"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return pro;
    }

    public LinkedList<Product> Get3ProductByCatId(int cat_id) {
        LinkedList<Product> list = new LinkedList<>();
        String sql = "select top 3* from product where cat_id=?";
        try {

            ps = conn.prepareStatement(sql);
            ps.setInt(1, cat_id);
            rs = ps.executeQuery();
            while (rs.next()) {
                Product pro = new Product(rs.getInt("pro_id"),
                        rs.getInt("cat_id"), rs.getString("pro_name"), rs.getDouble("pro_price"), rs.getString("pro_picture"),
                        rs.getInt("pro_quantity"), rs.getNString("pro_description"));
                list.add(pro);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

    public LinkedList<Product> GetAllPro() {
        LinkedList<Product> list = new LinkedList<>();
        String sql = "select * from product";
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Product pro = new Product(rs.getInt("pro_id"),
                        rs.getInt("cat_id"), rs.getString("pro_name"), rs.getDouble("pro_price"), rs.getString("pro_picture"),
                        rs.getInt("pro_quantity"), rs.getNString("pro_description"));
                list.add(pro);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

    public int GetTotalpro() {
        int count = 0;
        String sql = "select count(*) from product";
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return count;
    }

    public int GetTotalProOfCat(int cat_id) {
        int count = 0;
        String sql = "select count(*) from product where cat_id=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, cat_id);
            rs = ps.executeQuery();
            if (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return count;
    }

    public int GetTotalByPriceBetween(Double begin, Double end) {
        int count = 0;
        String sql = "select count(*) from product where pro_price BETWEEN ? AND ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setDouble(1, begin);
            ps.setDouble(2, end);
            rs = ps.executeQuery();
            if (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return count;
    }

    public int GetTotalProOfCatByPriceIsLess(int cat_id, Double price) {
        int count = 0;
        String sql = "select count(*) from product where cat_id=? and pro_price<?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, cat_id);
            ps.setDouble(2, price);
            rs = ps.executeQuery();
            if (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return count;
    }

    public int GetTotalProByPriceIsLess(Double price) {
        int count = 0;
        String sql = "select count(*) from product where pro_price<?";
        try {
            ps = conn.prepareStatement(sql);

            ps.setDouble(1, price);
            rs = ps.executeQuery();
            if (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return count;
    }

    public int GetTotalProOfCatByPriceIsGreater(int cat_id, Double price) {
        int count = 0;
        String sql = "select count(*) from product where cat_id=? and pro_price>?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, cat_id);
            ps.setDouble(2, price);
            rs = ps.executeQuery();
            if (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return count;
    }

    public LinkedList<Product> PagingAllPro(int index) {
        LinkedList<Product> list = new LinkedList<>();
        String sql = "select * from product\n"
                + "order by pro_id\n"
                + "offset ? rows fetch next 6 rows only";

        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, (index - 1) * 6);
            rs = ps.executeQuery();
            while (rs.next()) {
                Product pro = new Product(rs.getInt("pro_id"),
                        rs.getInt("cat_id"), rs.getString("pro_name"), rs.getDouble("pro_price"), rs.getString("pro_picture"),
                        rs.getInt("pro_quantity"), rs.getNString("pro_description"));
                list.add(pro);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;

    }

    public LinkedList<Product> PagingProOfCat(int index, int cat_id) {
        LinkedList<Product> list = new LinkedList<>();
        String sql = "select * from product where cat_id=?\n"
                + "order by pro_id\n"
                + "offset ? rows fetch next 6 rows only";

        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, cat_id);
            ps.setInt(2, (index - 1) * 6);

            rs = ps.executeQuery();
            while (rs.next()) {
                Product pro = new Product(rs.getInt("pro_id"),
                        rs.getInt("cat_id"), rs.getString("pro_name"), rs.getDouble("pro_price"), rs.getString("pro_picture"),
                        rs.getInt("pro_quantity"), rs.getNString("pro_description"));
                list.add(pro);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;

    }

    public LinkedList<Product> PagingProOfCatByPriceIsLess(int index, int cat_id, Double price) {
        LinkedList<Product> list = new LinkedList<>();
        String sql = "select * from product where cat_id=? and pro_price<?\n"
                + "order by pro_id\n"
                + "offset ? rows fetch next 6 rows only";

        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, cat_id);
            ps.setDouble(2, price);
            ps.setInt(3, (index - 1) * 6);

            rs = ps.executeQuery();
            while (rs.next()) {
                Product pro = new Product(rs.getInt("pro_id"),
                        rs.getInt("cat_id"), rs.getString("pro_name"), rs.getDouble("pro_price"), rs.getString("pro_picture"),
                        rs.getInt("pro_quantity"), rs.getNString("pro_description"));
                list.add(pro);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;

    }

    public LinkedList<Product> PagingProByPriceIsLess(int index, Double price) {
        LinkedList<Product> list = new LinkedList<>();
        String sql = "select * from product where pro_price<?\n"
                + "order by pro_id\n"
                + "offset ? rows fetch next 6 rows only";

        try {
            ps = conn.prepareStatement(sql);
            ps.setDouble(1, price);
            ps.setInt(2, (index - 1) * 6);

            rs = ps.executeQuery();
            while (rs.next()) {
                Product pro = new Product(rs.getInt("pro_id"),
                        rs.getInt("cat_id"), rs.getString("pro_name"), rs.getDouble("pro_price"), rs.getString("pro_picture"),
                        rs.getInt("pro_quantity"), rs.getNString("pro_description"));
                list.add(pro);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;

    }

    public LinkedList<Product> PagingProByPriceBetween(int index, Double begin, Double end) {
        LinkedList<Product> list = new LinkedList<>();
        String sql = "select * from product where pro_price BETWEEN ? AND ?\n"
                + "order by pro_id\n"
                + "offset ? rows fetch next 6 rows only";

        try {
            ps = conn.prepareStatement(sql);
            ps.setDouble(1, begin);
            ps.setDouble(2, end);
            ps.setInt(3, (index - 1) * 6);

            rs = ps.executeQuery();
            while (rs.next()) {
                Product pro = new Product(rs.getInt("pro_id"),
                        rs.getInt("cat_id"), rs.getString("pro_name"), rs.getDouble("pro_price"), rs.getString("pro_picture"),
                        rs.getInt("pro_quantity"), rs.getNString("pro_description"));
                list.add(pro);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;

    }

    public LinkedList<Product> PagingProOfCatByPriceIsGreater(int index, int cat_id, Double price) {
        LinkedList<Product> list = new LinkedList<>();
        String sql = "select * from product where cat_id=? and pro_price>?\n"
                + "order by pro_id\n"
                + "offset ? rows fetch next 6 rows only";

        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, cat_id);
            ps.setDouble(2, price);
            ps.setInt(3, (index - 1) * 6);

            rs = ps.executeQuery();
            while (rs.next()) {
                Product pro = new Product(rs.getInt("pro_id"),
                        rs.getInt("cat_id"), rs.getString("pro_name"), rs.getDouble("pro_price"), rs.getString("pro_picture"),
                        rs.getInt("pro_quantity"), rs.getNString("pro_description"));
                list.add(pro);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;

    }

    /**
     * use for update quantity of cart and product when add to cart and order
     *
     * @param quantity
     * @param pro_id
     * @return
     */
    public int UpdateQuantity(int quantity, int pro_id) {
        String sql = "update product set pro_quantity=? where pro_id=?";
        int count = 0;
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, quantity);
            ps.setInt(2, pro_id);
            count = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;
    }

    public Product AddNew(Product pro) {
        int count = 0;
        String sql = "insert into product values(?,?,?,?,?,?)";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, pro.getCat_id());
            ps.setString(2, pro.getPro_name());
            ps.setDouble(3, pro.getPro_price());
            ps.setString(4, pro.getPro_picture());
            ps.setInt(5, pro.getPro_quantity());
            ps.setString(6, pro.getPro_description());
            count = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (count == 0) ? null : pro;
    }

    public Product Update(Product pro, int id) {
        int count = 0;
        String sql = "Update product set cat_id=?, pro_name=?, pro_price=?, pro_picture=?, pro_quantity=?, pro_description=? where pro_id=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, pro.getCat_id());
            ps.setString(2, pro.getPro_name());
            ps.setDouble(3, pro.getPro_price());
            ps.setString(4, pro.getPro_picture());
            ps.setInt(5, pro.getPro_quantity());
            ps.setString(6, pro.getPro_description());
            ps.setInt(7, id);
            count = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (count == 0) ? null : pro;
    }

    public int Delete(int pro_id) {
        int count = 0;
        String sql = "Delete from product where pro_id=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, pro_id);
            count = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;
    }

}
