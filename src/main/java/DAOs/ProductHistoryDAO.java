/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import Models.ProductHistory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dell
 */
public class ProductHistoryDAO {

    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;

    public ProductHistoryDAO() {
        conn = DB.DBConnection.connect();
    }

    public int AddProHistory(ProductHistory p) {
        String sql = "insert into ProductHistory values(?,?,?,?,?,?,?,?)";
        int count = 0;
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, p.getPro_id());
            ps.setString(2, p.getPro_name());
            ps.setInt(3, p.getQuanInStock());
            ps.setInt(4, p.getQuanOnOrder());
            ps.setInt(5, p.getQuanAdded());
            ps.setInt(6, p.getQuanDelete());
            ps.setInt(7, p.getQuanOrderCancel());
            ps.setDate(8, p.getDate_update());
            count = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductHistoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;
    }

}
