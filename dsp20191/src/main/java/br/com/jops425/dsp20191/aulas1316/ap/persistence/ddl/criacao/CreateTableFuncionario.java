package br.com.jops425.dsp20191.aulas1316.ap.persistence.ddl.criacao;

import br.com.jops425.dsp20191.aulas1316.ap.persistence.connection.PersistenciaJdbc;

public class CreateTableFuncionario extends PersistenciaJdbc {

    public boolean criaTabela() throws Exception {

        preparaPersistencia();

        System.out.println("Criando a tabela Funcionário");

        String sql = "CREATE TABLE IF NOT EXISTS FUNCIONARIO(\n" +
                "id LONG NOT NULL PRIMARY KEY,\n" +
                "nome VARCHAR(255) NOT NULL,\n" +
                "matricula VARCHAR(255) NOT NULL\n" +
                ")";

        stmt.executeUpdate(sql);

        System.out.println("Tabela Funcionário criada com sucesso!");

        stmt.close();
        connection.close();
        return true;
    }

}
