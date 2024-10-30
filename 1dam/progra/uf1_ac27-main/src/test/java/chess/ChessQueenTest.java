
package chess;

import org.junit.jupiter.api.*;
import overall.Commons;

import java.lang.reflect.Method;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ChessQueenTest {
    /*
     *
     * */
    public static double totalScore = 0.0;
    private static Class<?> classe = ChessQueenTest.class;
    private static Class<?> classeOrigen = ChessQueen.class;
    public static double pes = 0.2;

    String[] methodNames = {
            "placePiece#nostatic#String[][]-String#byte[]",
            "showBoard#nostatic#String[][]#String",
            "showMovementsQueen#nostatic#String[][]-byte[]#String[][]",
            "possibleMovesQueen#nostatic#String[][]-byte[]#byte[][]",
            "moveQueen#nostatic#String[][]-byte[]-byte[]#void"
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

    static ChessQueen cq;
    static final byte SIZE = 8;
    static final String QUEEN_B = "QB";

    static final String EMPTY = "--";

    static String[][] board;

    @BeforeAll
    static void setUpBeforeClass() throws Exception {
        cq = new ChessQueen();

        board = new String[SIZE][SIZE];

        for (byte i = 0; i < board.length; i++) {
            for (byte j = 0; j < board[i].length; j++) {
                board[i][j] = "--";

            }

        }
    }
    private void setUpManual() {
        cq = new ChessQueen();

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
            byte[] piece = cq.placePiece(board, QUEEN_B);

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
                + "5: --  --  --  QB  --  --  --  --  \n"
                + "6: --  --  --  --  --  --  --  --  \n"
                + "7: --  --  --  --  --  --  --  --  \n";

        board[5][3] = QUEEN_B;

        totalScore += Commons.calculateScore("testShowBoard", cq.showBoard(board).equals(text), true);
    }

    @Test
    @Order(3)
    void testPossibleMovesQueen1() {
        byte[] pos = {4, 4};
        byte[][] actual = cq.possibleMovesQueen(board, pos);

        byte[][] expected = {
                {3, 4},
                {2, 4},
                {1, 4},
                {0, 4},

                {3, 3},
                {2, 2},
                {1, 1},
                {0, 0},

                {4, 3},
                {4, 2},
                {4, 1},
                {4, 0},

                {5, 3},
                {6, 2},
                {7, 1},

                {5, 4},
                {6, 4},
                {7, 4},

                {5, 5},
                {6, 6},
                {7, 7},

                {4, 5},
                {4, 6},
                {4, 7},

                {3, 5},
                {2, 6},
                {1, 7}

        };

        for (int i = 0; i < actual.length; i++) {
            assertTrue(Arrays.equals (actual[i], expected[i]));
        }
        totalScore += 10;
    }

    @Test
    @Order(4)
    void testPossibleMovesQueen2() {
        byte[] pos = {7, 5};
        byte[][] actual = cq.possibleMovesQueen(board, pos);

        byte[][] expected = {
                {6, 5},
                {5, 5},
                {4, 5},
                {3, 5},
                {2, 5},
                {1, 5},
                {0, 5},

                {6, 4},
                {5, 3},
                {4, 2},
                {3, 1},
                {2, 0},

                {7, 4},
                {7, 3},
                {7, 2},
                {7, 1},
                {7, 0},

                {7, 6},
                {7, 7},

                {6, 6},
                {5, 7}


        };

        for (int i = 0; i < actual.length; i++) {
            assertTrue(Arrays.equals (actual[i], expected[i]));
        }
        totalScore += 10;
    }

    @Test
    @Order(6)
    void testMoveQueen() {
        for (byte i = 0; i < board.length; i++) {
            for (byte j = 0; j < board[i].length; j++) {
                board[i][j] = "--";
            }
        }
        board[7][5] = QUEEN_B;

        byte[] pos = {7, 5};
        byte[] choice = {2, 0};
        String empty = "--";

        cq.moveQueen(board, pos, choice);


        //New position of knight
        assertTrue(Arrays.equals(choice, pos));

        //Old position of King
        assertTrue(board[4][4].equals(empty));

        totalScore += 10;
    }


}
