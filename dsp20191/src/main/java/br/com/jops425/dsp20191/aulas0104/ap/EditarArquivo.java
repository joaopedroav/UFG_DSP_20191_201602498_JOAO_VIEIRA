package br.com.jops425.dsp20191.aulas0104.ap;

import java.io.IOException;

public class EditarArquivo {

    private final static int numLinhas = 5;

    public static void main(final String[] args) throws IOException {
        String caminho = "src/main/resources/aula0104.txt";
        String conteudo = gerarLinhas(numLinhas);
        Arquivo.gravar(conteudo, caminho);
        Arquivo.ler(caminho);
    }

    public static String gerarLinhas(final int num) {
        String linhas = "";
        for (int i = 0; i < num; i++) {
            if (i == 0) {
                linhas += "\n";
            }
            linhas += "Esta é a linha acrescida - número " + (i + 1) + "\n";
        }
        return linhas;
    }

}
