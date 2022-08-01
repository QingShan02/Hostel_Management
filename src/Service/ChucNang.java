/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Models.ChuNhaTro;
import Models.Customer;
import Models.NhaTro;
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

/**
 *
 * @author Daokh
 */
public class ChucNang {

    static Connection con;
    static String user;
    static String Ma_ChuNT;

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

    public static void setUser(String user) {
        ChucNang.user = user;
    }

    public static void setNT(String Ma_ChuNT) {
        ChucNang.Ma_ChuNT = Ma_ChuNT;
    }

    public static void getDBConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String DB_URL = "jdbc:sqlserver://localhost:1433;"
                + "databaseName=QLNT;";
        String USER_NAME = "sa";
        String PASSWORD = "123456";
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
                cnt = new ChuNhaTro(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5));
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

    public static void UpdateNT(String tenPhong, String gia, String dienTich, String diaChi, String moTa, String hinh, String soLuong, String ngayHH, String Ma_NT) throws SQLException {
        PreparedStatement st = con.prepareStatement("update QL_NHATRO set TenPhong=?,GiaPhong=?,DienTich=?,DiaChi=?,MoTa=?,Hinh=?,SL_ToiDa=?,NgayHH=? where Ma_NT = ?");
        st.setString(1, tenPhong);
        st.setString(2, gia);
        st.setString(3, dienTich);
        st.setString(4, diaChi);
        st.setString(5, moTa);
        st.setString(6, hinh);
        st.setString(7, soLuong);
        st.setString(8, ngayHH);
        st.setString(9, Ma_NT);
        st.executeUpdate();
    }

    public static Customer SelectCus() throws SQLException {
        Customer object = null;
        System.out.println(user);
        PreparedStatement st = con.prepareStatement("select * from QL_KHACHHANG where username = ?");
        st.setString(1, user);
        ResultSet rs = st.executeQuery();
        while (rs.next()) {
            object = new Customer(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));
        }
        return object;
    }

    public static void UpdateUser(String user, int remember) throws SQLException {
        PreparedStatement st = con.prepareStatement("update QL_USER set remember= ? where username =?");
        st.setInt(1, remember);
        st.setString(2, user);
        st.executeUpdate();
    }

    public static List<?> SelectNT() throws SQLException {
        List<NhaTro> list = new ArrayList<>();
        st = con.createStatement();
        ResultSet rs = st.executeQuery("select * from QL_NHATRO where Ma_ChuNT = '" + Ma_ChuNT + "'");
        while (rs.next()) {
            list.add(new NhaTro(rs.getInt(1), rs.getString(2), rs.getLong(3), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getString(9), rs.getString(10)));
        }
        return list;
    }

    public static void InsertNT(String tenPhong, int gia, int dienTich, String diaChi, String moTa, String hinh, int soLuong, String ngayHH, String maChu) throws SQLException {
        pst = con.prepareStatement("insert into QL_NHATRO values (?,?,?,?,?,?,?,?,?,?)");
        pst.setString(1, tenPhong);
        pst.setInt(2, gia);
        pst.setInt(3, dienTich);
        pst.setString(4, diaChi);
        pst.setString(5, moTa);
        pst.setString(6, hinh);
        pst.setInt(7, soLuong);
        pst.setString(8, ngayHH);
        pst.setString(9, maChu);
        pst.executeUpdate();
    }

    public ChucNang() {
    }
}
