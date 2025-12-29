/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kelas;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author HP
 */
public class koneksi {
    private Connection mysqlconfig;
    public Connection configDB(){
        try {
            String url = "jdbc:mysql://localhost:3306/crud_202457201002";
            String user = "root";
            String pass = "";
            mysqlconfig = DriverManager.getConnection(url, user, pass);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return mysqlconfig;
    }
}

