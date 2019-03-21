package br.com.jops425.dsp20191.aulas0508.ap;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestaConexao {

    private Conexao conexao = new Conexao();

    private Usuario usuario = new Usuario();

    InputStream inputStream;

    public String setDados(final String caminhoArquivo) throws IOException {
        StringBuilder sb = new StringBuilder();
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
            conexao.setUrlBd(properties.getProperty("urlBd"));

            sb.append(usuario.getNome());
            sb.append("\n");
            sb.append(usuario.getLogin());
            sb.append("\n");
            sb.append(usuario.getSenha());
            sb.append("\n");
            sb.append(conexao.getSgbd());
            sb.append("\n");
            sb.append(conexao.getTipoConexao());
            sb.append("\n");
            sb.append(conexao.getBancoDados());
            sb.append("\n");
            sb.append(conexao.getUrlBd());
            sb.append("\n");
        } catch (Exception excepion) {
            System.out.println(excepion);
        } finally {
            inputStream.close();
            return sb.toString();
        }
    }

}
