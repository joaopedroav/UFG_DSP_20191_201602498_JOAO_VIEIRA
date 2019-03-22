package br.com.jops425.dsp20191.aulas0508.as;

import java.io.*;
import java.util.Scanner;
import br.com.jops425.dsp20191.aulas0104.ap.Arquivo;

public class Main {

    public static void main(final String[] args) throws IOException {
        final String caminho = "src/main/resources/avaliacao.dat";
        gravarDados(caminho);
        lerArquivo(caminho);
    }

    public static void gravarDados(final String caminho) throws IOException {
        String nome = "Ludwig van Beethoven";
        long matricula = 177005000;
        double nota1 = 8.7;
        double nota2 = 8.0;
        Aluno aluno = new Aluno();
        aluno.setNome(nome);
        aluno.setMatricula(matricula);
        aluno.setNota1(nota1);
        aluno.setNota2(nota2);
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

    public static void lerArquivo(final String caminho) throws IOException {
        Aluno aluno = new Aluno();
        FileInputStream fis = new FileInputStream(caminho);
        DataInputStream dis = new DataInputStream(fis);
        aluno.setNome(dis.readUTF());
        aluno.setMatricula(dis.readLong());
        aluno.setNota1(dis.readDouble());
        aluno.setNota2(dis.readDouble());

        double media = aluno.media(aluno.getNota1(), aluno.getNota2());

        System.out.println("Nome: " + aluno.getNome());
        System.out.println("Matrícula: " + aluno.getMatricula());
        System.out.println("Nota 1: " + aluno.getNota1());
        System.out.println("Nota 2: " + aluno.getNota2());
        System.out.println("Média: " + media);
        System.out.println("Resultado: " + getResultado(media));
    }

    public static String getResultado(final double media) {
        if (media >= 5.0) {
            return "Aprovado";
        } else {
            return "Reprovado";
        }
    }

}
