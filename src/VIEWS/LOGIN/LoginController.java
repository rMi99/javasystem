package VIEWS.LOGIN;

import Utils.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Dewwa
 */
public class LoginController {

    Connection conn;
//    ResultSet rs = null;
//    PreparedStatement pst = null;

    public LoginController() {
        conn = DatabaseConnection.connect();

    }

    public boolean login(String un, String pw) {
        try {
            String sql = "SELECT * FROM Branch WHERE userName = '" + un.toString() + "' AND password = '" + pw.toString() + "'";
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                System.out.println("Login Succeed");
                return true;
            } else {
                System.err.println("Wrong Credentials");
                return false;
            }
        } catch (Exception e) {
            System.err.println("Login Error : " + e);
            return false;
        }
    }
}
