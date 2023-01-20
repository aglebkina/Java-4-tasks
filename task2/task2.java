import java.io.*;
import java.util.Scanner;

public class task2 {

    public static String pointPosition(double[] center, double radius, double[] point) {
        double distance = Math.sqrt(Math.pow(point[0] - center[0], 2) + Math.pow(point[1] - center[1], 2));
        if (distance < radius) {
            return "1";
        } else if (distance == radius) {
            return "0";
        } else {
            return "2";		// разработка условий для определения расположения точки относительно окружности
            						// где 0 - лежит на окружности, 1 - внутри, 2 - снаружи окружности
        }
    }

    public static void main(String[] args) throws IOException {
    	
    	
        Scanner in = new Scanner(System.in); 
        System.out.print("File 1 path: "); 	// ввод пути к файлу 1 с данными окружности
        String file1 = in.nextLine();
        System.out.print("File 2 path: ");   // ввод пути к файлу 2 с данными точек
        String file2 = in.nextLine();
        in.close();
    	
    	
        // чтение координат центра и радиуса окружности из файла 1
        BufferedReader reader = new BufferedReader(new FileReader(file1));
        String[] centerLine = reader.readLine().split(" ");
        double[] center = {Double.parseDouble(centerLine[0]), Double.parseDouble(centerLine[1])};
        double radius = Double.parseDouble(reader.readLine());
        reader.close();

        // чтение координат точек из файла 2
        reader = new BufferedReader(new FileReader(file2));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] pointLine = line.split(" ");
            double[] point = {Double.parseDouble(pointLine[0]), Double.parseDouble(pointLine[1])};
            String position = pointPosition(center, radius, point);
            
            // вывод итогового результата (лежит точка на окружности или нет)
            System.out.println("Position of point: " + position);
        }
        reader.close();
    }
}