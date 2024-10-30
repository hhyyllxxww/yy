package circle;
import java.util.Scanner;
public class Circle {
	
	public static void main(String[] args) {
		Scanner sca = new Scanner(System.in);
		
		System.out.print("Choose your option: 1=perimeter, 2=area? ");
        int option = sca.nextInt();
    	System.out.print("Enter radius: ");
        float radius = sca.nextInt();
        sca.close();
        
        double area = area(radius);
        double perimeter = perimeter(radius);
        
       
        switch (option) {
            case 1:
                System.out.println("Perimeter = " + perimeter);
                break;
            case 2:
     
                System.out.println("Area = " + area);
                break;
            default:
                System.out.println("Option no valid!");
        }
        
	}

	private static double perimeter(float radius) {
		double pi = 3.14159; 
        return 2 * pi * radius;
	}
	
	private static double area(double radius) {
		double pi = 3.14159;
        return pi * Math.pow(radius, 2); }
}
