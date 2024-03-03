/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import Models.Account;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Xuan
 */
public class AccountDAO {

    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;

    public AccountDAO() {
        conn = DB.DBConnection.connect();
    }

    public LinkedList<Account> GetAllUser() {
        LinkedList<Account> list = new LinkedList<>();
        String sql = "select * from account where isAdmin=0";//cau lenh sql
        try {
            ps = conn.prepareStatement(sql);//thuc thi cau lenh sql
            rs = ps.executeQuery();//luu ket qua tra ve
            while (rs.next()) {
                Account acc = new Account(rs.getInt("acc_id"), rs.getString("fullname"),
                        rs.getString("gender"), rs.getDate("birthday"), rs.getString("username"),
                        rs.getString("password"), rs.getInt("isAdmin"));
                list.add(acc);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public Account GetAccount(String username, String password) {
        int count = 0;
        String sql = "select * from account where username=? and password=?";//cau lenh sql
        Account acc = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);//lay gia tri username thay cho dau cham hoi thu nhat
            ps.setString(2, Utils.Hashing.getMd5(password));//lay gia tri password thay cho dau 
            //cham hoi thu hai va ma hoa password bang ham md5
            rs = ps.executeQuery();
            if (rs.next()) {
                acc = new Account(rs.getInt("acc_id"), rs.getString("fullname"),
                        rs.getString("gender"), rs.getDate("birthday"),
                        rs.getString("username"), rs.getString("password"), rs.getInt("isAdmin"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return acc;

    }

    public Account GetAccountByAccId(int acc_id) {
        int count = 0;
        String sql = "select * from account where acc_id=?";//cau lenh sql
        Account acc = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, acc_id);//lay gia tri username thay cho dau cham hoi thu nhat
            rs = ps.executeQuery();
            if (rs.next()) {
                acc = new Account(rs.getInt("acc_id"), rs.getString("fullname"),
                        rs.getString("gender"), rs.getDate("birthday"),
                        rs.getString("username"), rs.getString("password"), rs.getInt("isAdmin"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return acc;

    }

    public int DeleteAccById(int acc_id) {
        int count = 0;
        String sql = "delete from account where acc_id=?";//cau lenh sql
        Account acc = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, acc_id);
            count = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;

    }

    public Account AddNewAcc(Account acc) {
        int count = 0;
        String sql = "INSERT INTO Account (fullname, gender, Birthday, username, password, isAdmin) values(?,?,?,?,?,?)";//cau lenh sql
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, acc.getFullname());
            ps.setString(2, acc.getGender());
            ps.setDate(3, acc.getBirthday());
            ps.setString(4, acc.getUsername());
            ps.setString(5, Utils.Hashing.getMd5(acc.getPassword()));
            ps.setInt(6, 0);
            count = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (count == 0) ? null : acc;
    }
    public int CountAccount(){
        String sql = "select COUNT(*) from account";
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
