import javax.swing.JOptionPane;

public class Ex64 {
    public static void main(String[] args) {
        boolean validInput = false;
        int year = 0;
        String monthInput = "";
        while (!validInput) {
            try {
                String yearInput = JOptionPane.showInputDialog("Nhập năm (ví dụ: 2024):");
                year = Integer.parseInt(yearInput); 
                if (year < 0) {
                    throw new NumberFormatException("Năm không được âm.");
                }
                monthInput = JOptionPane.showInputDialog("Nhập tháng (có thể là tên tháng, viết tắt hoặc số):");
                int days = getDaysInMonth(monthInput, year);
                JOptionPane.showMessageDialog(null, "Số ngày trong tháng " + monthInput + " của năm " + year + " là: " + days);
                validInput = true; 
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Nhập không hợp lệ. Vui lòng thử lại.");
            }
        }
    }

    public static int getDaysInMonth(String monthInput, int year) throws Exception {
        int days = 0;
        monthInput = monthInput.trim().toLowerCase(); 

        switch (monthInput) {
            case "1":
            case "january":
            case "jan.":
            case "jan":
                days = 31;
                break;
            case "2":
            case "february":
            case "feb.":
            case "feb":
                days = isLeapYear(year) ? 29 : 28;
                break;
            case "3":
            case "march":
            case "mar.":
            case "mar":
                days = 31;
                break;
            case "4":
            case "april":
            case "apr.":
            case "apr":
                days = 30;
                break;
            case "5":
            case "may":
                days = 31;
                break;
            case "6":
            case "june":
            case "jun.":
            case "jun":
                days = 30;
                break;
            case "7":
            case "july":
            case "jul.":
            case "jul":
                days = 31;
                break;
            case "8":
            case "august":
            case "aug.":
            case "aug":
                days = 31;
                break;
            case "9":
            case "september":
            case "sep.":
            case "sep":
                days = 30;
                break;
            case "10":
            case "october":
            case "oct.":
            case "oct":
                days = 31;
                break;
            case "11":
            case "november":
            case "nov.":
            case "nov":
                days = 30;
                break;
            case "12":
            case "december":
            case "dec.":
            case "dec":
                days = 31;
                break;
            default:
                throw new Exception("Tháng không hợp lệ.");
        }

        return days;
    }

    public static boolean isLeapYear(int year) {
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                return year % 400 == 0;
            } else {
                return true;
            }
        }
        return false;
    }
}

