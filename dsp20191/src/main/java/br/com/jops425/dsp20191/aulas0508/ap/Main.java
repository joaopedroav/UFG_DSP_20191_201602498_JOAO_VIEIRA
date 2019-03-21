package br.com.jops425.dsp20191.aulas0508.ap;

import java.io.IOException;

/**
 * Created by aluno on 21/03/19.
 */
public class Main {

    public static void main(final String[] args) throws IOException {
        String resultado;
        String caminho = "conexao.properties";
        TestaConexao testaConexao = new TestaConexao();
        resultado = testaConexao.setDados(caminho);
        System.out.println(resultado);
    }
}
