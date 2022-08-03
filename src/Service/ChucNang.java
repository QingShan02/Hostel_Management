/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Models.ChuNhaTro;
import Models.Customer;
import Models.NhaTro;
import Models.Phong;
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
    static int Ma_NT;

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

    public static void UpdateNT(String tenPhong, String gia, String dienTich, String moTa, String hinh, String soLuong, String Ma_NT) throws SQLException {
        PreparedStatement st = con.prepareStatement("update QL_Phong set TenPhong=?,GiaPhong=?,DienTich=?,MoTa=?,Hinh=?,SL_ToiDa=?where Ma_NT = ?");
        st.setString(1, tenPhong);
        st.setString(2, gia);
        st.setString(3, dienTich);
        st.setString(4, moTa);
        st.setString(5, hinh);
        st.setString(6, soLuong);
        st.setString(7, Ma_NT);
        st.executeUpdate();
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
        ResultSet rs = st.executeQuery("select phg.*,tang.TenTang from QL_Phong phg join QL_Tang tang on tang.ID_Tang = phg.ID_Tang join QL_NhaTro nt on phg.Ma_NT = nt.Ma_NT where nt.Ma_NT = "+Ma_NT+"");
        while (rs.next()) {
            list.add(new Phong(rs.getInt(1), rs.getString(2), rs.getLong(3), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getString(8),rs.getInt(9),rs.getString(10)));
        }
        return list;
    }
    public static List<NhaTro> SelectNT () throws SQLException{
        List<NhaTro> list = new ArrayList<>();
        st = con.createStatement();
        ResultSet rs = st.executeQuery("select nt.* from QL_NhaTro nt join QL_CHUNHATRO cnt on cnt.Ma_ChuNT = nt.Ma_ChuNT where cnt.username = '"+user+"'");
        while (rs.next()) {
            list.add(new NhaTro(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
        }
        return list;
    }
    public static void InsertNT(String tenPhong, int gia, int dienTich, String moTa, String hinh, int soLuong, String maChu) throws SQLException {
        pst = con.prepareStatement("insert into QL_Phong values (?,?,?,?,?,?,?)");
        pst.setString(1, tenPhong);
        pst.setInt(2, gia);
        pst.setInt(3, dienTich);
        pst.setString(4, moTa);
        pst.setString(5, hinh);
        pst.setInt(6, soLuong);
        pst.setString(7, maChu);
        pst.executeUpdate();
        pst.close();
    }
public static void deleteNT(int maNT) {
        try (
            PreparedStatement pt = con.prepareStatement("DELETE FROM QL_Phong WHERE Ma_NT = ?");) {
            pst.setInt(0, maNT);
//            System.out.println("Thành công!!! " + add + " Dòng");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public ChucNang() {
    }
}
