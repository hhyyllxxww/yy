package evenNumbers;
import java.util.Scanner;
public class EvenNumbers {

	public static void main(String[] args) {
		Scanner sca = new Scanner(System.in);
		System.out.print("Enter a number: ");
        float num = sca.nextInt();
        sca.close();
        
		boolean even = isEven( num);
        boolean zero = endsWithZero( num);
        
        if (even) {
            System.out.println(num + " is even and end with Zero");
        }else if (zero) {
        	System.out.println(num + " is even and does not end with Zero");
        } else {
            System.out.println(num + " is odd"); 
        }
	 }
	
	private static boolean endsWithZero(float num) {
		return num % 10 == 0;
	}

	private static boolean isEven(float num) {
	    return num % 2 == 0;	}
}
