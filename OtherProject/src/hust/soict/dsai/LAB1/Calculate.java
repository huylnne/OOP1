//2.2.5
import javax.swing.JOptionPane;

public class Calculate {
    public static void main(String[] args) {
       
        String strNum1 = JOptionPane.showInputDialog(null, "Please enter the first number:", "Input", JOptionPane.INFORMATION_MESSAGE);
        String strNum2 = JOptionPane.showInputDialog(null, "Please enter the second number:", "Input", JOptionPane.INFORMATION_MESSAGE);

    
        double num1 = Double.parseDouble(strNum1);
        double num2 = Double.parseDouble(strNum2);

        
        double sum = num1 + num2;
        double difference = num1 - num2;
        double product = num1 * num2;
        double quotient = 0;

        if (num2 != 0) {
            quotient = num1 / num2;
        } else {
            JOptionPane.showMessageDialog(null, "Cannot divide by zero", "Error", JOptionPane.ERROR_MESSAGE);
        }

        String result = "Sum: " + sum + "\n" +
                        "Difference: " + difference + "\n" +
                        "Product: " + product + "\n" +
                        (num2 != 0 ? "Quotient: " + quotient : "");

        JOptionPane.showMessageDialog(null, result, "Results", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
}

