/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ResController;

import Controller.QuanLyNhaTro;
import Controller.ShowKH;
import Models.Phong;
import Models.Tang;
import Models.User;
import Service.ChucNang;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

public class API_QLNT {

    private JButton btnSua;
    private JButton btnThem;
    private JButton btnXoa;
    private JComboBox<String> cboChonTang;
    private JComboBox<String> cboTang;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private JPanel jPanel5;
    private JPanel jPanel6;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JTabbedPane jTabbedPane1;
    private JLabel lblAddress;
    private JLabel lblAddress1;
    private JLabel lblAnh;
    private JLabel lblChuNT;
    private JLabel lblDienThoai;
    private JLabel lblDientich;
    private JLabel lblEmail;
    private JLabel lblGiaphong;
    private JLabel lblImage;
    private JLabel lblMota;
    private JLabel lblName;
    private JLabel lblSonguoio;
    private JLabel lblTang;
    private JLabel lblTenPhong;
    private JLabel lblTotalPerson;
    private JLabel lblTotalPerson2;
    private JTable tblNT;
    private JTextField txtDienThoai;
    private JTextField txtDienTich;
    private JTextField txtEmail;
    private JFormattedTextField txtGiaPhong;
    private JTextArea txtMoTa;
    private JTextField txtSoNguoiO;
    private JTextField txtTenPhong;
//    DefaultTableModel tblModel;
    List<Phong> list = new ArrayList<>();
    List<User> list2 = new ArrayList<>();
    private int index = -1;

    /**
     * Creates new form QuanLyNhaTro
     */
    public API_QLNT(JButton btnSua, JButton btnThem, JButton btnXoa, JComboBox<String> cboChonTang, JComboBox<String> cboTang, JLabel jLabel1, JLabel jLabel2, JPanel jPanel1, JPanel jPanel2, JPanel jPanel3, JPanel jPanel4, JPanel jPanel5, JPanel jPanel6, JScrollPane jScrollPane1, JScrollPane jScrollPane2, JTabbedPane jTabbedPane1, JLabel lblAddress, JLabel lblAddress1, JLabel lblAnh, JLabel lblChuNT, JLabel lblDienThoai, JLabel lblDientich, JLabel lblEmail, JLabel lblGiaphong, JLabel lblImage, JLabel lblMota, JLabel lblName, JLabel lblSonguoio, JLabel lblTang, JLabel lblTenPhong, JLabel lblTotalPerson, JLabel lblTotalPerson2, JTable tblNT, JTextField txtDienThoai, JTextField txtDienTich, JTextField txtEmail, JFormattedTextField txtGiaPhong, JTextArea txtMoTa, JTextField txtSoNguoiO, JTextField txtTenPhong) {
        this.btnSua = btnSua;
        this.btnThem = btnThem;
        this.btnXoa = btnXoa;
        this.cboChonTang = cboChonTang;
        this.cboTang = cboTang;
        this.jLabel1 = jLabel1;
        this.jLabel2 = jLabel2;
        this.jPanel1 = jPanel1;
        this.jPanel2 = jPanel2;
        this.jPanel3 = jPanel3;
        this.jPanel4 = jPanel4;
        this.jPanel5 = jPanel5;
        this.jPanel6 = jPanel6;
        this.jScrollPane1 = jScrollPane1;
        this.jScrollPane2 = jScrollPane2;
        this.jTabbedPane1 = jTabbedPane1;
        this.lblAddress = lblAddress;
        this.lblAddress1 = lblAddress1;
        this.lblAnh = lblAnh;
        this.lblChuNT = lblChuNT;
        this.lblDienThoai = lblDienThoai;
        this.lblDientich = lblDientich;
        this.lblEmail = lblEmail;
        this.lblGiaphong = lblGiaphong;
        this.lblImage = lblImage;
        this.lblMota = lblMota;
        this.lblName = lblName;
        this.lblSonguoio = lblSonguoio;
        this.lblTang = lblTang;
        this.lblTenPhong = lblTenPhong;
        this.lblTotalPerson = lblTotalPerson;
        this.lblTotalPerson2 = lblTotalPerson2;
        this.tblNT = tblNT;
        this.txtDienThoai = txtDienThoai;
        this.txtDienTich = txtDienTich;
        this.txtEmail = txtEmail;
        this.txtGiaPhong = txtGiaPhong;
        this.txtMoTa = txtMoTa;
        this.txtSoNguoiO = txtSoNguoiO;
        this.txtTenPhong = txtTenPhong;
    }

