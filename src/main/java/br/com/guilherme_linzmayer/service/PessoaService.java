package br.com.guilherme_linzmayer.service;

import br.com.guilherme_linzmayer.model.Pessoa;

public class PessoaService implements IPessoaService {

    private List<Pessoa> pessoaDatabase = new ArrayList<>();

    @Override
    public Pessoa criarPessoa(Pessoa pessoa){
        Pessoa pessoa1 = new Pessoa(pessoa);
        return pessoa;
    }

    @Override
    public List<Pessoa> buscarTodasPessoas() {
        if (pessoaDatabase == null) {
            throw new RuntimeException("Lista de pessoas é nula");
        }
        return pessoaDatabase;
    }

    @Override
    public Pessoa buscarPessoaPeloId(Long id) {
        return pessoaDatabase.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Pessoa não encontrada com ID: " + id));
    }

    @Override
    public void removerPessoaPeloId(Long id) {
        pessoaDatabase.removeIf(p -> p.getId().equals(id));
    }

    @Override
    public void definirPessoas(List<Pessoa> pessoas) {
        this.pessoaDatabase = pessoas;
    }
}
