package br.com.guilherme_linzmayer;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@Order(1)
@TestMethodOrder(MethodOrderer.MethodName.class)
public class OrdenaTeste {

    @Test
    void testC(){
        System.out.println("Teste C");
    }

    @Test
    void testA(){
        System.out.println("Teste A");
    }

    @Test
    void testD(){
        System.out.println("Teste D");
    }

    @Test
    void testB(){
        System.out.println("Teste B");
    }
}