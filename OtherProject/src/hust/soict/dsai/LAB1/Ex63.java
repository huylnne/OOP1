import javax.swing.JOptionPane;

public class Ex63 {
    public static void main(String[] args) {
        String input = JOptionPane.showInputDialog("Nhập chiều cao của tam giác (n):");
        int n = Integer.parseInt(input);
        drawTriangle(n);
    }
    public static void drawTriangle(int n) {
        StringBuilder triangle = new StringBuilder();  
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) {
                triangle.append(" ");
            }
            for (int j = 1; j <= (2 * i - 1); j++) {
                triangle.append("*");
            }
            triangle.append("\n");
        }
        JOptionPane.showMessageDialog(null, triangle.toString());
    }
}

