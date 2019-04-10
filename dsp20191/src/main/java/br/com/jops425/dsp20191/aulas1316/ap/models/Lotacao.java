package br.com.jops425.dsp20191.aulas1316.ap.models;

import java.util.Date;

/**
 * Created by aluno on 03/04/19.
 */
public class Lotacao {

    private long id;

    private Date dataInicial;

    private Date dataFinal;

    private long cargoId;

    private long departamentoId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(Date dataInicial) {
        this.dataInicial = dataInicial;
    }

    public Date getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }

    public long getCargoId() {
        return cargoId;
    }

    public void setCargoId(long cargoId) {
        this.cargoId = cargoId;
    }

    public long getDepartamentoId() {
        return departamentoId;
    }

    public void setDepartamentoId(long departamentoId) {
        this.departamentoId = departamentoId;
    }
}
