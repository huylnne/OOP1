package hust.soict.dsai.swing; // Đảm bảo khai báo package đúng theo thư mục

import javax.swing.*; // Thư viện Swing
import java.awt.*; // Thư viện AWT
import java.awt.event.*; // Thư viện xử lý sự kiện

public class SwingAccumulator extends JFrame {
    private JTextField tfInput; // Ô nhập số nguyên
    private JTextField tfOutput; // Ô hiển thị tổng
    private int sum = 0; // Tổng tích lũy, khởi tạo bằng 0

    // Constructor để thiết lập giao diện GUI và xử lý sự kiện
    public SwingAccumulator() {
        // Lấy Content Pane và thiết lập bố cục
        Container cp = getContentPane();
        cp.setLayout(new GridLayout(2, 2, 5, 5)); // Bố cục dạng lưới 2x2

        // Nhãn và TextField cho ô nhập số
        cp.add(new JLabel("Enter an Integer: "));
        tfInput = new JTextField(10); // Ô nhập
        cp.add(tfInput);
        tfInput.addActionListener(new TFInputListener()); // Gắn ActionListener

        // Nhãn và TextField cho tổng tích lũy
        cp.add(new JLabel("The Accumulated Sum is: "));
        tfOutput = new JTextField(10); // Ô hiển thị kết quả
        tfOutput.setEditable(false); // Không cho chỉnh sửa
        cp.add(tfOutput);

        // Thiết lập JFrame
        setTitle("Swing Accumulator"); // Tiêu đề cửa sổ
        setSize(350, 120); // Kích thước cửa sổ
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Thoát chương trình khi đóng cửa sổ
        setVisible(true); // Hiển thị cửa sổ
    }

    // Điểm bắt đầu của chương trình
    public static void main(String[] args) {
        new SwingAccumulator();
    }

    // Lớp xử lý sự kiện khi nhấn Enter trong ô nhập
    private class TFInputListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evt) {
            try {
                // Lấy giá trị nhập vào, chuyển thành số nguyên và cộng vào tổng
                int numberIn = Integer.parseInt(tfInput.getText());
                sum += numberIn;

                // Cập nhật kết quả và xóa nội dung ô nhập
                tfInput.setText(""); // Xóa ô nhập
                tfOutput.setText(String.valueOf(sum)); // Hiển thị tổng
            } catch (NumberFormatException e) {
                // Hiển thị thông báo lỗi nếu nhập sai định dạng
                tfInput.setText("");
                tfOutput.setText("Invalid Input");
            }
        }
    }
}
