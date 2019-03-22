package br.com.jops425.dsp20191.aulas0508.as;

public class Aluno {

    private String nome;

    private long matricula;

    private double nota1;

    private double nota2;

    public Aluno(String nom, long matric, double not1, double not2) {
        this.nome = nom;
        this.matricula = matric;
        this.nota1 = not1;
        this.nota2 = not2;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nom) {
        this.nome = nom;
    }

    public long getMatricula() {
        return matricula;
    }

    public void setMatricula(long matric) {
        this.matricula = matric;
    }

    public double getNota1() {
        return nota1;
    }

    public void setNota1(double not1) {
        this.nota1 = not1;
    }

    public double getNota2() {
        return nota2;
    }

    public void setNota2(double nota2) {
        this.nota2 = nota2;
    }

}
