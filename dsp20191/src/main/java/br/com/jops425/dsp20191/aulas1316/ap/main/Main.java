package br.com.jops425.dsp20191.aulas1316.ap.main;

import br.com.jops425.dsp20191.aulas1316.ap.persistence.ddl.alteracao.AddFKTableLotacao;
import br.com.jops425.dsp20191.aulas1316.ap.persistence.ddl.criacao.CreateTableCargo;
import br.com.jops425.dsp20191.aulas1316.ap.persistence.ddl.criacao.CreateTableDepartamento;
import br.com.jops425.dsp20191.aulas1316.ap.persistence.ddl.criacao.CreateTableFuncionario;
import br.com.jops425.dsp20191.aulas1316.ap.persistence.ddl.criacao.CreateTableLotacao;

public class Main {

    public static void main(String[] args) throws Exception {
        CreateTableCargo createTableCargo = new CreateTableCargo();
        CreateTableDepartamento createTableDepartamento = new CreateTableDepartamento();
        CreateTableFuncionario createTableFuncionario = new CreateTableFuncionario();
        CreateTableLotacao createTableLotacao = new CreateTableLotacao();
        AddFKTableLotacao addFKTableLotacao = new AddFKTableLotacao();
        createTableCargo.criaTabela();
        createTableDepartamento.criaTabela();
        createTableFuncionario.criaTabela();
        createTableLotacao.criaTabela();
        addFKTableLotacao.alteraTabela();
    }
}
