/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import Models.Order_detail;
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
public class Order_deailDAO {

    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;

    public Order_deailDAO() {
        conn = DB.DBConnection.connect();
    }

    public Order_detail AddOrderDetail(Order_detail o) {
        int count = 0;
        String sql = "insert into order_detail values(?,?,?,?,?,?)";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, o.getO_id());
            ps.setInt(2, o.getPro_id());
            ps.setString(3, o.getPro_name());
            ps.setDouble(4, o.getPro_price());
            ps.setInt(5, o.getPro_quantity());
            ps.setDouble(6, o.getTotal_price());
            count = ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(Order_deailDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (count == 0) ? null : o;
    }

    public LinkedList<Order_detail> GetListDetailByOId(int o_id) {
        LinkedList<Order_detail> list = new LinkedList<>();
        String sql = "select * from order_detail where o_id=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, o_id);
            rs = ps.executeQuery();
            while (rs.next()) {
                Order_detail o = new Order_detail(rs.getInt("o_id"), rs.getInt("pro_id"),
                        rs.getString("pro_name"), rs.getDouble("pro_price"), rs.getInt("pro_quantity"));
                list.add(o);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Order_deailDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    public static void main(String[] args) {
        Order_deailDAO dao = new Order_deailDAO();
        LinkedList<Order_detail> list = dao.GetListDetailByOId(5);
        System.out.println("list size:" + list.size());
    }
}
