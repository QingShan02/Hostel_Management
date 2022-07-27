package signin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.ldap.Rdn;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author TRA
 */
public class ChucNangSignIn {

    static Connection con;
    static String user;

    public static void setUser(String user) {
        ChucNangSignIn.user = user;
    }
    public static void getDBConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String DB_URL = "jdbc:sqlserver://localhost:1433;"
                + "databaseName=QLNT;";
        String USER_NAME = "sa";
        String PASSWORD = "";
        con = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
    }
    public static List<?> SelectCus(String table) throws SQLException {
        List<User> list = new ArrayList<>();
        st = con.createStatement();
        String query = "select * from "+table;
        ResultSet rs = st.executeQuery(query);
        System.out.println(rs.getRow());
        while (rs.next()) {
            list.add(new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
        }
        return list;
    }
    static Statement st = null;
    static PreparedStatement pst = null;
    public static boolean CheckKHhaveNT(String makh) throws SQLException{
        st = con.createStatement();
        ResultSet rs = st.executeQuery("select count(Ma_KH) from QL_LICHSU where Ma_KH = '"+makh+"'");
        while (rs.next()) {            
            if(rs.getInt(1)!=0){
                return true;
            }
        }
        return false;    }
    public static List<?> Select(String table) throws SQLException {
        List<User> list = new ArrayList<>();
        st = con.createStatement();
        String query = "select * from "+table;
        ResultSet rs = st.executeQuery(query);
        while (rs.next()) {
            list.add(new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
//               System.out.println(rs.getString(1)+","+rs.getString(2)+","+rs.getString(3)+","+rs.getString(4));
        }
        return list;
    }
    public static Customer SelectObject() throws SQLException{
       Customer object = null;
        System.out.println(user);
        PreparedStatement st = con.prepareStatement("select * from QL_KHACHHANG where username = ?");
        st.setString(1, user);
        ResultSet rs = st.executeQuery();
        while(rs.next()){
            object= new Customer(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getString(6));
        }
        return object;
    }
    public static void Insert(String user, String pass, String role) throws SQLException {
        PreparedStatement st = con.prepareCall("insert into USERS values(?,?,?)");
        st.setString(1, user);
        st.setString(2, pass);
        st.setString(3, role);
        st.executeUpdate();
    }

    public static void UpdateUser(String user, int remember) throws SQLException {
        PreparedStatement st = con.prepareStatement("update QL_USER set remember= ? where username =?");
        st.setInt(1, remember);
        st.setString(2, user);
        st.executeUpdate();
    }
    public static List<?> SelectNT() throws SQLException{
        List<NhaTro> list = new ArrayList<>();
        st = con.createStatement();
        ResultSet rs = st.executeQuery("select * from QL_NHATRO where Ma_NT not in (select Ma_NT from QL_LICHSU where isSoHuu =1)");
        while(rs.next()){
            list.add(new NhaTro(rs.getString(1),rs.getLong(2),rs.getInt(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7)));
        }
        return list;
    }
    public static NhaTro SelectNTCus(String makh) throws SQLException{
        NhaTro nt =null;
        st = con.createStatement();
        System.out.println(makh);
        ResultSet rs = st.executeQuery("select nt.*,cnt.Ten_ChuNT,cnt.DienThoai from QL_NHATRO nt join QL_LICHSU ls on nt.Ma_NT = ls.Ma_NT join QL_CHUNHATRO cnt on cnt.Ma_ChuNT = nt.Ma_ChuNT where ls.Ma_KH = '"+makh+"'");
        while (rs.next()) {            
            nt = new NhaTro(rs.getString(1), rs.getLong(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7),rs.getString(8),rs.getString(9));
        }
        return nt;
    }
    public static void InsertLS(String maKH, String MaNT, String ngayHH) throws SQLException{
        java.util.Date d = new java.util.Date();
        d.setMonth(d.getMonth()+Integer.parseInt(ngayHH));
        Date dated = new Date(d.getTime());
        pst = con.prepareStatement("insert into QL_LICHSU (Ma_KH,Ma_NT,Ngay_HH,isSoHuu) values(?,?,?,0)");
        pst.setString(1, maKH);
        pst.setString(2, MaNT);
        pst.setDate(3, dated);
        pst.executeUpdate();
    }
    public ChucNangSignIn() {
    }
}
