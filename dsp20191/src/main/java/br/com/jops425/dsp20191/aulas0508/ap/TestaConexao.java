package br.com.jops425.dsp20191.aulas0508.ap;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestaConexao {

    private static Conexao conexao = new Conexao();

    private static Usuario usuario = new Usuario();

    InputStream inputStream;

    public void main(final String[] args) throws IOException {
        String caminhoArquivo = "src/main/resources/conexao.properties";
        setDados(caminhoArquivo);
    }

    public void setDados(final String caminhoArquivo) throws IOException {
        try {
            Properties properties = new Properties();
            inputStream = getClass().getClassLoader().getResourceAsStream(caminhoArquivo);

            if (inputStream != null) {
                properties.load(inputStream);
            } else {
                throw new FileNotFoundException("Arquivo não encontrado.");
            }

            usuario.setNome(properties.getProperty("nome"));
            usuario.setLogin(properties.getProperty("usuario"));
            usuario.setSenha(properties.getProperty("senha"));
            conexao.setSgbd(properties.getProperty("sgbd"));
            conexao.setTipoConexao(properties.getProperty("tipoConexao"));
            conexao.setBancoDados(properties.getProperty("bancoDados"));
            conexao.setUrlBd(properties.getProperty("url"));
        } catch (Exception excepion) {
            System.out.println(excepion);
        } finally {
            inputStream.close();
        }
    }

}
