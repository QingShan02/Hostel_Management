/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Models.ChuNhaTro;
import Models.Customer;
import Models.NhaTro;
import Models.Phong;
import Models.Tang;
import Models.User;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;

/**
 *
 * @author Daokh
 */
public class ChucNang {

    static Connection con;
    static String user;
    static int Ma_NT;
static String tenNT;

    public static String getTenNT() {
        return tenNT;
    }

    public static void setTenNT(String tenNT) {
        ChucNang.tenNT = tenNT;
    }
    public static Object readObj(String path) throws FileNotFoundException, IOException, ClassNotFoundException {
        try (
                 FileInputStream fis = new FileInputStream(path);  ObjectInputStream ois = new ObjectInputStream(fis);) {
            return ois.readObject();
        }
    }

    public static void writeObj(String path, Object data) throws FileNotFoundException, IOException {
        try (
                 FileOutputStream fos = new FileOutputStream(path);  ObjectOutputStream oos = new ObjectOutputStream(fos);) {
            oos.writeObject(data);
        }
    }

    public static int getMa_NT() {
        return Ma_NT;
    }

    public static void setMa_NT(int Ma_NT) {
        ChucNang.Ma_NT = Ma_NT;
    }

    public static void setUser(String user) {
        ChucNang.user = user;
    }

    public static void setNT(int Ma_ChuNT) {
        ChucNang.Ma_NT = Ma_ChuNT;
    }

    public static void getDBConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String DB_URL = "jdbc:sqlserver://localhost:1433;"
                + "databaseName=QLNT;";
        String USER_NAME = "sa";
        String PASSWORD = "";
        con = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
    }
    static Statement st = null;
    static PreparedStatement pst = null;

    public static List<?> SelectUser() throws SQLException {
        List<User> list = new ArrayList<>();
        st = con.createStatement();
        String query = "select * from ql_user";
        ResultSet rs = st.executeQuery(query);
        while (rs.next()) {
            list.add(new User(rs.getString(1), rs.getString(2)));
//               System.out.println(rs.getString(1)+","+rs.getString(2)+","+rs.getString(3)+","+rs.getString(4));
        }
        return list;
    }

    public static ChuNhaTro selectCNT() {
        ChuNhaTro cnt = null;

        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from QL_CHUNHATRO where username = '" + user + "'");
            while (rs.next()) {
                cnt = new ChuNhaTro(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChucNang.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cnt;
    }

    public static void UpdateChuNT(String tenCNT, String soDT, String email, String maChu) throws SQLException {
        PreparedStatement st = con.prepareStatement("update QL_CHUNHATRO set Ten_ChuNT = ?, DienThoai = ?, Email = ? where Ma_ChuNT = ?");
        st.setString(1, tenCNT);
        st.setString(2, soDT);
        st.setString(3, email);
        st.setString(4, maChu);
        st.executeUpdate();
    }

    public static void UpdatePHG(String tenPhong, int gia, int dienTich, String moTa, String hinh, int soLuong,String id_tang, int Ma_NT,int Ma_PHG) throws SQLException {
        PreparedStatement st = con.prepareStatement("update QL_Phong set TenPhong=?,GiaPhong=?,DienTich=?,MoTa=?,Hinh=?,SL_ToiDa=?,ID_Tang =?,Ma_NT=? where Ma_PHG = ?");
        st.setString(1, tenPhong);
        st.setInt(2, gia);
        st.setInt(3, dienTich);
        st.setString(4, moTa);
        st.setString(5, hinh);
        st.setInt(6, soLuong);
        st.setString(7, id_tang);
        st.setInt(8, Ma_NT);
        st.setInt(9, Ma_PHG);
        st.executeUpdate();
    }
    public static List<Tang> SelectTang() throws SQLException{
        List<Tang> list = new ArrayList<>();
        st = con.createStatement();
        ResultSet rs = st.executeQuery("select * from QL_Tang");
        while(rs.next()){
            list.add(new Tang(rs.getString(1),rs.getString(2)));
        }
        return list;
    }
    public static Customer SelectCus() throws SQLException {
        Customer object = null;
        System.out.println(user);
        PreparedStatement st = con.prepareStatement("select * from QL_KHACHHANG where username = ?");
        st.setString(1, user);
        ResultSet rs = st.executeQuery();
        while (rs.next()) {
            object = new Customer(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
        }
        return object;
    }

    public static List<?> SelectPHG() throws SQLException {
        List<Phong> list = new ArrayList<>();
        st = con.createStatement();
        ResultSet rs = st.executeQuery("select phg.*,tang.TenTang from QL_Phong phg join QL_Tang tang on tang.ID_Tang = phg.ID_Tang join QL_NhaTro nt on phg.Ma_NT = nt.Ma_NT where nt.Ma_NT = " + Ma_NT + "");
        while (rs.next()) {
            list.add(new Phong(rs.getInt(1), rs.getString(2), rs.getLong(3), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getString(8), rs.getInt(9), rs.getString(10)));
        }
        return list;
    }

    public static List<NhaTro> SelectNT() throws SQLException {
        List<NhaTro> list = new ArrayList<>();
        st = con.createStatement();
        ResultSet rs = st.executeQuery("select nt.* from QL_NhaTro nt join QL_CHUNHATRO cnt on cnt.Ma_ChuNT = nt.Ma_ChuNT where cnt.username = '" + user + "'");
        while (rs.next()) {
            list.add(new NhaTro(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
        }
        return list;
    }

    public static void InsertPHG(String tenPhong, int gia, int dienTich, String moTa, String hinh, int soLuongTD, String ID_Tang, int Ma_NT) throws SQLException {
        pst = con.prepareStatement("insert into QL_Phong values (?,?,?,?,?,?,?,?)");
        pst.setString(1, tenPhong);
        pst.setInt(2, gia);
        pst.setInt(3, dienTich);
        pst.setString(4, moTa);
        pst.setString(5, hinh);
        pst.setInt(6, soLuongTD);
        pst.setString(7, ID_Tang);
        pst.setInt(8, Ma_NT);
        pst.executeUpdate();
        pst.close();
    }

    public static void deletePHG(int Ma_PHG) {
        try (
                 PreparedStatement pt = con.prepareStatement("DELETE FROM QL_Phong WHERE Ma_PHG = ?");) {
            pt.setInt(1, Ma_PHG);
            pt.executeUpdate();
//            System.out.println("Thành công!!! " + add + " Dòng");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void UpdateUser(String PASS) throws SQLException{
        
        PreparedStatement pt = con.prepareStatement("UPDATE QL_USER SET PASS = ? WHERE USERNAME = '" + user +"'");
        pt.setString(1,PASS);
        pt.executeUpdate();
        System.out.println(user);
    }

    public ChucNang() {
    }
}
