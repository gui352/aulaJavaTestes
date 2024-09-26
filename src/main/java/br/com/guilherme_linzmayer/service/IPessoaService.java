package br.com.guilherme_linzmayer.service;

import br.com.guilherme_linzmayer.model.Pessoa;

public interface IPessoaService {

    Pessoa criarPessoa(Pessoa pessoa);

    List<Pessoa>buscarTodasPessoas();

    Pessoa buscarPessoaPeloId(Long Id);

    void removerPessoaPeloId(Long Id);

    void definirPessoas(List<Pessoa> pessoas);
}
