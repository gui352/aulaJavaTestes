package br.com.guilherme_linzmayer;

import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OrdenaPorIndexTeste {

    StringBuilder valorAtual = new StringBuilder("");

    @AfterEach
    void afterEach(){
        System.out.println("Valor do teste: " + valorAtual);
    }

    @Test
    @Order(4)
    void testA(){
        System.out.println("Teste A");
        valorAtual.append("4");
    }

    @Test
    @Order(1)
    void testB(){
        System.out.println("Teste B");
        valorAtual.append("1");
    }

    @Test
    @Order(3)
    void testC(){
        System.out.println("Teste C");
        valorAtual.append("3");
    }

    @Test
    @Order(2)
    void testD(){
        System.out.println("Teste D");
        valorAtual.append("2");
    }
}