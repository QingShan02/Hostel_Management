/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Controller;

import Models.Customer;
import Models.Phong;
import Service.ChucNang;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractButton;
import javax.swing.AbstractCellEditor;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Daokh
 */
public class ShowKH extends javax.swing.JFrame implements Runnable {

    /**
     * Creates new form ShowKH
     */
    ButtonGroup buttonGroup = new ButtonGroup();
    int ndd;

//    class RadioButtonRenderer implements TableCellRenderer {
//
//        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
//            if (value == null) {
//                return null;
//            }
////            buttonGroup.add((JRadioButton) value);
//            return (Component) value;
//        }
//    }
//public class RadioButtonCellEditorRenderer extends AbstractCellEditor implements TableCellRenderer, TableCellEditor, ActionListener {
//
//        private JRadioButton radioButton;
//
//        public RadioButtonCellEditorRenderer() {
//            this.radioButton = new JRadioButton();
//            radioButton.addActionListener(this);
//            radioButton.setOpaque(false);
//        }
//
//        @Override
//        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
//            radioButton.setSelected(Boolean.TRUE.equals(value));
//            return radioButton;
//        }
//
//        @Override
//        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
//            radioButton.setSelected(Boolean.TRUE.equals(value));
//            return radioButton;
//        }
//
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            stopCellEditing();
//        }
//
//        @Override
//        public Object getCellEditorValue() {
//            return radioButton.isSelected();
//        }
//
//    }
//    class RadioButtonEditor extends DefaultCellEditor implements ItemListener {
//
//        private JRadioButton button;
//
//        public RadioButtonEditor(JCheckBox checkBox) {
//            super(checkBox);
//        }
//
//        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
//            if (value == null) {
//                return null;
//            }
//            button = (JRadioButton) value;
////            buttonGroup.add(button);
//
//            button.addItemListener(new ItemListener() {
//                @Override
//                public void itemStateChanged(ItemEvent e) {
//                    bg.clearSelection();
//                    rdo[tblCus.getSelectedRow()].setSelected(true);                }
//            });
//
//            return (Component) value;
//        }
//
//        public Object getCellEditorValue() {
//            button.removeItemListener(this);
//            return button;
//        }
//
//        public void itemStateChanged(ItemEvent e) {
//            super.fireEditingStopped();
//        }
//    }
    public class RadioButtonCellEditorRenderer extends AbstractCellEditor implements TableCellRenderer, TableCellEditor, ActionListener {

        private JRadioButton radioButton;
        ButtonGroup buttonGroup = new ButtonGroup();

        public RadioButtonCellEditorRenderer(JRadioButton radioButton) {
            this.radioButton = radioButton;
        }

        public RadioButtonCellEditorRenderer() {
            this.radioButton = new JRadioButton();
            radioButton.addActionListener(this);
            radioButton.setOpaque(false);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            radioButton.setSelected(Boolean.TRUE.equals(value));
            return radioButton;
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            radioButton.setSelected(Boolean.TRUE.equals(value));
            return radioButton;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            stopCellEditing();
        }

        @Override
        public Object getCellEditorValue() {
            return radioButton.isSelected();
        }

    }

    @Override
    public void run() {
        while (true) {
            try {

                Thread.sleep(50);
            } catch (Exception e) {
            }
        }
    }

    public int index = -1;
    List<Customer> list = new ArrayList<>();
    List<Phong> list1 = new ArrayList<>();
    static int Ma_PHG;

    public static int getMa_PHG() {
        return Ma_PHG;
    }

    public static void setMa_PHG(int Ma_PHG) {
        ShowKH.Ma_PHG = Ma_PHG;
    }
    DataInputStream ips;
    DataOutputStream ops;

    public void Connect() {
        try {
            Socket sk = new Socket("localhost", 8889);
            ips = new DataInputStream(sk.getInputStream());
            ops = new DataOutputStream(sk.getOutputStream());
//            Thread t = new Thread(this);
//            t.start();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public ShowKH() {
        try {
            initComponents();
            ChucNang.getDBConnection();
            FilltoTable();
            Connect();
        } catch (SQLException ex) {
            Logger.getLogger(ShowKH.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ShowKH.class.getName()).log(Level.SEVERE, null, ex);
        }
//        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    }
    DefaultTableModel model;
    private ButtonGroup bg;

    int k = 0;
    JRadioButton[] rdo;

    public void FilltoTable() throws SQLException {
        list = ChucNang.SelectCus();
        boolean a = false;
        model = new DefaultTableModel();
//model = new DefaultTableModel();
        model.setRowCount(0);
//        bg = new ButtonGroup();
        Object[][] in4 = new Object[list.size()][3];
        for (int i = 0; i < list.size(); i++) {
            in4[i][0] = list.get(i).getHoTen();
            in4[i][1] = list.get(i).getSDT();
            in4[i][2] = list.get(i).getMail();

        }
        model.setDataVector(in4, new String[]{"Tên khách hàng", "Số điện thoại", "Email"});
        tblCus.setModel(model);

    }

    public void mouseClick(int index) {
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblCus = new javax.swing.JTable();
        btnThem = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnCapnhat = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        tblCus.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Tên khách hàng", "Điện thoại", "Email"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblCus.getTableHeader().setReorderingAllowed(false);
        tblCus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCusMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblCus);

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnCapnhat.setText("Cập nhật");
        btnCapnhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapnhatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCapnhat, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnThem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnXoa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCapnhat)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
//       this.setVisible(false);
    }//GEN-LAST:event_formWindowClosed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        System.out.println("a");
    }//GEN-LAST:event_formWindowClosing

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
//        this.setVisible(false);
    }//GEN-LAST:event_formWindowActivated

    private void tblCusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCusMouseClicked
        // TODO add your handling code here:
