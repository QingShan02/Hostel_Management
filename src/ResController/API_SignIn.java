/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ResController;

import Controller.ChiNhanh;
import Controller.QuanLyNhaTro;
import Controller.SignIn;
import Models.User;
import Service.ChucNang;
import Service.ServiceImpl.userServiceImpl;
import java.awt.Color;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author Daokh
 */
public class API_SignIn {

    userServiceImpl service = new userServiceImpl();

    private JLabel background;
    private JButton btnSignIn;
    private JCheckBox chkRemember;
    private JLabel closeEye;
    private JLabel jLabel5;
    private JSeparator jSeparator1;
    private JSeparator jSeparator2;
    private JLabel lblIconUser;
    private JLabel lblPass;
    private JLabel lblPassword;
    private JLabel lblSignIn;
    private JLabel lblUser;
    private JLabel lblUsername;
    private JLabel openEye;
    private JPasswordField txtPassword;
    private JTextField txtUsername;

    public API_SignIn(JLabel background, JButton btnSignIn, JCheckBox chkRemember, JLabel closeEye, JLabel jLabel5, JSeparator jSeparator1, JSeparator jSeparator2, JLabel lblIconUser, JLabel lblPass, JLabel lblPassword, JLabel lblSignIn, JLabel lblUser, JLabel lblUsername, JLabel openEye, JPasswordField txtPassword, JTextField txtUsername) {
        this.background = background;
        this.btnSignIn = btnSignIn;
        this.chkRemember = chkRemember;
        this.closeEye = closeEye;
        this.jLabel5 = jLabel5;
        this.jSeparator1 = jSeparator1;
        this.jSeparator2 = jSeparator2;
        this.lblIconUser = lblIconUser;
        this.lblPass = lblPass;
        this.lblPassword = lblPassword;
        this.lblSignIn = lblSignIn;
        this.lblUser = lblUser;
        this.lblUsername = lblUsername;
        this.openEye = openEye;
        this.txtPassword = txtPassword;
        this.txtUsername = txtUsername;
    }
    ChiNhanh cv;
    QuanLyNhaTro nt;
    List<User> list = new ArrayList<>();
    List<User> list2 = new ArrayList<>();
    int DaTT = -1;

    public void CheckRemember() {
        try {
            list2 = (List<User>) ChucNang.readObj("x.txt");
            for (User s : list2) {
                if (s.isIsLogin()) {
                    ChucNang.setUser(s.getUser());
//                    nt = new QuanLyNhaTro();
//                    nt.setVisible(false);
                    SignIn.a = false;
                    cv = new ChiNhanh();
                    cv.setVisible(true);
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void FillPass() {
        try {
            String name = txtUsername.getText();
            boolean temp = chkRemember.isSelected();
            for (int i = 0; i < list2.size(); i++) {
                txtPassword.setText("");
                if (list2.get(i).getUser().equalsIgnoreCase(name) && list2.get(i).isRemember()) {
                    txtPassword.setText(list2.get(i).getPass());
                    chkRemember.setSelected(list2.get(i).isRemember());
                    DaTT = i;
                    break;
                }

            }
//            list = (List<User>) ChucNang.readObj("b.txt");
//            for (User s : list) {
//                if (txtUsername.getText().equals(s.getUser())) {
//                    txtPassword.setText(s.getPass());
//                }
//            }
        } catch (Exception e) {
        }
    }

    public boolean dangnhap() {
        String user= txtUsername.getText();
        String pass = new String(txtPassword.getPassword());
        try {

            for (User s : list) {
                if (s.getUser().equalsIgnoreCase(user) && s.getPass().equalsIgnoreCase(pass)) {
                    if (DaTT == -1) {
                        list2.add(new User(user, String.valueOf(pass), chkRemember.isSelected(), true));
                    } else if (DaTT != -1) {
                        list2.set(DaTT, new User(user, String.valueOf(pass), chkRemember.isSelected(), true));
                    }
                    ChucNang.writeObj("x.txt", list2);
                    ChucNang.setUser(s.getUser());

                    cv = new ChiNhanh();
                    cv.setVisible(true);
//                    QuanLyNhaTro ql = new QuanLyNhaTro();
//                    ql.setVisible(true);
//                    LoadingForm lf = new LoadingForm();
//                    lf.setVisible(true);
//                    this.setVisible(false);
                    return true;
                }
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        String tb = "";
        boolean chk = false;
        for (User x : list) {
            if (x.getUser().equalsIgnoreCase(user)) {
                tb = "Bạn đã nhập sai mật khẩu";
                chk = true;
            }
        }
        if (!chk) {
            tb = "Username của bạn không tồn tại";
        }
        JOptionPane.showMessageDialog(null, tb, "Thông báo lỗi", JOptionPane.ERROR_MESSAGE);

        return false;

    }

    public void FillToList() {
        list = service.SelectCus();
    }
}
