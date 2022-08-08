/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

/**
 *
 * @author Daokh
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;

public class TestTable extends JFrame {

    private DefaultTableModel dtm;
    private ButtonGroup bg;
    private JTable table;
    private JScrollPane jsp;

    public TestTable() {
        setTitle("JTableRadioButton Test");
        dtm = new DefaultTableModel();
        dtm.setDataVector(new Object[][]{{"Course 1", new JRadioButton("Java")}, {"Course 1", new JRadioButton("Python")}, {"Course 1", new JRadioButton("Scala")}, {"Course 2", new JRadioButton("Selenium")}, {"Course 2", new JRadioButton("Java Script")}}, new Object[]{"Course", "Technology"});
        table = new JTable(dtm) {
            public void tableChanged(TableModelEvent tme) {
                super.tableChanged(tme);
                repaint();
            }
        };
        bg = new ButtonGroup();
        int length = dtm.getRowCount();
        JRadioButton[] rdo = new JRadioButton[length];
//        JRadioButton name = (JRadioButton) dtm.getValueAt(1, 1);
        for (int i = 0; i < dtm.getRowCount(); i++) {
            rdo[i] = (JRadioButton) dtm.getValueAt(i, 1);
//            bg.add(rdo[i]);
//            rdo[i].addActionListener(new ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent e) {
//                    System.out.println(table.getSelectedRow());
//                }
//            });
        }

//        rdo[1].setSelected(true);

        table.getColumn("Technology").setCellRenderer(new RadioButtonRenderer());
        table.getColumn("Technology").setCellEditor(new RadioButtonEditor(new JCheckBox()));
        jsp = new JScrollPane(table);
        add(jsp, BorderLayout.NORTH);
        setSize(400, 275);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

    }

    class RadioButtonRenderer implements TableCellRenderer {

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            if (value == null) {
                return null;
            }
            return (Component) value;
        }
    }
    ButtonGroup bug = new ButtonGroup();
    class RadioButtonEditor extends DefaultCellEditor implements ItemListener {

        private JRadioButton button;

        public RadioButtonEditor(JCheckBox checkBox) {
            super(checkBox);
        }

        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            if (value == null) {
                return null;
            }
            button = (JRadioButton) value;
            bug.add(button);
            button.addItemListener(this);
            return (Component) value;
        }

        public Object getCellEditorValue() {
            button.removeItemListener(this);
            return button;
        }

        public void itemStateChanged(ItemEvent e) {
            super.fireEditingStopped();
        }
    }

    public static void main(String[] args) {
        new TestTable();
    }
}