    public void Clear() {
        txtGiaPhong.setText("");
        txtDienTich.setText("");
        txtTenPhong.setText("");
        txtMoTa.setText("");
        txtSoNguoiO.setText("");
        cboTang.setSelectedIndex(0);
        lblImage.setIcon(new ImageIcon("src/image/NoImg.jpg"));
    }
    JButton btn = new JButton();

    public ImageIcon resizeImage(String path) {
        ImageIcon ii = new ImageIcon(path);
        ImageIcon imageIcon = new ImageIcon(ii.getImage().getScaledInstance(330, 200, java.awt.Image.SCALE_SMOOTH));
        return imageIcon;
    }

    public void Xoa() {
        // TODO add your handling code here:\
        int[] a = tblNT.getSelectedRows();
        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            temp.add(list.get(a[i]).getMa_PHG());
        }
        for (Integer i : temp) {
            ChucNang.deletePHG(i);
        }
//        FillToList();}
        FillToList(listT.get(cboChonTang.getSelectedIndex()).getID_tang());
        fillToTable((String) cboChonTang.getSelectedItem());
    }

    public void ChonAnh() {
        try {
            JFileChooser fChooser = new JFileChooser();
            fChooser.setFileFilter(new FileNameExtensionFilter("JPEG file", "jpg", "jpeg"));

            fChooser.setDialogTitle("Chọn ảnh");
            int a = fChooser.showOpenDialog(null);
            if (a == JFileChooser.APPROVE_OPTION) {
                File fTenAnh = fChooser.getSelectedFile();
                InputStream ip = new BufferedInputStream(new FileInputStream(fTenAnh));
                OutputStream out = new BufferedOutputStream(new FileOutputStream("src/image/NhaTro/" + fTenAnh.getName()));
                byte[] b = new byte[1024];
                int i;
                while ((i = ip.read(b)) > 0) {
                    out.write(b, 0, i);
                    out.flush();
                }
                lblImage.setIcon(resizeImage("src/image/NhaTro/" + fTenAnh.getName()));
                QuanLyNhaTro.name = fTenAnh.getName();
                lblAnh.setText("");
            } else {
                System.out.println("Chưa chọn ảnh");
                name = "";
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Sua() {
        try {

            int chon = JOptionPane.showConfirmDialog(null, "Bạn có muốn Update hay không ? ", "Confirm", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (chon == JOptionPane.YES_OPTION) {
                ChucNang.UpdatePHG(txtTenPhong.getText(), Integer.parseInt(txtGiaPhong.getText().replace(",", "")), Integer.parseInt(txtDienTich.getText()), txtMoTa.getText(), name, Integer.parseInt(txtSoNguoiO.getText()), listT.get(cboTang.getSelectedIndex()).getID_tang(), ChucNang.getMa_NT(), list.get(index).getMa_PHG());
                JOptionPane.showMessageDialog(null, "Update thành công");
//                FillToList();

                FillToList(listT.get(cboChonTang.getSelectedIndex()).getID_tang());
                fillToTable((String) cboChonTang.getSelectedItem());
            }
        } catch (Exception e) {
            Logger.getLogger(QuanLyNhaTro.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void mouseClick(int index) {
        txtTenPhong.setText(list.get(index).getTen_PHG());
        txtGiaPhong.setText(String.valueOf(list.get(index).getGiaPhong()));
        txtDienTich.setText(String.valueOf(list.get(index).getDientich()));
        txtMoTa.setText(list.get(index).getMota());
        lblImage.setText(list.get(index).getHinh());
        txtSoNguoiO.setText(String.valueOf(list.get(index).getSoluong()));
//        MaNT = list.get(index).getMa_PHG();
        ImageIcon ii = new ImageIcon("src/image/NhaTro/" + list.get(index).getHinh());
        name = list.get(index).getHinh();
        ImageIcon imageIcon = new ImageIcon(ii.getImage().getScaledInstance(330, 200, java.awt.Image.SCALE_SMOOTH));
        lblImage.setIcon(imageIcon);
        lblImage.setText("");
//        tblNT.getValueAt(ERROR, NORMAL)
        System.out.println(list.get(index).getName_Tang());
        cboTang.setSelectedItem(list.get(index).getName_Tang());
    }

    public void FillToList(String maTang) {
        try {
            list.clear();
            list = (List<Phong>) ChucNang.SelectPHG(maTang);
//            for(Phong x : list){
//                System.out.println(x.getTen_PHG()+","+x.getName_Tang());
//            }
        } catch (SQLException ex) {
            Logger.getLogger(QuanLyNhaTro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    int i = 0;
    String name = "";
    DefaultTableModel tblModel;

    public void fillToTable(String name) {
        tblModel = new DefaultTableModel();
        tblModel.setRowCount(0);
        tblModel.setColumnIdentifiers(new Object[]{"STT", "Tên Phòng", "Giá Phòng", "Số lượng ở tối đa","Số lượng đang ở", "Chi tiết khách hàng"});
        JButton btn = null;
        for (Phong nt : list) {

            if (nt.getName_Tang().equalsIgnoreCase(name)) {
                i++;
//                btn = new JButton();
                tblModel.addRow(new Object[]{i, nt.getTen_PHG(), nt.getGiaPhong() + " VND", nt.getSoluong() + " người/phòng"/*(nt.getTenNguoiDaiDien().equalsIgnoreCase("null") ? "":nt.getTenNguoiDaiDien())*/, nt.getSoLuongDangCo()});

            }
        }
        tblNT.setModel(tblModel);
        tblNT.getTableHeader().setBackground(new Color(25, 149, 242));
        tblNT.getColumnModel().getColumn(5).setCellRenderer(new ButtonRenderer());
        tblNT.getColumnModel().getColumn(5).setCellEditor(new ButtonEditor(new JCheckBox()));

//        for (int i = 0; i < list.size(); i++) {
//            btn = (JButton) tblNT.getValueAt(i, 5);
//            btn.addActionListener(new ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent e) {
//                    index = tblNT.getSelectedRow();
//                    ChucNang.setMa_PHG(list.get(index).getMa_PHG());
////                    ShowKH show = new ShowKH();
////                    show.setVisible(true);
//                    start();
//                }
//            });
//        }
        i = 0;
    }

    List<Tang> listT;
    String maChu = "";

    public void FillTang() {
        try {
            listT = ChucNang.SelectTang();
            for (Tang x : listT) {
                cboTang.addItem(x.getName_tang());
                cboChonTang.addItem(x.getName_tang());
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuanLyNhaTro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void Them() {
        if (index == -1) {
            try {
                ChucNang.InsertPHG(txtTenPhong.getText(), Integer.parseInt(txtGiaPhong.getText().replace(",", "")), Integer.parseInt(txtDienTich.getText()), txtMoTa.getText(), name, Integer.parseInt(txtSoNguoiO.getText()), listT.get(cboTang.getSelectedIndex()).getID_tang(), ChucNang.getMa_NT());
                FillToList(listT.get(cboChonTang.getSelectedIndex()).getID_tang());
                fillToTable((String) cboChonTang.getSelectedItem());
            } catch (SQLException ex) {
                Logger.getLogger(QuanLyNhaTro.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    int z = 0;

    public synchronized void ButtonCT() {
        System.out.println("c1");

    }

    DataInputStream ips;
//    DataOutputStream ops;

    Thread t;

    public void start() {
        try {
            ServerSocket sk = new ServerSocket(8889);
//            ExecutorService pool = Executors.newFixedThreadPool(4);
            System.out.println(">>c");
            ShowKH show = new ShowKH();
            show.setTitle("Khách hàng - " + list.get(index).getTen_PHG());
            Socket socket = sk.accept();
            ips = new DataInputStream(socket.getInputStream());

            show.setVisible(true);
//            a test = new a();
            System.out.println(">>d");
//            ops = new DataOutputStream(socket.getOutputStream());

//            btnStart.setEnabled(false);
//            txtClient.setText("-- kết nối server thành công --\n");
            ButtonCT();
            new Thread() {
                public void run() {
                    while (true) {
                        try {
                            z = ips.readInt();
                            System.out.println(z);
//                    System.out.println(Thread.currentThread().getName());
                            if (z == -1) {
                                break;
                            } else if (z > 0) {
//                    cboChonTang.setSelectedIndex(0);
                                FillToList(listT.get(cboChonTang.getSelectedIndex()).getID_tang());
//                    fillToTable((String) cboChonTang.getSelectedItem());
                                tblModel = (DefaultTableModel) tblNT.getModel();
                                tblModel.setRowCount(0);
                                for (int i = 0; i < list.size(); i++) {
                                    Phong nt = list.get(i);
                                    tblModel.addRow(new Object[]{i+1, nt.getTen_PHG(), nt.getGiaPhong() + " VND", nt.getSoluong() + " người/phòng"/*(nt.getTenNguoiDaiDien().equalsIgnoreCase("null") ? "":nt.getTenNguoiDaiDien())*/, nt.getSoLuongDangCo()});
                                }
//                    sk.close();
                                z = 0;
                            }
                        } catch (IOException ex) {
                            ex.printStackTrace();
//                Logger.getLogger(QuanLyNhaTro.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }.start();
//            System.out.println("a");
            sk.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    class ButtonRenderer extends JButton implements TableCellRenderer {

        public ButtonRenderer() {
            setOpaque(true);
//            btn.removeActionListener((ActionListener) this);
            btn.addActionListener(
                    new ActionListener() {
                public void actionPerformed(ActionEvent event) {
                    index = tblNT.getSelectedRow();
                    ChucNang.setMa_PHG(list.get(index).getMa_PHG());
//                    ShowKH show = new ShowKH();
//                    show.setVisible(true);
                    System.out.println(">>a");
                    start();
                    System.out.println(">>b");
//                    btn.removeActionListener(this);
                }
            }
            );

        }

        public Component getTableCellRendererComponent(JTable table, Object value,
                boolean isSelected, boolean hasFocus, int row, int column) {
            setText("Xem chi tiết");
            return this;
        }
    }

    public void ChonTang() {
        FillToList(listT.get(cboChonTang.getSelectedIndex()).getID_tang());

        fillToTable((String) cboChonTang.getSelectedItem());

    }

    class ButtonEditor extends DefaultCellEditor {

        private String label;
        private boolean click;

        public ButtonEditor(JCheckBox checkBox) {
            super(checkBox);
//                    btn.addActionListener(
//                new ActionListener() {
//            public void actionPerformed(ActionEvent event) {
//                fireEditingStoped();
//            }
//        }
//        );
        }

        public Component getTableCellEditorComponent(JTable table, Object value,
                boolean isSelected, int row, int column) {
            label = "Xem chi tiết";
            btn.setText(label);
            click = true;
            return btn;
        }

//        public Object getCellEditorValue() {
//            if(click){
//                System.out.println("hello"+label);
//            }
//            click = false;
//            return new String(label);
//        }
//        protected void fireEditingStoped(){
//            super.fireEditingStopped();
//        }
    }
}
