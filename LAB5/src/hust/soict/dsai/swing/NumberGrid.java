package hust.soict.dsai.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NumberGrid extends JFrame {
    private JTextField tfDisplay; // Ô hiển thị số
    private JButton[] btnNumbers; // Các nút số từ 0-9
    private JButton btnDelete, btnClear; // Các nút DEL và C

    public NumberGrid() {
        // Thiết lập bố cục
        tfDisplay = new JTextField();
        tfDisplay.setEditable(false); // Chỉ đọc
        tfDisplay.setHorizontalAlignment(JTextField.RIGHT); // Canh phải

        JPanel panelButtons = new JPanel();
        panelButtons.setLayout(new GridLayout(4, 3)); // Lưới 4x3

        // Tạo các nút số
        btnNumbers = new JButton[10];
        for (int i = 1; i <= 9; i++) {
            btnNumbers[i] = new JButton(String.valueOf(i));
            panelButtons.add(btnNumbers[i]);
            btnNumbers[i].addActionListener(new ButtonListener());
        }

        // Thêm nút "0", "DEL" và "C"
        btnDelete = new JButton("DEL");
        btnClear = new JButton("C");
        btnNumbers[0] = new JButton("0");

        panelButtons.add(btnNumbers[0]);
        panelButtons.add(btnDelete);
        panelButtons.add(btnClear);

        btnNumbers[0].addActionListener(new ButtonListener());
        btnDelete.addActionListener(new ButtonListener());
        btnClear.addActionListener(new ButtonListener());

        // Thêm các thành phần vào JFrame
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(tfDisplay, BorderLayout.NORTH);
        cp.add(panelButtons, BorderLayout.CENTER);

        // Thiết lập JFrame
        setTitle("Number Grid");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            if (command.equals("DEL")) {
                // Xóa ký tự cuối cùng
                String text = tfDisplay.getText();
                if (text.length() > 0) {
                    tfDisplay.setText(text.substring(0, text.length() - 1));
                }
            } else if (command.equals("C")) {
                // Xóa toàn bộ
                tfDisplay.setText("");
            } else {
                // Thêm chữ số
                tfDisplay.setText(tfDisplay.getText() + command);
            }
        }
    }

    public static void main(String[] args) {
        new NumberGrid();
    }
}
