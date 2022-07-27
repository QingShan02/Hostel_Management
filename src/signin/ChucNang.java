
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
public class ChucNang {

    static Connection con;
    static String user;

    public static void setUser(String user) {
        ChucNang.user = user;
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
            list.add(new User(rs.getString(1), rs.getString(2), rs.getInt(3)));
//               System.out.println(rs.getString(1)+","+rs.getString(2)+","+rs.getString(3)+","+rs.getString(4));
        }
        return list;
    }

    public static ChuNhaTro selectCNT() {
        ChuNhaTro cnt=null;

        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from QL_CHUNHATRO where username = '"+user+"'");
            while (rs.next()) {
                cnt =new ChuNhaTro(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChucNang.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cnt;
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
        ResultSet rs = st.executeQuery("select * from QL_NHATRO ");
        while (rs.next()) {
            list.add(new NhaTro(rs.getInt(1), rs.getString(2), rs.getLong(3), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getString(9), rs.getString(10)));
        }
        return list;
    }

    public ChucNang() {
    }
}

