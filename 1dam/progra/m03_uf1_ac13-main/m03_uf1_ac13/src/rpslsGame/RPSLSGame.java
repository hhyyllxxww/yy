package rpslsGame;

import java.util.Scanner;

public class RPSLSGame {

	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
			
		RPSLSGame nuevo = new RPSLSGame();
		
		System.out.println("**********************************************************************");
		System.out.println("* ROCK PAPER SCISSORS LIZARD SPOCK          © Cruselles Gina         *");
		System.out.println("*                                                                    *");
		System.out.println("* An extension of the children's game of rock paper scissors,        *");
		System.out.println("* with two additional handshapes: lizard and Spock.                  *");
		System.out.println("* Rules: Scissors cuts paper                                         *");
		System.out.println("*        Paper covers rock                                           *");
		System.out.println("*        Rock crushes lizard                                         *");
		System.out.println("*        Lizard poisons Spock                                        *");
		System.out.println("*        Spock smashes scissors                                      *");
		System.out.println("*        Scissors decapitates lizard                                 *");
		System.out.println("*        Lizard eats paper                                           *");
		System.out.println("*        Paper disproves Spock                                       *");
		System.out.println("*        Spock vaporizes rock                                        *");
		System.out.println("*        and as it always has, rock crushes scissors.                *");
		System.out.println("********************************************************************** ");

		int PointP1 = 0;
		int PointP2 = 0;
		boolean end = false;
		
		while(!end) {
			
			System.out.println("\n1:ROCK      2:PAPER     3:SCISSORS  4:LIZARD    5:SPOCK     ");
			byte val1 = dataEntryByteMinMax("\nCHOOSE YOUR OPTION: ",(byte)1,(byte)5);
			
			System.out.println("\nPlayer 1: " + nuevo.getText(val1));
			
			byte val2 = g.getRPS();
			System.out.println("Player 2 : " + nuevo.getText(val2));
			
			System.out.println("The winner is: " + nuevo.winner(val1, val2));
			
			if(g.winner(val1, val2).equals("Player1")) {
				PointP1 += 1 ;
			}else if(g.winner(val1, val2).equals("Player2")) {
				PointP2 += 1;
			}else {
				
			}
			
			System.out.println("\nPoints player 1: " + PointP1);
			System.out.println("Points player 2: " + PointP2);
			
			if(dataEntryByteMinMax("\nDo you want to play again 1:YES 2:NO? ",(byte)1,(byte)2) == 1) {
				end = false;
				System.out.println("**********************************************************");
			}else {
				end = true;
				System.out.println("Bye!");
			}
			
		}

		
		
		sc.close();
	}
	
	public byte getRPS() {
		
		return (byte)(Math.random() * 5 + 1);
	}
	
	public String getText(byte val) {
		
		switch(val) {
		case 1:
			return "ROCK";
		
		case 2:
			return "PAPER";
			
		case 3:
			return "SCISSORS";
			
		case 4:
			return "LIZARD";
			
		case 5:
			return "SPOCK";
		
		default:
			return "ERROR";
		}
		
		
	}
	
	public String winner(byte player1, byte player2) {
		
		if (player1 == 1 && (player2 == 3 || player2 == 4)) {
			return "Player1";
			
		}else if (player1 == 2 && (player2 == 1 || player2 == 5)) {
			return "Player1";
			
		}else if (player1 == 3 && (player2 == 2 || player2 == 4)) {
			return "Player1";
			
		}else if (player1 == 4 && (player2 == 2 || player2 == 5)) {
			return "Player1";
			
		}else if (player1 == 5 && (player2 == 1 || player2 == 3)) {
			return "Player1";
			
		}else if (player1 == player2) {
			return "Draw";
			
		}else {
			return "Player2";
		}
		
	
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
                sc.next(); 
                System.out.print("Error! " + text);
            }
        }
        return number;
    }
	
}


