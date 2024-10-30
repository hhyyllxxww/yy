package chess;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import overall.Commons;

import java.lang.reflect.Method;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Execution(ExecutionMode.SAME_THREAD)
@TestClassOrder(ClassOrderer.OrderAnnotation.class)
@Order(3)
public class ChessKnightTest {

    /*
     *
     * */
    public static double totalScore = 0.0;
    private static Class<?> classe = ChessKnightTest.class;
    private static Class<?> classeOrigen = ChessKnight.class;
    public static double pes = 0.6;

    String[] methodNames = {
            "placePiece#nostatic#String[][]-String#byte[]",
            "showBoard#nostatic#String[][]#String",
            "showMovementsHorse#nostatic#String[][]-byte[]#String[][]",
            "possibleMovesHorse#nostatic#String[][]-byte[]#byte[][]",
            "moveHorse#nostatic#String[][]-byte[]-byte[]#void"
    };
    /*
     *
     * */

    public double runAllTests() {
        setUpManuall();
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

    static ChessKnight ck;
    static final byte SIZE = 8;
    static final String HORSE_B = "HB";

    static final String EMPTY = "--";

    static String[][] board;

    @BeforeAll
    static void setUpBeforeClass() throws Exception {
        ck = new ChessKnight();

        board = new String[SIZE][SIZE];

        for (byte i = 0; i < board.length; i++) {
            for (byte j = 0; j < board[i].length; j++) {
                board[i][j] = "--";

            }

        }
    }
    private void setUpManuall() {
        ck = new ChessKnight();

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
            byte[] piece = ck.placePiece(board, "HORSE_B");

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
        setUpManuall();
        String text = "   0   1   2   3   4   5   6   7\n"
                + "0: --  --  --  --  --  --  --  --  \n"
                + "1: --  --  --  --  --  --  --  --  \n"
                + "2: --  --  --  --  --  --  --  --  \n"
                + "3: --  --  --  --  --  --  --  --  \n"
                + "4: --  --  --  --  --  --  --  --  \n"
                + "5: --  --  --  HB  --  --  --  --  \n"
                + "6: --  --  --  --  --  --  --  --  \n"
                + "7: --  --  --  --  --  --  --  --  \n";

        board[5][3] = HORSE_B;
        totalScore += Commons.calculateScore("testShowBoard", ck.showBoard(board).equals(text), true);
    }


    @Test
    @Order(3)
    void testPossibleMovesHorse() {

        byte[] pos = {4, 3};
        byte[][] actual = ck.possibleMovesHorse(board, pos);

        byte[][] expected = {
                {2, 2},
                {3, 1},
                {5, 1},
                {6, 2},
                {6, 4},
                {5, 5},
                {3, 5},
                {2, 4}
        };

        for (int i = 0; i < actual.length; i++) {

            assertTrue(Arrays.equals (actual[i], expected[i]));
        }
        totalScore += 10;
    }

    @Test
    @Order(4)
    void testPossibleMovesHorse2() {


        byte[] pos = {5, 6};
        byte[][] actual = ck.possibleMovesHorse(board, pos);

        byte[][] expected = {
                {3, 5},
                {4, 4},
                {6, 4},
                {7, 5},
                {7, 7},
                {3, 7}
        };

        for (int i = 0; i < actual.length; i++) {

            assertTrue(Arrays.equals (actual[i], expected[i]));
        }
        totalScore += 10;
    }

    @Test
    @Order(5)
    void testPossibleMovesHorse3() {


        byte[] pos = {1, 3};
        byte[][] actual = ck.possibleMovesHorse(board, pos);

        byte[][] expected = {
                {0, 1},
                {2, 1},
                {3, 2},
                {3, 4},
                {2, 5},
                {0, 5}
        };

        for (int i = 0; i < actual.length; i++) {

            assertTrue(Arrays.equals (actual[i], expected[i]));
        }
        totalScore += 10;
    }


    @Test
    @Order(6)
    void testPossibleMovesHorse4() {

        byte[] pos = {0, 0};
        byte[][] actual = ck.possibleMovesHorse(board, pos);

        byte[][] expected = {
                {2, 1},
                {1, 2}
        };

        for (int i = 0; i < actual.length; i++) {

            assertTrue(Arrays.equals (actual[i], expected[i]));
        }
        totalScore += 10;
    }

    @Test
    @Order(7)
    void testMoveHorse() {
        for (byte i = 0; i < board.length; i++) {
            for (byte j = 0; j < board[i].length; j++) {
                board[i][j] = "--";
            }
        }
        board[4][3] = HORSE_B;

        byte[] pos = {4, 3};
        byte[] choice = {2, 2};
        String empty = "--";

        ck.moveHorse(board, pos, choice);

        //New position of knight
        totalScore += (Commons.calculateScore("testMoveHorse1", Arrays.equals(choice, pos), true)/2);

        //Old position of knight
        totalScore += (Commons.calculateScore("testMoveHorse2", board[4][3].equals(empty), true)/2);
    }

}
