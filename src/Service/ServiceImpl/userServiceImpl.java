/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.ServiceImpl;

import Models.User;
import Service.Database;
import Service.userService;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
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
public class userServiceImpl implements userService {

    Connection con = Database.getDBConnection();
    static Statement st = null;
    static PreparedStatement pst = null;

    @Override
    public List<User> SelectCus() {
        List<User> list = new ArrayList<>();

        try {
            st = con.createStatement();
            String query = "select * from ql_user";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                list.add(new User(rs.getString(1), rs.getString(2)));
               System.out.println(rs.getString(1)+","+rs.getString(2));
            }
        } catch (SQLException ex) {
            Logger.getLogger(userServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public Object readObj(String path) throws FileNotFoundException, IOException, ClassNotFoundException {
        try (
                 FileInputStream fis = new FileInputStream(path);  ObjectInputStream ois = new ObjectInputStream(fis);) {
            return ois.readObject();
        }
    }

    @Override
    public void writeObj(String path, Object data) throws FileNotFoundException, IOException {
        try (
                 FileOutputStream fos = new FileOutputStream(path);  ObjectOutputStream oos = new ObjectOutputStream(fos);) {
            oos.writeObject(data);
        }
    }
}
