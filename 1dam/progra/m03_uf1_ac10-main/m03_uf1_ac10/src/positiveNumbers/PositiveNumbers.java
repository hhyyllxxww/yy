package positiveNumbers;
import java.util.Scanner;
public class PositiveNumbers {
	public static void main(String[] args) {
		Scanner sca = new Scanner(System.in);
		
		System.out.print("Enter a number: ");
        float num = sca.nextInt();
        sca.close();
        
        boolean positive = isPositive (num);   
        boolean bigger = isBiggerOrEqualThan100 (num);
        boolean zero = isZero (num);

        if (positive) {
            System.out.println("Is positive but less than 100");
        } else if (bigger) {
        	System.out.println("Is positive and bigger or equal than 100");
        } else if (zero) {
            System.out.println("Is zero"); 
        } else {
            System.out.println("Is negative"); 
   }
 }
        
	private static boolean isZero(float num) {
		 return num == 0;	}

	private static boolean isBiggerOrEqualThan100(float num) {
		 return num > 100;  
	}

	private static boolean isPositive(float num) {
	    return num > 0 && num < 100;
		
	}
}
