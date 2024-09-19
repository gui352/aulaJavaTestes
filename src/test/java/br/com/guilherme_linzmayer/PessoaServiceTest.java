package br.com.guilherme_linzmayer;

import br.com.guilherme_linzmayer.model.Pessoa;
import br.com.guilherme_linzmayer.service.IPessoaService;
import br.com.guilherme_linzmayer.service.PessoaService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PessoaServiceTest {

    Pessoa pessoa;

    @BeforeEach
    void setup(){
        pessoa = new Pessoa("John", "Doe", "john@email.com", 25);
    }

    @DisplayName("Teste cria pessoa")
    @Test
    void testeCriaPessoa_QuandoSucesso_DeceRetornarObjetoPessoa(){
        IPessoaService service = new PessoaService();

        Pessoa atual = service.criarPessoa(pessoa);

        assertNotNull(atual, () -> "criarPessoa() não deve retornar NULL!");
    }

    @DisplayName("Teste cria pessoa com nome")
    @Test
    void testeCriaPessoa_QuandoSucesso_DeveConterPrimeiroNome(){
        IPessoaService service = new PessoaService();

        Pessoa atual = service.criarPessoa(pessoa);
        atual.setNome(null);

        assertEquals(pessoa.getNome(),atual.getNome(),  () -> "Nome da pessoa é diferente!");
    }

    @DisplayName("Teste cria pessoa com sobrenome")
    @Test
    void testeCriaPessoa_QuandoSucesso_DeveConterSobrenome(){
        IPessoaService service = new PessoaService();

        Pessoa atual = service.criarPessoa(pessoa);
        atual.setSobrenome(null);

        assertEquals(pessoa.getSobrenome(),atual.getSobrenome(),  () -> "Sobrenome da pessoa é diferente!");
    }

    @DisplayName("Teste cria pessoa com email")
    @Test
    void testeCriaPessoa_QuandoSucesso_DeveConterEmail(){
        IPessoaService service = new PessoaService();

        Pessoa atual = service.criarPessoa(pessoa);
        atual.setEmail(null);

        assertEquals(pessoa.getEmail(),atual.getEmail(),  () -> "Email da pessoa é diferente!");
    }

    @DisplayName("Teste cria pessoa com idade")
    @Test
    void testeCriaPessoa_QuandoSucesso_DeveConterIdade(){
        IPessoaService service = new PessoaService();

        Pessoa atual = service.criarPessoa(pessoa);
        atual.setIdade(0);

        assertEquals(pessoa.getIdade(),atual.getIdade(),  () -> "Idade da pessoa é diferente!");
    }
}
