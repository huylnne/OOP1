package hust.soict.dsai.swing;

import java.awt.*;
import java.awt.event.*;

public class AWTAccumulator extends Frame {
    private TextField tfInput; // TextField để nhập số nguyên
    private TextField tfOutput; // TextField để hiển thị tổng tích lũy
    private int sum = 0; // Tổng tích lũy, khởi tạo bằng 0

    // Constructor để thiết lập GUI và xử lý sự kiện
    public AWTAccumulator() {
        setLayout(new GridLayout(2, 2)); // Layout dạng lưới 2 hàng, 2 cột

        // Dòng đầu tiên: Nhãn và TextField nhập
        add(new Label("Enter an Integer: "));
        tfInput = new TextField(10); // TextField nhập liệu
        add(tfInput);

        // Gắn ActionListener cho tfInput
        tfInput.addActionListener(new TFInputListener());

        // Dòng thứ hai: Nhãn và TextField hiển thị tổng
        add(new Label("The Accumulated Sum is: "));
        tfOutput = new TextField(10); // TextField hiển thị tổng
        tfOutput.setEditable(false); // Không cho chỉnh sửa TextField này
        add(tfOutput);

        // Thiết lập tiêu đề, kích thước và hiển thị cửa sổ
        setTitle("AWT Accumulator");
        setSize(350, 120); // Kích thước cửa sổ
        setVisible(true); // Hiển thị cửa sổ
    }

    // Điểm bắt đầu của chương trình
    public static void main(String[] args) {
        new AWTAccumulator(); // Tạo và hiển thị cửa sổ
    }

    // Lớp lồng để xử lý sự kiện nhập liệu
    private class TFInputListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evt) {
            try {
                // Lấy giá trị từ tfInput, chuyển thành số nguyên và cộng vào tổng
                int numberIn = Integer.parseInt(tfInput.getText());
                sum += numberIn;

                // Xóa nội dung tfInput và cập nhật tfOutput
                tfInput.setText(""); // Xóa ô nhập
                tfOutput.setText(String.valueOf(sum)); // Cập nhật tổng
            } catch (NumberFormatException e) {
                // Hiển thị thông báo lỗi nếu nhập không phải số
                tfInput.setText(""); // Xóa ô nhập
                tfOutput.setText("Invalid Input"); // Thông báo lỗi
            }
        }
    }
}
