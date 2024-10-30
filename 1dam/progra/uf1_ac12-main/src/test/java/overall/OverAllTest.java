package overall;

import guessNumber.GuessNumberTest;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import java.util.ArrayList;

@Execution(ExecutionMode.SAME_THREAD)
@TestClassOrder(ClassOrderer.OrderAnnotation.class)
@Order(999)
public class OverAllTest {

    static ArrayList<Double> notas;

    @BeforeAll
    @DisplayName("OverallTest - Final Score")
    static void tearDownAfterClass() {
        notas = new ArrayList<>();
        double val = new GuessNumberTest().runAllTests();
        notas.add(val * GuessNumberTest.pes);
    }


    @Test
    @Order(999)
    void finalScore() {
        double notaFinal = 0.0;

        for (double nota : notas) {
            notaFinal += nota;
            System.out.println(nota);
        }

        System.out.println("#--------------------------------#");
        System.out.println("#--------------------------------#\n");
        System.out.printf("FINAL SCORE: %.2f%n", notaFinal);
        System.out.println("\n#--------------------------------#");
        System.out.println("#--------------------------------#");
    }
}