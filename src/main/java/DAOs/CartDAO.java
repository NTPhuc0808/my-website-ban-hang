/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import Models.Cart;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dell
 */
public class CartDAO {

    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;

    public CartDAO() {
        conn = DB.DBConnection.connect();
    }

    public LinkedList<Cart> GetListCartByAccID(int acc_id) {
        LinkedList<Cart> list = new LinkedList<>();
        String sql = "select * from cart where acc_id=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, acc_id);
            rs = ps.executeQuery();
            while (rs.next()) {
                Cart cart = new Cart(rs.getInt("cart_id"), rs.getInt("acc_id"),
                        rs.getInt("pro_id"), rs.getString("pro_name"), rs.getInt("pro_quantity"), rs.getDouble("price"));
                list.add(cart);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CartDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public Cart AddCart(Cart c) {
        int count = 0;
        String sql = "insert into cart values(?,?,?,?,?,?)";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, c.getAcc_id());
            ps.setInt(2, c.getPro_id());
            ps.setString(3, c.getPro_name());
            ps.setInt(4, c.getPro_quantity());
            ps.setDouble(5, c.getPrice());
            ps.setDouble(6, c.getTotal_price());
            count = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CartDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return (count == 0) ? null : c;

    }

    public int DeleteCart(int cart_id) {
        int count = 0;
        String sql = "delete from cart where cart_id=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, cart_id);
            count = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CartDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return count;

    }

    public Cart UpdateQuan(Cart c) {
        int count = 0;
        String sql = "update cart set pro_quantity=?, total_price=? where cart_id=? and pro_id=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, c.getPro_quantity());
            ps.setDouble(2, c.getTotal_price());
            ps.setInt(3, c.getCart_id());
            ps.setInt(4, c.getPro_id());
            count = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CartDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return (count == 0) ? null : c;
    }

    public Cart GetCartById(int id) {
        Cart c = null;
        String sql = "select * from cart where cart_id=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                c = new Cart(rs.getInt("cart_id"), rs.getInt("acc_id"), rs.getInt("pro_id"), rs.getString("pro_name"),
                        rs.getInt("pro_quantity"), rs.getDouble("price"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return c;
    }

    public static void main(String[] args) {
        CartDAO dao = new CartDAO();

        try {
            LinkedList<Cart> cart = dao.GetListCartByAccID(1);
            System.out.println(cart.size());
        } catch (Exception e) {

            e.printStackTrace();
        }

    }

}
