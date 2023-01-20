
import java.util.Arrays;
import java.util.Scanner;

public class task1 {
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    System.out.print("Enter n: "); //вводим значение массива n 
	    int n = sc.nextInt();
	    System.out.print("Enter m: "); // вводим значение интервала m
	    int m = sc.nextInt();	    
	        
	    int[] arr = new int[n];  // задаём массив [n]
	    Arrays.setAll(arr, i -> ++i);    

	    int current = 0;
	    System.out.print("Path: "); // выводим путь
	    
	    do {
	        System.out.print(arr[current]);            
	        current = (current + m - 1) % n;
	    } while (current != 0);					// описание условия для определения пути 
	}
}
