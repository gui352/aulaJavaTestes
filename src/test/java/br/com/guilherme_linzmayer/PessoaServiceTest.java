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
    private PessoaService service;
    private List<Pessoa> pessoas;

    @BeforeEach
    service = new PessoaService();
    pessoa = new Pessoa(1, "John", "Doe", "john.doe@email.com", "Santa Catarina - SC", "M");
    pessoas = new ArrayList<>();
    pessoas.add(new Pessoa(2, "John0", "Doe", "john0.doe@email.com", "Santa Catarina - SC", "M"));
    pessoas.add(new Pessoa(3, "John1", "Doe", "john1.doe@email.com", "Santa Catarina - SC", "M"));
    pessoas.add(new Pessoa(4, "John2", "Doe", "john2.doe@email.com", "Santa Catarina - SC", "M"));

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

    @DisplayName("Teste de busca de todas as pessoas")
    @Test
    void testeBuscarTodasPessoas() {
        List<Pessoa> result = service.buscarTodasPessoas();
        assertEquals(3, result.size());
    }

    @DisplayName("Teste de busca de todas as pessoas - Lista nula retorna RuntimeException")
    @Test
    void testeBuscarTodasPessoasQuandoListaENula() {
        service.definirPessoas(null);
        RuntimeException exception = assertThrows(RuntimeException.class, service::buscarTodasPessoas);
        assertEquals("Lista de pessaos é nula", exception.getMessage());
    }

    @DisplayName("Teste busca pessoa por ID")
    @Test
    void testeBuscarPessoaPeloIDSucesso() {
        Pessoa result = service.buscarPessoaPeloId(2); // Busca uma pessoa pelo ID
        assertNotNull(result);
        assertEquals("Nome Pessoa:", result.getFirstName());
    }

    @DisplayName("Teste busca pessoa por ID -  Retornar IllegalArgumentException")
    @Test
    void testeBuscarPessoaPeloIdInvalido() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            service.buscarPessoaPeloId(10);
        });
        assertEquals("Pessoa não encontrada com ID: 10", exception.getMessage());
    }

    @DisplayName("Teste exclui pessoa")
    @Test
    void testeRemoverPessoaPeloIdSucesso() {
        service.removerPessoaPeloId(2); // Remove uma pessoa pelo ID
        List<Pessoa> result = service.buscarTodasPessoas();
        assertEquals(2, result.size());
    }
}
