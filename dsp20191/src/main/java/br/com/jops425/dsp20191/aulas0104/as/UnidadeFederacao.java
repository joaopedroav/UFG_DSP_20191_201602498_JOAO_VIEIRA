package br.com.jops425.dsp20191.aulas0104.as;

public class UnidadeFederacao {

    private int ufed_idenufed_sigl;

    private String ufed_nome;

    private String ufed_codg_regiao;

    private int num;

    public UnidadeFederacao(final int ufis, final String ufedn,
                            final String ufedcr, final int numero) {
        this.ufed_idenufed_sigl = ufis;
        this.ufed_nome = ufedn;
        this.ufed_codg_regiao = ufedcr;
        this.num = numero;
    }

    public final int getUfed_idenufed_sigl() {
        return ufed_idenufed_sigl;
    }

    public void setUfed_idenufed_sigl(int ufed_idenufed_sigl) {
        this.ufed_idenufed_sigl = ufed_idenufed_sigl;
    }

    public final String getUfed_nome() {
        return ufed_nome;
    }

    public void setUfed_nome(String ufed_nome) {
        this.ufed_nome = ufed_nome;
    }

    public final String getUfed_codg_regiao() {
        return ufed_codg_regiao;
    }

    public void setUfed_codg_regiao(String ufed_codg_regiao) {
        this.ufed_codg_regiao = ufed_codg_regiao;
    }

    public final int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public final String toString() {
        String uf = this.ufed_idenufed_sigl + " " + this.ufed_nome + " "
                + this.ufed_codg_regiao + " " + this.num;
        return uf;
    }
}
