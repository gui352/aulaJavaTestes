package br.com.guilherme_linzmayer.model;

public class Pessoa {

    private Long Id;
    private String nome;
    private String sobrenome;
    private String email;
    private String endereco;
    private String genero;

    public Long getId() { return Id; }

    public void setId(Long id) { Id = id; }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Pessoa(Long Id, String nome, String sobrenome, String email, String endereco, String genero) {
        this.Id = Id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.endereco = endereco;
        this.genero = genero;
    }
}
