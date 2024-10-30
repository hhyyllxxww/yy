package guessNumber;

import java.util.Scanner;
import java.util.Locale;

public class GuessNumber {
	
    public static Scanner sc = new Scanner(System.in).useLocale(Locale.UK);
    public static void main(String[] args) {
        byte maxnum;
        byte randnum;
        byte attempts;
        byte i = 0;
        byte num;
        
        maxnum = maxnum();
        randnum = randomNumber(maxnum);
        
        attempts = dataEntryByteMinMax("Enter the number of attempts (2 .. 10): ", (byte)2, (byte)10);

        
        while (i < attempts) {
        	++ i;
        	
        	System.out.print("ATTEMPT "+i+". Enter 1 to "+maxnum+":");
        	num = sc.nextByte();
        	
        	if (guessNumber(num, randnum) == 1) {
        		System.out.print("Too high! ");
        	}else if (guessNumber(num, randnum) == -1) {
        		System.out.print("Too low! ");
        	}else {
        		System.out.print("YOU HAVE WON!!! THE END.");
        		i = attempts;
        	}
        	
        	System.out.println((guessNumber(num, randnum) == -1 || guessNumber(num, randnum) == 1) && i == attempts ? "You have lost!\nBye!": "");
        	
        }



        sc.close();
    }
    
    public static byte randomNumber(byte max) {
    	return (byte) (Math.random() * max + 1);
    }
    
    public static byte guessNumber(byte num, byte randomNum) {
    	
    	return (byte) (num > randomNum ? 1 : (num < randomNum ? -1 : 0)) ;
    }
    
    public static byte maxnum() {
          return dataEntryByteMinMax("Enter the maximum number (10..100): ", (byte)10, (byte)100);
    } 
    
    public static byte dataEntryByteMinMax(String text, byte min, byte max) {
        byte number = 0;
        System.out.print(text);
        boolean isValid = false;
        while (!isValid) {
            if (sc.hasNextByte()) {
                number = sc.nextByte();
                if (number >= min && number <= max) {
                    isValid = true;

                } else {
                    System.out.print("Error! " + text);
                }
            } else {
                sc.next();  //Consume sc 
                System.out.print("Error! " + text);
            }
        }
        return number;
    }
}

