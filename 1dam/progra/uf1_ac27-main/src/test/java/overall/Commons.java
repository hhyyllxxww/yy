package overall;

import org.junit.jupiter.api.Test;

import java.io.PrintStream;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;

public class Commons {
    static PrintStream originalOut = System.out;
    
    public static double tearDownAfterClass(Class<?> testClass, double totalScore) {
        System.setOut(new PrintStream(originalOut));
        totalScore = totalScore / countTestMethods(testClass);

        System.out.printf("PARTIAL SCORE: %.2f%n", totalScore);

        return totalScore;
    }


    public static int countTestMethods(Class<?> testClass) {
        int testMethodCount = 0;

        for (Method method : testClass.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Test.class)) {
                testMethodCount++;
            }
        }

        return testMethodCount;
    }

    public static double calculateScore(String testName, boolean actualResult, boolean expectedResult) {
        System.setOut(new PrintStream(originalOut));
        double score = 10.0;

        assertEquals(expectedResult, actualResult, testName + ": Test failed. Throwing exception.");

        System.out.println("\u001B[32m" + testName + ": Test Score: " + score + "\u001B[0m");
        return score;
    }

    public static double calculateScore(String testName) {
        System.setOut(new PrintStream(originalOut));
        double score = 10.0;

        System.out.println("\u001B[32m" + testName + ": Test Score: " + score + "\u001B[0m");

        return score;
    }

    public static double calculateScore(String testName, int actualResult, int expectedResult) {
        System.setOut(new PrintStream(originalOut));
        double score = 10.0;

        assertEquals(expectedResult, actualResult, testName + ": Test failed. Throwing exception.");

        System.out.println("\u001B[32m" + testName + ": Test Score: " + score + "\u001B[0m");
        return score;
    }

    public static double calculateScore(String testName, String actualResult, String expectedResult) {
        System.setOut(new PrintStream(originalOut));
        double score = 10.0;

        assertEquals(expectedResult, actualResult, testName + ": Test failed. Throwing exception.");

        System.out.println("\u001B[32m" + testName + ": Test Score: " + score + "\u001B[0m");

        return score;
    }

    public static double calculateScore(String testName, String actualResult, String expectedResult, double score) {
        System.setOut(new PrintStream(originalOut));

        assertEquals(expectedResult, actualResult, testName + ": Test failed. Throwing exception.");

        System.out.println("\u001B[32m" + testName + ": Test Score: " + score + "\u001B[0m");

        return score;
    }

    public static double calculateScore(String testName, String expectedResult, String contingut, boolean check) {
        System.setOut(new PrintStream(originalOut));
        double score = 10.0;

        if (check) {
            assertTrue(expectedResult.toLowerCase().trim().contains(contingut.toLowerCase().trim()));
        } else {
            assertFalse(expectedResult.toLowerCase().trim().contains(contingut.toLowerCase().trim()));
        }

        System.out.println("\u001B[32m" + testName + ": Test Score: " + score + "\u001B[0m");

        return score;
    }

    public static double calculateScore(String testName, String content, String toSearch, boolean check, double score) {
        System.setOut(new PrintStream(originalOut));

        if (check) {
            assertTrue(content.toLowerCase().trim().contains(toSearch.toLowerCase().trim()));
        } else {
            assertFalse(content.toLowerCase().trim().contains(toSearch.toLowerCase().trim()));
        }

        System.out.println("\u001B[32m" + testName + ": Test Score: " + score + "\u001B[0m");

        return score;
    }

    public static double calculateScore(String testName, double actualResult, double expectedResult) {
        System.setOut(new PrintStream(originalOut));

        System.setIn(System.in);
        System.setOut(System.out);

        double score = 10.0;

        assertEquals(expectedResult, actualResult, 0.01, testName + ": Test failed. Throwing exception.");

        System.out.println("\u001B[32m" + testName + ": Test Score: " + score + "\u001B[0m");

        return score;
    }

    public static boolean isMethodPublic(String methodName, Class<?> classe) {
        try {
            Method[] methods = classe.getDeclaredMethods();

            for (Method method : methods) {
                if (method.getName().equals(methodName) && java.lang.reflect.Modifier.isPublic(method.getModifiers())) {
                    return true;
                }
            }
            return false;
        } catch (SecurityException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean isMethodExists(String methodName, Class<?> classe) {
        try {
            Method[] methods = classe.getDeclaredMethods();

            for (Method method : methods) {
                if (method.getName().equals(methodName)) {
                    return true;
                }
            }
            return false;
        } catch (SecurityException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean isMethodStatic(String methodName, Class<?> classe) {
        try {
            Method[] methods = classe.getDeclaredMethods();

            for (Method method : methods) {
                if (method.getName().equals(methodName)) {
                    return Modifier.isStatic(method.getModifiers());
                }
            }
        } catch (SecurityException e) {
            return false;
        }
        return false;
    }

    public static String getMethodReturnType(String methodName, Class<?> classe) {

        try {
            Method[] methods = classe.getDeclaredMethods();

            for (Method method : methods) {
                if (method.getName().equals(methodName)) {
                    Class<?> returnType = method.getReturnType();
                    return returnType.getSimpleName();
                }
            }
        } catch (SecurityException e) {
            return "";
        }
        return "";
    }

    public static String[] getMethodParameterTypes(String methodName, Class<?> classe) {
        try {
            Method[] methods = classe.getDeclaredMethods();

            for (Method method : methods) {
                if (method.getName().equals(methodName)) {
                    Class<?>[] parameterTypes = method.getParameterTypes();

                    String[] parameterTypeNames = new String[parameterTypes.length];
                    for (int i = 0; i < parameterTypes.length; i++) {
                        parameterTypeNames[i] = parameterTypes[i].getSimpleName();
                    }

                    return parameterTypeNames;
                }
            }
        } catch (SecurityException e) {
            return null;
        }
        return null;
    }


    public Class<?> getClassFromTypeName(String typeName) {
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
    public static double calculateScore(String testName, double score) {
        System.setOut(new PrintStream(originalOut));

        System.out.println("\u001B[32m" + testName + ": Test Score: " + score + "\u001B[0m");

        return score;
    }


    static double calcScore = 0.0;

    public static double testNumberOfMethods(Class<?> classeOrigen, String[] methodNames) {double maxScore = 10.0; // Puntaje máximo para este conjunto de pruebas
        double scorePerAssertion = maxScore / (methodNames.length * 4); // Puntaje por cada aserción
        calcScore = 0.0;

        for (String methodDescription : methodNames) {
            String[] parts = methodDescription.split("#");
            String methodName = parts[0];
            boolean isNoStatic = "nostatic".toLowerCase().equals(parts[1]);
            String[] paramTypes = parts[2].split("-");
            String returnType = parts[3];

            assertAll(methodName + " should have the correct properties",
                    () -> {
                        assertTrue(Commons.isMethodExists(methodName, classeOrigen), methodName + " should exist");
                        calcScore += scorePerAssertion;
                    },
                    () -> {
                        if (!isNoStatic) {
                            assertTrue(Commons.isMethodStatic(methodName, classeOrigen), methodName + " should not be static");
                        } else {
                            assertFalse(Commons.isMethodStatic(methodName, classeOrigen), methodName + " should be static");
                        }
                        calcScore += scorePerAssertion;
                    },
                    () -> {
                        assertEquals(returnType, Commons.getMethodReturnType(methodName, classeOrigen),
                                methodName + " should have the correct return type");
                        calcScore += scorePerAssertion;
                    },
                    () -> {
                        if (!paramTypes[0].equals("void")) {
                            assertArrayEquals(paramTypes, Commons.getMethodParameterTypes(methodName, classeOrigen),
                                    methodName + " should have the correct parameter types");
                        }
                        calcScore += scorePerAssertion;
                    }
            );
        }
        return calcScore;
    }
}
