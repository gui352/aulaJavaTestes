package br.com.guilherme_linzmayer.service;

import br.com.guilherme_linzmayer.model.Pessoa;

public class PessoaService implements IPessoaService {

    @Override
    public Pessoa criarPessoa(Pessoa pessoa){
        Pessoa pessoa1 = new Pessoa("", "", "", 0);
        return pessoa;
    }
}
