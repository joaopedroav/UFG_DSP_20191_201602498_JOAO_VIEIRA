package br.com.jops425.dsp20191.aulas1316.ap.main;

import br.com.jops425.dsp20191.aulas1316.ap.models.Cargo;
import br.com.jops425.dsp20191.aulas1316.ap.models.Departamento;
import br.com.jops425.dsp20191.aulas1316.ap.models.Funcionario;
import br.com.jops425.dsp20191.aulas1316.ap.models.Lotacao;
import br.com.jops425.dsp20191.aulas1316.ap.persistence.ddl.criacao.CreateTableCargo;
import br.com.jops425.dsp20191.aulas1316.ap.persistence.ddl.criacao.CreateTableDepartamento;
import br.com.jops425.dsp20191.aulas1316.ap.persistence.ddl.criacao.CreateTableFuncionario;
import br.com.jops425.dsp20191.aulas1316.ap.persistence.ddl.criacao.CreateTableLotacao;
import br.com.jops425.dsp20191.aulas1316.ap.persistence.dml.insert.InsertCargo;
import br.com.jops425.dsp20191.aulas1316.ap.persistence.dml.insert.InsertDepartamento;
import br.com.jops425.dsp20191.aulas1316.ap.persistence.dml.insert.InsertFuncionario;
import br.com.jops425.dsp20191.aulas1316.ap.persistence.dml.insert.InsertLotacao;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

    private static int TAMF = 10;

    private static int TAMD = 4;

    private static int TAMC = 3;

    public static void main(String[] args) throws Exception {
        Funcionario[] funcs = new Funcionario[TAMF];
        CreateTableFuncionario createTableFuncionario = new CreateTableFuncionario();
        createTableFuncionario.criaTabela();
        InsertFuncionario insertFuncionario = new InsertFuncionario();

        for (int i = 0; i < TAMF; i++) {
            funcs[i] = preencheFuncionario(i);
            insertFuncionario.persisteFuncionario(funcs[i]);
        }

        Departamento[] depts = new Departamento[TAMD];
        CreateTableDepartamento createTableDepartamento = new CreateTableDepartamento();
        createTableDepartamento.criaTabela();
        InsertDepartamento insertDepartamento = new InsertDepartamento();

        for (int j = 0; j < TAMD; j++) {
            depts[j] = preencheDepartamento(Integer.toString(j));
            insertDepartamento.persisteDepartamento(depts[j]);
        }

        Cargo[] cargos = new Cargo[TAMC];
        CreateTableCargo createTableCargo = new CreateTableCargo();
        createTableCargo.criaTabela();
        InsertCargo insertCargo = new InsertCargo();

        for (int k = 0; k < TAMC; k++) {
            cargos[k] = preencheCargo(Integer.toString(k));
            insertCargo.persisteCargo(cargos[k]);
        }

        Lotacao[] lots = new Lotacao[TAMF];
        CreateTableLotacao createTableLotacao = new CreateTableLotacao();
        createTableLotacao.criaTabela();
        InsertLotacao insertLotacao = new InsertLotacao();

        String dataInicial = "20190102";
        String dataFinal = "20250102";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Date dateInicial = sdf.parse(dataInicial);
        Date dateFinal = sdf.parse(dataFinal);

        for (int l = 0; l < TAMF; l++) {
            preencheLotacao(l, dateInicial, dateFinal);
            insertLotacao.persisteLotacao(lots[l]);
        }

    }

    public static Lotacao preencheLotacao(long id, Date dateInicial, Date dateFinal) {
        Lotacao lot = new Lotacao();
        lot.setId(id);
        lot.setDataInicial(dateInicial);
        lot.setDataFinal(dateFinal);
        if (id <= 2) {
            lot.setCargoId("0");
            lot.setDepartamentoId("0");
        } else {
            if (id <= 5) {
                lot.setCargoId("1");
                lot.setDepartamentoId("1");
            } else {
                if (id <= 7) {
                    lot.setCargoId("2");
                    lot.setDepartamentoId("2");
                } else {
                    lot.setDepartamentoId("3");
                }
            }
        }
        return lot;
    }

    public static Funcionario preencheFuncionario(long id) {
        Funcionario func = new Funcionario();
        func.setId(id);
        func.setNome("Funcionário " + id);
        func.setMatricula(id);
        return func;
    }

    public static Cargo preencheCargo(String id) {
        Cargo cargo = new Cargo();
        cargo.setId(id);
        cargo.setNome("Cargo " + id);
        return cargo;
    }

    public static Departamento preencheDepartamento(String id) {
        Departamento departamento = new Departamento();
        departamento.setId(id);
        departamento.setNome("Departamento " + id);
        return departamento;
    }

}
