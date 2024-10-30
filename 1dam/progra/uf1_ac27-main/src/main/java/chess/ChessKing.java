package chess;
import java.util.Scanner;
import java.util.Arrays;

public class ChessKing {

	public static Scanner sc = new Scanner(System.in);
	public static final byte SIZE = 8;

	public static void main(String[] args) {
		ChessKing ck = new ChessKing();

		String[][] board = new String[SIZE][SIZE];

		for (byte i = 0; i < board.length; i++) {
			for (byte j = 0; j < board[i].length; j++) {
				board[i][j] = "--";
			}
		}
		byte[] KB = ck.placePiece(board, "KB");

		System.out.println(ck.showBoard(board));

		byte option = ck.menu();
		if (option == 0)
			System.out.println("Byee!");

		while (option != 0) {

			switch (option) {
			case 1:
				System.out.println(ck.showBoard(ck.showMovementsKing(board, KB)));
				
				break;
			case 2:
				byte[][] res = ck.possibleMovesKing(board, KB);
				for (int i = 0; i < res.length; i++) {
					System.out.println(i+": "+Arrays.toString(res[i]));
				}
				byte num = ck.dataEntryByteMinMax("Choose position to move: ", (byte)0, (byte)res.length);
				byte[] choice = res[num];
				ck.moveKing(board, KB, choice);
				System.out.println(ck.showBoard(board));
				break;
				
			}

			option = ck.menu();
			if (option == 0)
				System.out.println("Bye!");
		}

		sc.close();
	}

	public void moveKing(String[][] board, byte[] pos, byte[] choice) {
		String hold = "--";
		board[choice[0]][choice[1]] = board[pos[0]][pos[1]];
		board[pos[0]][pos[1]] = hold;
		pos[0] = choice[0];
		pos[1] = choice[1];
	}
	
	public byte[][] possibleMovesKing(String[][] board, byte[] pos){
		byte count = 0;
		
		if ((pos[0]-1 >= 0 && pos[0]-1 <=7)) {
			count++;
		}
		if ((pos[0]-1 >= 0 && pos[0]-1 <=7)&&(pos[1]-1 >= 0 && pos[1]-1 <=7)) {
			count++;
		}
		if ((pos[1]-1 >= 0 && pos[1]-1 <=7)) {
			count++;
		}
		if ((pos[0]+1 >= 0 && pos[0]+1 <=7)&&(pos[1]-1 >= 0 && pos[1]-1 <=7)) {
			count++;
		}
		if ((pos[0]+1 >= 0 && pos[0]+1 <=7)) {
			count++;
		}
		if ((pos[0]+1 >= 0 && pos[0]+1 <=7)&&(pos[1]+1 >= 0 && pos[1]+1 <=7)) {
			count++;
		}
		if ((pos[1]+1 >= 0 && pos[1]+1 <=7)) {
			count++;
		}
		if ((pos[0]-1 >= 0 && pos[0]-1 <=7)&&(pos[1]+1 >= 0 && pos[1]+1 <=7)) {
			count++;
		}
		
		byte[][] res = new byte[count][2];
		count = 0;
		
		if ((pos[0]-1 >= 0 && pos[0]-1 <=7)) {
			res[count][0] = (byte) (pos[0]-1);
			res[count][1] = (byte) (pos[1]);
			count++;
		}
		if ((pos[0]-1 >= 0 && pos[0]-1 <=7)&&(pos[1]-1 >= 0 && pos[1]-1 <=7)) {
			res[count][0] = (byte) (pos[0]-1);
			res[count][1] = (byte) (pos[1]-1);
			count++;
		}
		if ((pos[1]-1 >= 0 && pos[1]-1 <=7)) {
			res[count][0] = (byte) (pos[0]);
			res[count][1] = (byte) (pos[1]-1);
			count++;
		}
		if ((pos[0]+1 >= 0 && pos[0]+1 <=7)&&(pos[1]-1 >= 0 && pos[1]-1 <=7)) {
			res[count][0] = (byte) (pos[0]+1);
			res[count][1] = (byte) (pos[1]-1);
			count++;
		}
		if ((pos[0]+1 >= 0 && pos[0]+1 <=7)) {
			res[count][0] = (byte) (pos[0]+1);
			res[count][1] = (byte) (pos[1]);
			count++;
		}
		if ((pos[0]+1 >= 0 && pos[0]+1 <=7)&&(pos[1]+1 >= 0 && pos[1]+1 <=7)) {
			res[count][0] = (byte) (pos[0]+1);
			res[count][1] = (byte) (pos[1]+1);
			count++;
		}
		if ((pos[1]+1 >= 0 && pos[1]+1 <=7)) {
			res[count][0] = (byte) (pos[0]);
			res[count][1] = (byte) (pos[1]+1);
			count++;
		}
		if ((pos[0]-1 >= 0 && pos[0]-1 <=7)&&(pos[1]+1 >= 0 && pos[1]+1 <=7)) {
			res[count][0] = (byte) (pos[0]-1);
			res[count][1] = (byte) (pos[1]+1);
			count++;
		}
		
		return res;
	}
	
