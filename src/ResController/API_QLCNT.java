/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ResController;

import Controller.DOIMK;
import Controller.QuanLyNhaTro;
import Controller.SignIn;
import Models.ChuNhaTro;
import Models.User;
import Service.ChucNang;
import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

/**
 *
 * @author Daokh
 */
public class API_QLCNT {

    static private JToggleButton btnCapNhat;
    static private JButton btnDangxuat;
    static private JButton btnDoiMK;
    static private JToggleButton btnDong;
    static private JToggleButton btnEdit;
    static private JLabel lblChuNT;
    static private JLabel lblDienThoai;
    static private JLabel lblEmail;
    static private JLabel lblTenCNT;
    static private JTextField txtChuNT;
    static private JTextField txtDienThoai;
    static private JTextField txtEmail;
    static private JTextField txtTenCNT;

    public API_QLCNT() {
    }

    public API_QLCNT(JToggleButton btnCapNhat, JButton btnDangxuat, JButton btnDoiMK, JToggleButton btnDong, JToggleButton btnEdit, JLabel lblChuNT, JLabel lblDienThoai, JLabel lblEmail, JLabel lblTenCNT, JTextField txtChuNT, JTextField txtDienThoai, JTextField txtEmail, JTextField txtTenCNT) {
        this.btnCapNhat = btnCapNhat;
        this.btnDangxuat = btnDangxuat;
        this.btnDoiMK = btnDoiMK;
        this.btnDong = btnDong;
        this.btnEdit = btnEdit;
        this.lblChuNT = lblChuNT;
        this.lblDienThoai = lblDienThoai;
        this.lblEmail = lblEmail;
        this.lblTenCNT = lblTenCNT;
        this.txtChuNT = txtChuNT;
        this.txtDienThoai = txtDienThoai;
        this.txtEmail = txtEmail;
        this.txtTenCNT = txtTenCNT;
    }
    static ChuNhaTro cnt;
static String maChu;
    public static void fillToCNT() {
        cnt = ChucNang.selectCNT();
       maChu = cnt.getMaChu();
        txtChuNT.setText(cnt.getMaChu());
        txtTenCNT.setText(cnt.getTenChu());
        txtDienThoai.setText(cnt.getDT());
        txtEmail.setText(cnt.getEmail());
    }
    static List<User> list2 = new ArrayList<>();

    public static void DX() {
        try {
            list2 = (List<User>) ChucNang.readObj("x.txt");
            for (User x : list2) {
                if (x.getUser().equalsIgnoreCase(cnt.getUsernameChu())) {
                    if (!x.isRemember()) {
                        list2.remove(x);
                        break;
                    } else {
                        x.setIsLogin(false);
                    }
                }
            }
            ChucNang.writeObj("x.txt", list2);
        } catch (IOException ex) {
            Logger.getLogger(QuanLyNhaTro.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(QuanLyNhaTro.class.getName()).log(Level.SEVERE, null, ex);
        }
//        this.setVisible(false);
//        new SignIn().setVisible(true);
    }

    public static void Sua() {
        txtChuNT.setEditable(true);
        txtTenCNT.setEditable(true);
        txtDienThoai.setEditable(true);
        txtEmail.setEditable(true);
    }

    public static void Dong() {
        txtChuNT.setEditable(false);
        txtTenCNT.setEditable(false);
        txtDienThoai.setEditable(false);
        txtEmail.setEditable(false);
    }
    public static  boolean checkValidate() {
        if (txtChuNT.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Vui lòng không bỏ trống ");
            txtChuNT.setBackground(Color.yellow);
            return false;
        } else if (txtTenCNT.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Vui lòng không bỏ trống ");
            txtTenCNT.setBackground(Color.yellow);
            return false;
        } else if (txtDienThoai.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Vui lòng không bỏ trống ");
            txtDienThoai.setBackground(Color.yellow);
            return false;
        } else if (txtEmail.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Vui lòng không bỏ trống ");
            txtEmail.setBackground(Color.yellow);
            return false;

        }
        return true;
    }
    public static void CapNhat(){
        try {
            if (checkValidate()) {
                int chon = JOptionPane.showConfirmDialog(null, "Bạn có muốn Update hay không ? ", "Confirm", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (chon == JOptionPane.YES_OPTION) {
                    ChucNang.UpdateChuNT(txtTenCNT.getText(), txtDienThoai.getText(), txtEmail.getText(), maChu);
                    JOptionPane.showMessageDialog(null, "Update thành công");
                }
            }
        } catch (Exception e) {
            Logger.getLogger(QuanLyNhaTro.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    public static void DoiMK(){
        SendEmail.email.GuiEmail("khaiminh0401@gmail.com");

        String maXacThuc = JOptionPane.showInputDialog(null, "Nhập mã xác thực email");

        if (maXacThuc.equals("")) {
            JOptionPane.showMessageDialog(null, "Chưa nhập mã xác thực");
        } else {
            if (maXacThuc.equals(SendEmail.email.maxt)) {
                JOptionPane.showMessageDialog(null, "Đã nhập chính xác!");
                DOIMK doimk = new DOIMK();
                doimk.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Nhập không chính xác!");
            }
        }
    }
}