//        index = tblCus.getSelectedRow();
//        boolean a = (list.get(index).getNguoiDD() == list.get(index).getMa_KH()) ? true : false;
//        boolean b = (boolean) tblCus.getValueAt(index, 3);
//        if (a == b) {
////            tblCus;
//        }
    }//GEN-LAST:event_tblCusMouseClicked
    Customer c;
    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        try {

            // TODO add your handling code here:
//            boolean ndd = false;
//            index = tblCus.getSelectedRow();
//            String name = (String) model.getValueAt(index, 0);
//            String sdt = (String) model.getValueAt(index, 1);
//            String email = (String) model.getValueAt(index, 2);
            String name = JOptionPane.showInputDialog(this, "Nhập tên");
            if (name.equals("")) {
                JOptionPane.showMessageDialog(this, "Bạn chưa nhập name");
                return;
            }
            String sdt = JOptionPane.showInputDialog(this, "Nhập SDT");
            if (sdt.equals("")) {
                JOptionPane.showMessageDialog(this, "Bạn chưa nhập sdt");
                return;
            } else if (!sdt.matches("\\d{9,10}")) {
                JOptionPane.showMessageDialog(this, "Bạn vui lòng nhập đúng định dạng sdt");
                return;
            }
            String reEmail = "^([\\w\\.\\-]+)@([\\w\\-]+)((\\.(\\w){2,3})+)$";
            String email = JOptionPane.showInputDialog(this, "Nhập Email");
            if (email.equals("")) {
                JOptionPane.showMessageDialog(this, "Bạn chưa nhập email");
                return;
            }
            for(Phong p : list1){
                if(p.getSoLuongDangCo()>p.getSoluong()){
                    JOptionPane.showMessageDialog(this,"aaa");
                    return;
                }
            }
            
            
            
//            } else if (reEmail.matches(reEmail) == false) {
//                JOptionPane.showMessageDialog(this, "Email khong dung dinh dang", "Loi nhap email", JOptionPane.WARNING_MESSAGE);
//                // txtEmail.setBackground(Color.yellow);
//                // txtEmail.requestFocus();
//                return;
//            }
//            if (list.size() == 0) {
//                ndd = true;
//            }
//            System.out.println("," + name + "," + sdt+","+email+","+Ma_PHG);
            ChucNang.InsertKH(name, sdt, email);
            ops.writeInt(1);
            JOptionPane.showMessageDialog(this, "thanhcong");
            FilltoTable();
        } catch (SQLException ex) {
            Logger.getLogger(ShowKH.class
                    .getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ShowKH.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnThemActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed

        try {
            index = tblCus.getSelectedRow();
            ChucNang.deleteKH(list.get(index).getMa_KH());
//            list.remove(index);
            ops.writeInt(1);

            FilltoTable();
            JOptionPane.showMessageDialog(this, "Xóa thành công");
        } catch (SQLException ex) {
            Logger.getLogger(ShowKH.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ShowKH.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnXoaActionPerformed
    private int makh;
    private void btnCapnhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapnhatActionPerformed
        try {
            index = tblCus.getSelectedRow();
            String name = (String) model.getValueAt(index, 0);
            String sdt = (String) model.getValueAt(index, 1);
            String email = (String) model.getValueAt(index, 2);
            ChucNang.UpdateKH(name, sdt, email, list.get(index).getMa_KH());
            FilltoTable();
            JOptionPane.showMessageDialog(this, "Cập nhật thành công");
        } catch (SQLException ex) {
            Logger.getLogger(ShowKH.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnCapnhatActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ShowKH.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ShowKH.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ShowKH.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ShowKH.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ShowKH().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCapnhat;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblCus;
    // End of variables declaration//GEN-END:variables
}
