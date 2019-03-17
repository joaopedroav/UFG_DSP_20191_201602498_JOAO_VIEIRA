package br.com.jops425.dsp20191.aulas0104.ap;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public class ArquivoCSV {

    private static final int MAX_LINHAS = 28;

    private static final int IND3 = 2;

    private static final int IND4 = 3;

    public static void main(final String[] args) {
        String caminho = "src/main/resources/UF.csv";
        ArrayList<UnidadeFederacao> unidadeFederacao = lerCSV(caminho);
        for (int i = 0; i < unidadeFederacao.size(); i++) {
            System.out.println(unidadeFederacao.get(i));
        }
    }

    public static ArrayList<UnidadeFederacao> lerCSV(final String caminho) {
        ArrayList<UnidadeFederacao> unidadeFederacao = new ArrayList<UnidadeFederacao>();
        String[] celulas = null;
        int numLinhasArq = 0;
        String linha = "";
        try {
            FileReader fr = new FileReader(caminho);
            BufferedReader br = new BufferedReader(fr);

            while ((linha = br.readLine()) != null) {
                if (numLinhasArq > 0 && numLinhasArq < MAX_LINHAS) {
                    if (linha != "") {
                        celulas = linha.split(",");
                        unidadeFederacao.add(new UnidadeFederacao(Integer.valueOf(celulas[0]),
                                celulas[1], celulas[IND3], Integer.valueOf(celulas[IND4])));
                    }
                }
                numLinhasArq++;
            }
            fr.close();
        } catch (IOException e) { }
        return unidadeFederacao;
    }
}
