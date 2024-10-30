
package chess;

import org.junit.jupiter.api.*;
import overall.Commons;

import java.lang.reflect.Method;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ChessKingTest {
    /*
     *
     * */
    public static double totalScore = 0.0;
    private static Class<?> classe = ChessKingTest.class;
    private static Class<?> classeOrigen = ChessKing.class;
    public static double pes = 0.4;

    String[] methodNames = {
            "placePiece#nostatic#String[][]-String#byte[]",
            "showBoard#nostatic#String[][]#String",
            "showMovementsKing#nostatic#String[][]-byte[]#String[][]",
            "possibleMovesKing#nostatic#String[][]-byte[]#byte[][]",
            "moveKing#nostatic#String[][]-byte[]-byte[]#void"
    };
    /*
     *
     * */

    public double runAllTests() {
        setUpManual();
        totalScore = 0.0;
        for (Method method : classe.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Test.class)) {
                try {
                    method.invoke(classe.newInstance());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        tearDownAfterClass();
        return totalScore;
    }


    @AfterAll
    static void tearDownAfterClass() {
        totalScore = Commons.tearDownAfterClass(classe, totalScore);
    }

    @Test
    @Order(1)
    public void testMethodVisibility() {

        for (String methodName : methodNames) {
            assertTrue(Commons.isMethodPublic(methodName.split("#")[0], classeOrigen), methodName + " should be public");
        }

        double score = Commons.calculateScore("testMethodVisibility");
        totalScore += score;
    }


    @Test
    @Order(2)
    public void testNumberOfMethods() {
        totalScore += Commons.testNumberOfMethods(classeOrigen, methodNames);
    }

    static ChessKing ck;
    static final byte SIZE = 8;
    static final String KING_B = "KB";

    static final String EMPTY = "--";

    static String[][] board;

    @BeforeAll
    static void setUpBeforeClass() throws Exception {
        ck = new ChessKing();

        board = new String[SIZE][SIZE];

        for (byte i = 0; i < board.length; i++) {
            for (byte j = 0; j < board[i].length; j++) {
                board[i][j] = "--";

            }

        }
    }

    private void setUpManual() {
        ck = new ChessKing();

        board = new String[SIZE][SIZE];

        for (byte i = 0; i < board.length; i++) {
            for (byte j = 0; j < board[i].length; j++) {
                board[i][j] = "--";

            }

        }
    }

    @BeforeEach
    void setUp() throws Exception {
        for (byte i = 0; i < board.length; i++) {
            for (byte j = 0; j < board[i].length; j++) {
                board[i][j] = "--";

            }

        }
    }

    @Test
    @Order(1)
    void testPlacePiece() {
        for (int i = 0; i < 10000; i++) {
            byte[] piece = ck.placePiece(board, "KING_B");

            if (piece[0] < 0 || piece[0] > SIZE - 1
                    || piece[1] < 0 || piece[1] > SIZE - 1) {
                System.out.println(Arrays.toString(piece));
            }
            assertTrue(	piece[0] >= 0 && piece[0] <= SIZE  - 1
                    && piece[1] >= 0 && piece[1] <= SIZE - 1);

        }
        totalScore += 10;

    }

    @Test
    @Order(2)
    void testShowBoard() {
        setUpManual();
        String text = "   0   1   2   3   4   5   6   7\n"
                + "0: --  --  --  --  --  --  --  --  \n"
                + "1: --  --  --  --  --  --  --  --  \n"
                + "2: --  --  --  --  --  --  --  --  \n"
                + "3: --  --  --  --  --  --  --  --  \n"
                + "4: --  --  --  --  --  --  --  --  \n"
                + "5: --  --  --  KB  --  --  --  --  \n"
                + "6: --  --  --  --  --  --  --  --  \n"
                + "7: --  --  --  --  --  --  --  --  \n";

        board[5][3] = KING_B;
        //assertEquals(ck.showBoard(board), text);
        totalScore += Commons.calculateScore("testShowBoard", ck.showBoard(board).equals(text), true);
    }


    @Test
    @Order(3)
    void testPossibleMovesKing() {
        byte[] pos = {4, 4};
        byte[][] actual = ck.possibleMovesKing(board, pos);

        byte[][] expected = {
                {3, 4},
                {3, 3},
                {4, 3},
                {5, 3},
                {5, 4},
                {5, 5},
                {4, 5},
                {3, 5}
        };

        for (int i = 0; i < actual.length; i++) {
            assertTrue(Arrays.equals (actual[i], expected[i]));
        }

        totalScore += 10;
    }

    @Test
    @Order(4)
    void testPossibleMovesKing2() {


        byte[] pos = {5, 7};
        byte[][] actual = ck.possibleMovesKing(board, pos);

        byte[][] expected = {
                {4, 7},
                {4, 6},
                {5, 6},
                {6, 6},
                {6, 7}
        };

        for (int i = 0; i < actual.length; i++) {

            assertTrue(Arrays.equals (actual[i], expected[i]));
        }
        totalScore += 10;
    }

    @Test
    @Order(4)
    void testPossibleMovesKing3() {


        byte[] pos = {6, 0};
        byte[][] actual = ck.possibleMovesKing(board, pos);

        byte[][] expected = {
                {5, 0},
                {7, 0},
                {7, 1},
                {6, 1},
                {5, 1},
                {5, 0}
        };

        for (int i = 0; i < actual.length; i++) {

            assertTrue(Arrays.equals (actual[i], expected[i]));
        }
        totalScore += 10;
    }

    @Test
    @Order(5)
    void testMoveKing() {
        for (byte i = 0; i < board.length; i++) {
            for (byte j = 0; j < board[i].length; j++) {
                board[i][j] = "--";
            }
        }
        board[4][3] = KING_B;

        byte[] pos = {4, 4};
        byte[] choice = {5, 5};
        String empty = "--";

        ck.moveKing(board, pos, choice);

        //New position of knight
        assertTrue(Arrays.equals(choice, pos));

        //Old position of King
        assertTrue(board[4][4].equals(empty));

        totalScore += 10;
    }

}
