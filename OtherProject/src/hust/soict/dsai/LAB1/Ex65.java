import java.util.Arrays;

public class Ex65 {

    public static void main(String[] args) {
        int[] numbers = {5, 3, 8, 1, 9, 2, 7, 4, 6}; 
        Arrays.sort(numbers);
        
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        
        double average = (double) sum / numbers.length;
        
        System.out.println("Mang sau khi sap xep: " + Arrays.toString(numbers));
        System.out.println("Tong cac phan tu: " + sum);
        System.out.println("Gia tri trung binh: " + average);
    }
}

