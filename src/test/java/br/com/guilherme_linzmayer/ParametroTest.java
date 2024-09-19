package br.com.guilherme_linzmayer;

import br.com.guilherme_linzmayer.math.SimpleMath;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class ParametroTest {

    SimpleMath math;

    @BeforeEach
    void beforeEachMethod(){
        math = new SimpleMath();
    }

    @DisplayName("Teste de divisão")
    @ParameterizedTest
    @MethodSource("parametroDivisaoTest")
    void divisaoTest(double num1, double num2, double expected){
        Double actual = math.division(num1, num2);

        assertEquals(expected, actual, 2D, () -> "Valor da divisão não igual ao valor esperado");
    }

    public static Stream<Arguments> parametroDivisaoTest() {
        return Stream.of(
                Arguments.of(6D, 2D, 3D),
                Arguments.of(20D, 4D, 5D),
                Arguments.of(18.3D, 3.1D, 5.90D)
        );
    }

    @DisplayName("Teste de divisão 2")
    @ParameterizedTest
    @MethodSource()
    void divisaoTest2(double num1, double num2, double expected){
        Double actual = math.division(num1, num2);

        assertEquals(expected, actual, 2D, () -> "Valor da divisão não igual ao valor esperado");
    }

    public static Stream<Arguments> divisaoTest2() {
        return Stream.of(
                Arguments.of(6D, 2D, 3D),
                Arguments.of(20D, 4D, 5D),
                Arguments.of(18.3D, 3.1D, 5.90D)
        );
    }

    @DisplayName("Teste de divisão 3")
    @ParameterizedTest
    @CsvSource({
            "6, 2, 3",
            "20, 4, 5",
            "18.3, 3.1, 5.90"
    })
    void divisaoTest3(double num1, double num2, double expected){
        Double actual = math.division(num1, num2);

        assertEquals(expected, actual, 2D, () -> "Valor da divisão não igual ao valor esperado");
    }

    @DisplayName("Teste de divisão 4")
    @ParameterizedTest
    @CsvFileSource(resources = "/testeDivisao.csv")
    void divisaoTest4(double num1, double num2, double expected){
        Double actual = math.division(num1, num2);

        assertEquals(expected, actual, 2D, () -> "Valor da divisão não igual ao valor esperado");
    }

}