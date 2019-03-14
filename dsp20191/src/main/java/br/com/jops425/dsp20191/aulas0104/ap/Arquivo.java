package br.com.jops425.dsp20191.aulas0104.ap; /**
 * Created by aluno on 13/03/19.
 */

import java.io.*;
import java.util.Scanner;

public class Arquivo {

    public static void gravar(final String conteudo, final String caminho) throws IOException {
        FileWriter fw = new FileWriter(caminho);
        PrintWriter pw = new PrintWriter(fw);
        pw.printf(conteudo);
        fw.close();
    }

    public static void ler(final String caminho) throws IOException {
        try {
            FileReader fr = new FileReader(caminho);
            BufferedReader br = new BufferedReader(fr);

            String linha = br.readLine();

            while (linha != null) {
                System.out.println(linha);
                linha = br.readLine();
            }
            fr.close();
        } catch (IOException e) { }
    }

    public static void main(String[] args) throws IOException {
        String conteudo = "Este é o conteúdo do arquivo.";
        String caminho = "src/main/resources/aula0104.txt";
        gravar(conteudo, caminho);
        ler(caminho);
    }
}
