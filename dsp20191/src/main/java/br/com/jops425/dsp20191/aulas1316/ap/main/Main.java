package br.com.jops425.dsp20191.aulas1316.ap.main;

import br.com.jops425.dsp20191.aulas1316.ap.models.Cargo;
import br.com.jops425.dsp20191.aulas1316.ap.models.Departamento;
import br.com.jops425.dsp20191.aulas1316.ap.models.Funcionario;
import br.com.jops425.dsp20191.aulas1316.ap.persistence.ddl.alteracao.AddFKTableLotacao;
import br.com.jops425.dsp20191.aulas1316.ap.persistence.ddl.criacao.CreateTableCargo;
import br.com.jops425.dsp20191.aulas1316.ap.persistence.ddl.criacao.CreateTableDepartamento;
import br.com.jops425.dsp20191.aulas1316.ap.persistence.ddl.criacao.CreateTableFuncionario;
import br.com.jops425.dsp20191.aulas1316.ap.persistence.ddl.criacao.CreateTableLotacao;
import br.com.jops425.dsp20191.aulas1316.ap.persistence.dml.insert.InsertCargo;
import br.com.jops425.dsp20191.aulas1316.ap.persistence.dml.insert.InsertDepartamento;
import br.com.jops425.dsp20191.aulas1316.ap.persistence.dml.insert.InsertFuncionario;
import br.com.jops425.dsp20191.aulas1316.ap.persistence.dml.query.QueryFuncionario;

public class Main {

    public static void main(String[] args) throws Exception {
        Funcionario funcionario = preencheFuncionario(12345);
        CreateTableFuncionario createTableFuncionario = new CreateTableFuncionario();
        createTableFuncionario.criaTabela();
        InsertFuncionario insertFuncionario = new InsertFuncionario();
        insertFuncionario.persisteFuncionario(funcionario);
        QueryFuncionario queryFuncionario = new QueryFuncionario();
        Funcionario func2 = queryFuncionario.queryById(12345);
        System.out.println(func2.getId());
        System.out.println(func2.getNome());
        System.out.println(func2.getMatricula());
    }

    public static Funcionario preencheFuncionario(long id) {
        Funcionario func = new Funcionario();
        func.setId(id);
        func.setNome("Funcionário Teste");
        func.setMatricula(2015011111);
        return func;
    }
}