	public String[][] showMovementsKing(String[][] board, byte[] pos){
		String[][] res = new String[SIZE][SIZE];
		for (byte i = 0; i < board.length; i++) {
			for (byte j = 0; j < board[i].length; j++) {
				res[i][j] = board[i][j];
			}
		}
		int count = 0;
		String text ="";
		if ((pos[0]-1 >= 0 && pos[0]-1 <=7)) {
			text += count;
			res[pos[0]-1][pos[1]] = text + " ";
			count++;
		}
		if ((pos[0]-1 >= 0 && pos[0]-1 <=7)&&(pos[1]-1 >= 0 && pos[1]-1 <=7)) {
			text ="";
			text += count;
			res[pos[0]-1][pos[1]-1] = text + " ";
			count++;
		}
		if ((pos[1]-1 >= 0 && pos[1]-1 <=7)) {
			text ="";
			text += count;
			res[pos[0]][pos[1]-1] = text + " ";
			count++;
		}
		if ((pos[0]+1 >= 0 && pos[0]+1 <=7)&&(pos[1]-1 >= 0 && pos[1]-1 <=7)) {
			text ="";
			text += count;
			res[pos[0]+1][pos[1]-1] = text + " ";
			count++; 
		}
		if ((pos[0]+1 >= 0 && pos[0]+1 <=7)) {
			text ="";
			text += count;
			res[pos[0]+1][pos[1]] = text + " ";
			count++;
		}
		if ((pos[0]+1 >= 0 && pos[0]+1 <=7)&&(pos[1]+1 >= 0 && pos[1]+1 <=7)) {
			text ="";
			text += count;
			res[pos[0]+1][pos[1]+1] = text + " ";
			count++;
		}
		if ((pos[1]+1 >= 0 && pos[1]+1 <=7)) {
			text ="";
			text += count;
			res[pos[0]][pos[1]+1] = text + " ";
			count++;
		}
		if ((pos[0]-1 >= 0 && pos[0]-1 <=7)&&(pos[1]+1 >= 0 && pos[1]+1 <=7)) {
			text ="";
			text += count;
			res[pos[0]-1][pos[1]+1] = text + " ";
			count++;
		}
		
		return res;
	}
	
	public String showBoard(String[][] board) {
		String res = "";
		
		for (int i = 0; i < board[0].length; i++) {
			res += "   ";
			res += i;
		}
		res += "\n";
		for (int i = 0; i < board.length; i++) {
			res += i;
			res += ": ";
			for (int j = 0; j < board.length; j++) {
				res += board[i][j];
				res += "  ";
			}
			res += "\n";
		}
		
		return res;
	}
	
	public byte[] placePiece(String[][] board, String piece) {
		byte rand1 = (byte) (Math.random() * (7 + 1));
		byte rand2 = (byte) (Math.random() * (7 + 1));
		
		byte[] res = {rand1, rand2};
		board[rand1][rand2] = piece;
		
		return res;
	}
	
	public byte menu() {
        System.out.println("\nMENU:\n"
        		+ "1. SHOW KING MOVES\n"
        		+ "2. MOVE KING\n"
        		+ "0. Quit");
        return dataEntryByteMinMax("Enter your option?: ", (byte) 0, (byte) 2);
    }
	
    public byte dataEntryByteMinMax(String text, byte min, byte max) {
        byte num = 0;
        System.out.print(text);
        boolean isValid = false;
        while (!isValid) {
            if (sc.hasNextByte()) {
                num = sc.nextByte();
                if (num >= min & num <= max) {
                    isValid = true;
                } else {
                    System.err.print("Error!");
                    System.out.print(text);
                }
            } else {
                sc.next();
                System.err.print("Error!!");
                System.out.print(text);
            }
        }
        return num;
    }
}
