package br.com.osterloh;

import br.com.osterloh.math.SimpleMath;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class SimpleMathTest {

    SimpleMath math;

    @BeforeAll
    static void setup(){
        System.out.println("Running @BeforeAll method");
    }

    @AfterAll
    static void cleanup(){
        System.out.println("Running @AfterAll method");
    }

    @BeforeEach
    void beforeEachMethod(){
        System.out.println("Running @BeforeEach method");
        math = new SimpleMath();
    }

    @AfterEach
    void afterEachMethod(){
        System.out.println("Running @AfterEach method");
    }

    // test[System Under Test]_[Condition or State Change]_[Expected Result]
    @Test
    @DisplayName("Test 6.2 + 2 = 8.2")
//    void testSum(){
    void testSum_When_SixDotTwoIsAddedByTwo_ShouldReturnEightDotTwo() {
        System.out.println("Teste de soma");
        //Given / Arrange
//        SimpleMath math = new SimpleMath();

        //When / Act
        double firstNumber = 6.2D;
        double secondNumber = 2D;

        Double actual = math.sum(firstNumber, secondNumber);
        double expected = 8.2D;

        //Then / Assert
//        assertEquals(expected, actual);
//        assertEquals(expected, actual, "The testSum() did not produce expected result!"); //msg apresentada caso ocorra falha
        assertEquals(expected, actual, () -> "The testSum() did not produce expected result!"); //msg só será apresentada caso ocorra falha - Lazy Assert Messages
        assertNotEquals(7.2, actual);   //verifica se não é igual
        assertNotNull(actual);  //verifica se não é vazio
    }

    @Test
    @DisplayName("Test 6 - 2 = 4")
    void testSubtraction(){
        System.out.println("Teste subtração");
//        SimpleMath math = new SimpleMath();

        double firstNumber = 6D;
        double secondNumber = 2D;

        Double actual = math.subtraction(firstNumber, secondNumber);
        double expected = 4D;

        assertEquals(expected, actual, () -> "The testSubtraction() did not produce expected result!");
    }

    @Test
    @DisplayName("Test 6 * 2 = 12")
    void testMutiplication(){
        System.out.println("Teste multiplição");
//        SimpleMath math = new SimpleMath();

        double firstNumber = 6D;
        double secondNumber = 2D;

        Double actual = math.multiplication(firstNumber, secondNumber);
        double expected = 12D;

        assertEquals(expected, actual, () -> "The testMultiplication() did not produce expected result!");
    }

    @Test
    @DisplayName("Test 6 / 2 = 3")
    void testDivision(){
        System.out.println("Teste Divisão");
//        SimpleMath math = new SimpleMath();

        double firstNumber = 6D;
        double secondNumber = 2D;

        Double actual = math.division(firstNumber, secondNumber);
        double expected = 3D;

        assertEquals(expected, actual, () -> "The testDivision() did not produce expected result!");
    }

    @Test
    @DisplayName("Teste Division by Zero")
    void testDivision_When_FirstNumberDivisionByZero_ShouldThrowAritmeticException(){
        //given
        double firstNumber = 6D;
        double secondNumber = 2D;

        String expectdMessage = "Impossível divisão por zero";

        //when & then
        ArithmeticException actual = assertThrows(ArithmeticException.class, () -> {
            //when & then
            math.division(firstNumber, secondNumber);
        }, () -> "Division by zero should throw an ArithmeticException");

        assertEquals(expectdMessage, actual.getMessage(), () -> "Unexpectded exception message");
    }

    @Test
    @DisplayName("Test (6 + 2) / 2 = 4")
    void testMean(){
        System.out.println("Teste média");
//        SimpleMath math = new SimpleMath();

        double firstNumber = 6D;
        double secondNumber = 2D;

        Double actual = math.mean(firstNumber, secondNumber);
        double expected = 4D;

        assertEquals(expected, actual, () -> "The testMean() did not produce expected result!");
    }

    @Test
    @DisplayName("Test Square Root of 9 = 3")
    void testSquareRoot(){
        System.out.println("Teste raiz quadrada");
//        SimpleMath math = new SimpleMath();

        double number = 9D;

        Double actual = math.squareRoot(number);
        double expected = 3D;

        assertEquals(expected, actual, () -> "The testSquareRoot() did not produce expected result!");
    }
}
