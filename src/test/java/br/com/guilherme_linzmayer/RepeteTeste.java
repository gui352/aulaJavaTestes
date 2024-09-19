package br.com.guilherme_linzmayer;

import br.com.guilherme_linzmayer.math.SimpleMath;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;

import static org.junit.jupiter.api.Assertions.*;

public class RepeteTeste {

    SimpleMath math;

    @BeforeEach
    void beforeEachMethod(){
        math = new SimpleMath();
    }

    @RepeatedTest(3)
    @DisplayName("Teste de divisao")
    void divisaoTest(RepetitionInfo repetitionInfo){

        System.out.println("Repete Nº: " + repetitionInfo.getCurrentRepetition() + " de "
                + repetitionInfo.getTotalRepetitions());

        double num1 = 6D;
        double num2 = 2D;

        Double actual = math.division(num1, num2);

        assertEquals(3, actual, () -> "Valores divergentes.");
    }
}