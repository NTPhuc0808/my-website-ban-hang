/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import Models.Orders;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dell
 */
public class OrderDAO {

    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;

    public OrderDAO() {
        conn = DB.DBConnection.connect();
    }

    public int AddOrder(Orders o) {
        int o_id = 0;
        String sql = "insert into orders values(?,?,?,?,?,?)";
        try {
            ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, o.getAcc_id());
            ps.setString(2, o.getO_address());
            ps.setString(3, o.getO_phone());
            ps.setDouble(4, o.getTotal_price());
            ps.setDate(5, o.getO_date());
            ps.setString(6, o.getOrder_status());
            ps.executeUpdate();
            rs = ps.getGeneratedKeys();
            if (rs.next()) {
                o_id = rs.getInt(1);
            }

        } catch (SQLException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return o_id;
    }

    public LinkedList<Orders> GetListOrderByAccId(int acc_id) {
        LinkedList<Orders> list = new LinkedList<>();
        String sql = "select * from orders where acc_id=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, acc_id);
            rs = ps.executeQuery();
            while (rs.next()) {
                Orders o = new Orders(rs.getInt("o_id"), rs.getInt("acc_id"),
                        rs.getString("o_address"), rs.getString("o_phone"), rs.getDouble("total_price"),
                        rs.getDate("o_date"));
                o.setOrder_status(rs.getString("order_status"));
                list.add(o);
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

    public LinkedList<Orders> GetListOrder() {
        LinkedList<Orders> list = new LinkedList<>();
        String sql = "select * from orders";
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Orders o = new Orders(rs.getInt("o_id"), rs.getInt("acc_id"),
                        rs.getString("o_address"), rs.getString("o_phone"), rs.getDouble("total_price"),
                        rs.getDate("o_date"));
                o.setOrder_status(rs.getString("order_status"));
                list.add(o);
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

    public Orders GetOrderById(int o_id) {
        Orders order = null;
        String sql = "select * from orders where o_id=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, o_id);
            rs = ps.executeQuery();
            if (rs.next()) {
                order = new Orders(rs.getInt("o_id"), rs.getInt("acc_id"),
                        rs.getString("o_address"), rs.getString("o_phone"), rs.getDouble("total_price"),
                        rs.getDate("o_date"));
                order.setOrder_status(rs.getString("order_status"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return order;
    }

    public int editOrderById(int o_id, String status) {
        String sql = "update orders set order_status=? where o_id=?";

        int count = 0;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, status);
            ps.setInt(2, o_id);
            count = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;
    }
    public int CountOrder(){
        String sql = "select COUNT(*) from orders";
        int count = 0;
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            if(rs.next()){
                count = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;
    }
}
