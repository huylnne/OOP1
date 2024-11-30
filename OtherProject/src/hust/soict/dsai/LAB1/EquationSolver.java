import javax.swing.JOptionPane;

public class EquationSolver {

    // Giai he pt bac nhat 1 an:
    public static void solveLinearEquation(double a, double b) {
        if (a == 0) {
            if (b == 0) {
                JOptionPane.showMessageDialog(null, "PT co vo so nghiem");
            } else {
                JOptionPane.showMessageDialog(null, "PT vo nghiem");
            }
        } else {
            double x = -b / a;
            JOptionPane.showMessageDialog(null, "Nghiem cua pt la: x = " + x);
        }
    }

    // Giai he pt bac 1 ,2 an
    public static void solveLinearSystem(double a11, double a12, double b1, double a21, double a22, double b2) {
        double D = a11 * a22 - a21 * a12;
        double D1 = b1 * a22 - b2 * a12;
        double D2 = a11 * b2 - a21 * b1;

        if (D == 0) {
            if (D1 == 0 && D2 == 0) {
                JOptionPane.showMessageDialog(null, "He PT co vo so nghiem");
            } else {
                JOptionPane.showMessageDialog(null, "He PT vo nghiem");
            }
        } else {
            double x1 = D1 / D;
            double x2 = D2 / D;
            JOptionPane.showMessageDialog(null, "Nghiem cua he phuong trinh la : x1 = " + x1 + ", x2 = " + x2);
        }
    }

    // Giai pt bac 2
    public static void solveQuadraticEquation(double a, double b, double c) {
        if (a == 0) {
            // Nếu a = 0, PT ->pt bac 1
            solveLinearEquation(b, c);
        } else {
            double delta = b * b - 4 * a * c;

            if (delta < 0) {
                JOptionPane.showMessageDialog(null, "PT vo nghiem");
            } else if (delta == 0) {
                double x = -b / (2 * a);
                JOptionPane.showMessageDialog(null, "PT co nghiem kep: x = " + x);
            } else {
                double x1 = (-b + Math.sqrt(delta)) / (2 * a);
                double x2 = (-b - Math.sqrt(delta)) / (2 * a);
                JOptionPane.showMessageDialog(null, "PT co 2 nghiem phan biet: x1 = " + x1 + ", x2 = " + x2);
            }
        }
    }

    public static void main(String[] args) {
        // Giai pt bac 1 1 an
        JOptionPane.showMessageDialog(null, "Giai pt bac nhat 1 an ax + b = 0");
        double a = Double.parseDouble(JOptionPane.showInputDialog("Nhap a:"));
        double b = Double.parseDouble(JOptionPane.showInputDialog("Nhap b:"));
        solveLinearEquation(a, b);

        // giai he pt bac 1 2 an
        JOptionPane.showMessageDialog(null, "Giai he phuong trinh bac nhat 2 an");
        double a11 = Double.parseDouble(JOptionPane.showInputDialog("Nhap a11 (Phuong trinh 1):"));
        double a12 = Double.parseDouble(JOptionPane.showInputDialog("Nhap a12 (Phuong trinh 1):"));
        double b1 = Double.parseDouble(JOptionPane.showInputDialog("Nhap b1 (Phuong trinh 1):"));
        double a21 = Double.parseDouble(JOptionPane.showInputDialog("Nhap a21 (Phuong trinh 2):"));
        double a22 = Double.parseDouble(JOptionPane.showInputDialog("Nhap a22 (Phuong trinh 2):"));
        double b2 = Double.parseDouble(JOptionPane.showInputDialog("Nhap b2 (Phuong trinh 2):"));
        solveLinearSystem(a11, a12, b1, a21, a22, b2);

        //Giai pt bac 2
        JOptionPane.showMessageDialog(null, "Giai pt bac 2 ax^2 + bx + c = 0");
        a = Double.parseDouble(JOptionPane.showInputDialog("Nhap a:"));
        b = Double.parseDouble(JOptionPane.showInputDialog("Nhap b:"));
        double c = Double.parseDouble(JOptionPane.showInputDialog("Nhap c:"));
        solveQuadraticEquation(a, b, c);
    }
}


