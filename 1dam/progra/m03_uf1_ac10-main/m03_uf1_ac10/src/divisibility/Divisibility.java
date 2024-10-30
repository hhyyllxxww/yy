package divisibility;
import java.util.Scanner;
public class Divisibility {
	public static void main(String[] args) {
		Scanner sca = new Scanner(System.in);
		
		 System.out.print("Enter the first number: ");
	        int num1 = sca.nextInt();

	     System.out.print("Enter the second number:  ");
	        int num2 = sca.nextInt();
	        sca.close();
	        
	        boolean divisible = areDivisible(num1, num2);    

	if (divisible) {
        System.out.println(num1 + " is divisible by " + num2);
    } else {
        System.out.println(num1 + " is not divisible by " + num2);
    }
}

         public static boolean areDivisible(int num1, int num2) {
             return num1 % num2 == 0;
}
         
}
