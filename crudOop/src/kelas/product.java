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
public class product extends koneksi{
    private int productId, productCategory, productPrice;
    private String productName, productDescription;
    private final Connection koneksi;
    private PreparedStatement ps;
    private Statement st;
    private ResultSet rs;
    private String query;
    
    public product(){
        koneksi = super.configDB();
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(int productCategory) {
        this.productCategory = productCategory;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public void TambahProduct(){
        query = "INSERT INTO product VALUES(?,?,?,?,?) ";
        
    try {
        ps = koneksi.prepareStatement(query);
        ps.setInt(1, productId);
        ps.setString(2, productName);
        ps.setInt(3, productCategory);
        ps.setString(4, productDescription);
        ps.setInt(5, productPrice);
        ps.executeUpdate();
        ps.close();

        JOptionPane.showMessageDialog(null,"Data Berhasil Ditambahkan");
    } catch (SQLException e) { JOptionPane.showMessageDialog(null, "Data Gagal "
            + "Ditambahkan\n" + e.getMessage());
        }
    }

    public void UbahProduct(){
        query = "UPDATE product SET productName=?, productCategory=?, productDescription=?, "
            + "productPrice=? WHERE productId=? ";
    try {
        ps = koneksi.prepareStatement(query);
        ps.setString(1, productName);
        ps.setInt(2, productCategory);
        ps.setString(3, productDescription);
        ps.setInt(4, productPrice);
        ps.setInt(5, productId);
        ps.executeUpdate();
        ps.close();
        
        JOptionPane.showMessageDialog(null,"Data Berhasil Diubah");
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Data Gagal Diubah");
        }
    }
    
    public void HapusProduct(){
        query = "DELETE FROM product WHERE productId = ? ";
    
    try {
        ps = koneksi.prepareStatement(query);
        ps.setInt(1, productId);
        ps.executeUpdate();
        ps.close();
        JOptionPane.showMessageDialog(null,"Data Berhasil Dihapus");
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Data Gagal Dihapus");
        }
    }

    public ResultSet TampilProduct(){
        query = "SELECT * FROM product";

    try{
        st = koneksi.createStatement();
        rs = st.executeQuery(query);
    }catch (SQLException e){
        JOptionPane.showMessageDialog(null, "Data Gagal"
                + "Ditampilkan");
        }
    return rs;
    }
}
