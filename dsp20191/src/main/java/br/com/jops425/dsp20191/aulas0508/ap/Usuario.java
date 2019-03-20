package br.com.jops425.dsp20191.aulas0508.ap;

public class Usuario {

    private String nome;

    private String login;

    private String senha;

    public Usuario() { }

    public final String getNome() {
        return nome;
    }

    public void setNome(final String nome0) {
        this.nome = nome0;
    }

    public final String getLogin() {
        return login;
    }

    public void setLogin(final String login0) {
        this.login = login0;
    }

    public final String getSenha() {
        return senha;
    }

    public void setSenha(final String senha0) {
        this.senha = senha;
    }

}
