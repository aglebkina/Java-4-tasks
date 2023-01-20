import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class task4 {
    public static void main(String[] args) throws IOException {
    	
    	 Scanner in = new Scanner(System.in);  // запрашиваем файл с массивом
         System.out.print("File path: ");
         String file = in.nextLine();
         in.close();
         
        // Чтение файла с цифрами и преобразование его в массив
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
        int[] nums = new int[0];
        while ((line = reader.readLine()) != null) {
            int num = Integer.parseInt(line);
            nums = Arrays.copyOf(nums, nums.length + 1);
            nums[nums.length - 1] = num;
        }
        reader.close();

        // определение числа к которому будет приведен весь массив
        int target = 0;
        for (int num : nums) {
            target = target + num;
        }
        target = target / nums.length;

        // рассчитываем минимальное число шагов для приведения массива к targt
        int steps = 0;
        for (int num : nums) {
            steps = steps + Math.abs(num - target);
        }
        System.out.println("Min steps: " + steps);
    }
}