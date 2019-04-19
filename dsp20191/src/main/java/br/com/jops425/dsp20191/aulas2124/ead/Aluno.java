package br.com.jops425.dsp20191.aulas2124.ead;

public class Aluno {

    private String nome;

    private long matricula;

    private String disciplina;

    private int frequencia;

    private double nota1;

    private double nota2;

    public Aluno() { }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getMatricula() {
        return matricula;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public int getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(int frequencia) {
        this.frequencia = frequencia;
    }

    public void setMatricula(long matricula) {
        this.matricula = matricula;
    }

    public double getNota1() {
        return nota1;
    }

    public void setNota1(double nota1) {
        this.nota1 = nota1;
    }

    public double getNota2() {
        return nota2;
    }

    public void setNota2(double nota2) {
        this.nota2 = nota2;
    }

    public double getMedia() {
        return (getNota1() + getNota2() / 2);
    }

    public String getAvaliacao() {
        String resultado = "";
        double media = getMedia();
        if (media >= 6.0 && getFrequencia() >= 48 ) {
            resultado = "Aprovado";
        } else {
            resultado = "Reprovado";
        }
        return resultado;
    }
}
