package br.com.jops425.dsp20191.aulas2124.ead;

import java.io.*;

public class AvaliacaoAluno {

    public static void main(String[] args) throws IOException {
        final String caminho = "src/main/resources/aluno.dat";
        Aluno aluno = new Aluno();
        aluno.setNome("Paul Thomas-Anderson");
        aluno.setMatricula(199606123);
        aluno.setDisciplina("Direção de arte");
        aluno.setNota1(10.0);
        aluno.setNota2(9.5);
        aluno.setFrequencia(60);
        gravarInstancia(caminho, aluno);
        Aluno alunoLido = lerDados(caminho);
        System.out.println(alunoLido.getAvaliacao());

    }

    public static void gravarInstancia(String caminho, Aluno aluno) throws IOException {
        try {
            FileOutputStream fos = new FileOutputStream(caminho);
            DataOutputStream dos = new DataOutputStream(fos);
            dos.writeUTF(aluno.getNome());
            dos.writeLong(aluno.getMatricula());
            dos.writeUTF(aluno.getDisciplina());
            dos.writeInt(aluno.getFrequencia());
            dos.writeDouble(aluno.getNota1());
            dos.writeDouble(aluno.getNota2());
            fos.close();
        } catch (Exception exc) {
            System.out.println(exc);
        }
    }

    public static Aluno lerDados(String caminho) throws IOException {
        Aluno alunoLido = new Aluno();
        FileInputStream fis = new FileInputStream(caminho);
        DataInputStream dis = new DataInputStream(fis);
        alunoLido.setNome(dis.readUTF());
        alunoLido.setMatricula(dis.readLong());
        alunoLido.setDisciplina(dis.readUTF());
        alunoLido.setFrequencia(dis.readInt());
        alunoLido.setNota1(dis.readDouble());
        alunoLido.setNota2(dis.readDouble());
        dis.close();
        return alunoLido;
    }
}
