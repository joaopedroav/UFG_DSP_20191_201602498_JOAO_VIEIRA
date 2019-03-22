package br.com.jops425.dsp20191.aulas0508.as;

import java.io.*;
import java.util.Scanner;
import br.com.jops425.dsp20191.aulas0104.ap.Arquivo;

public class Main {

    public static void main(final String[] args) throws IOException {
        final String caminho = "src/main/resources/avaliacao.dat";
        gravarDados(caminho);
    }

    public static void gravarDados(final String caminho) throws IOException {
        String nome = "Duke of Norfolk";
        long matricula = 194602989;
        double nota1 = 8.7;
        double nota2 = 8.0;
        Aluno aluno = new Aluno(nome, matricula, nota1, nota2);
        try {
            FileOutputStream fos = new FileOutputStream(caminho);
            DataOutputStream dos = new DataOutputStream(fos);
            dos.writeUTF(aluno.getNome());
            dos.writeLong(aluno.getMatricula());
            dos.writeDouble(aluno.getNota1());
            dos.writeDouble(aluno.getNota2());
            fos.close();
        } catch (Exception exc) {
            System.out.println(exc);
        }
    }

    public static void lerArquivo(String caminho) {

    }

}
