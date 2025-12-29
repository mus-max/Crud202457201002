/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kelas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.SQLDataException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author HP
 */
public class category extends koneksi{
    private int categoryId;
    private String categoryName;
    private final Connection koneksi;
    private PreparedStatement ps;
    private Statement st;
    private ResultSet rs;
    private String query;
    
    public category(){
        koneksi = super.configDB();
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
    
    public void TambahCategory(){
        query = "INSERT INTO category (categoryName) VALUES (?) ";
    try {
        ps = koneksi.prepareStatement(query);
        ps.setString(1, categoryName);
        ps.executeUpdate();
        ps.close();

        JOptionPane.showMessageDialog(null,"Data Berhasil Ditambahkan");
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Data Gagal Ditambahkan");
        }
    }
    
    public void UbahCategory(){
        query = "UPDATE category SET categoryName=? WHERE "
                + "categoryId=? ";
    try {
        ps = koneksi.prepareStatement(query);
        ps.setString(1, categoryName);
        ps.setInt(2, categoryId);
        ps.executeUpdate();
        ps.close();
        JOptionPane.showMessageDialog(null,"Data Berhasil Diubah");
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Data Gagal Diubah");
        }
    }
    
    public void HapusCategory(){
        query = "DELETE FROM category WHERE categoryId = ? ";
    
    try {
        ps = koneksi.prepareStatement(query);
        ps.setInt(1, categoryId);
        ps.executeUpdate();
        ps.close();
        JOptionPane.showMessageDialog(null,"Data Berhasil "
                + "Dihapus");
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Data Gagal "
                + "Dihapus");
        }
    }
    
    public ResultSet TampilCategory(){
        query = "SELECT * FROM category";

    try{
        st = koneksi.createStatement();
        rs = st.executeQuery(query);
    }catch (SQLException e){
        JOptionPane.showMessageDialog(null, "Data Gagal "
                + "Ditampilkan");
    }
    return rs;
    }

    public void setVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet.");
    // Generated fromnbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
}
}
