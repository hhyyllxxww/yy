package guessNumber;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import overall.Commons;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

@Execution(ExecutionMode.SAME_THREAD)
@TestClassOrder(ClassOrderer.OrderAnnotation.class)
@Order(3)
public class GuessNumberTest {

    /*
     *
     * */
    public static double totalScore = 0.0;
    private static Class<?> classe = GuessNumberTest.class;
    private static Class<?> classeOrigen = GuessNumber.class;
    private static int TOTAL_METHODS = 4;
    public static double pes = 0.2;

    String[] methodNames = {
            "randomNumber#static#byte#byte",
            "guessNumber#static#byte-byte#byte",
            "main#static#String[]#void"
    };
    /*
     *
     * */

    public double runAllTests() {
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



    private Class<?> getClassFromTypeName(String typeName) {
        switch (typeName) {
            case "int":
                return int.class;
            case "double":
                return double.class;
            // Agrega más casos según sea necesario para otros tipos de datos
            default:
                return String.class; // Tipo predeterminado, se puede ajustar según sea necesario
        }
    }

    @Test
    @Order(3)
    void testRandomNumber() {
        byte max = 50;
        byte randomNumber = GuessNumber.randomNumber(max);

        assertTrue(randomNumber >= 1 && randomNumber <= max);
        totalScore += Commons.calculateScore("testRandomNumber", randomNumber >= 1 && randomNumber <= max, true);
    }

    @Test
    @Order(4)
    void testGuessNumberEqual() {
        byte num = 42;
        byte randomNum = 42;
        byte result = GuessNumber.guessNumber(num, randomNum);
        totalScore += Commons.calculateScore("testGuessNumberEqual", result, 0);
    }

    @Test
    @Order(5)
    void testGuessNumberGreaterThan() {
        byte num = 75;
        byte randomNum = 60;
        byte result = GuessNumber.guessNumber(num, randomNum);

        totalScore += Commons.calculateScore("testGuessNumberGreaterThan", result, 1);
    }

    @Test
    @Order(6)
    void testGuessNumberLessThan() {
        byte num = 30;
        byte randomNum = 45;
        byte result = GuessNumber.guessNumber(num, randomNum);

        totalScore += Commons.calculateScore("testGuessNumberLessThan", result, -1);
    }


}
