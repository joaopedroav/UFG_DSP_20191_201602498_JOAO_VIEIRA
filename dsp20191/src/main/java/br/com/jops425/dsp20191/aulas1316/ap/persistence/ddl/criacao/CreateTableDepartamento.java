package br.com.jops425.dsp20191.aulas1316.ap.persistence.ddl.criacao;

import br.com.jops425.dsp20191.aulas1316.ap.persistence.connection.PersistenciaJdbc;

public class CreateTableDepartamento extends PersistenciaJdbc {

    public boolean criaTabela() throws Exception {

        preparaPersistencia();

        System.out.println("Criando a tabela Departamento");

        String sql = "CREATE TABLE IF NOT EXISTS DEPARTAMENTO(\n" +
                "id LONG NOT NULL PRIMARY KEY,\n" +
                "nome VARCHAR(255) NOT NULL\n" +
                ")";

        stmt.executeUpdate(sql);

        System.out.println("Tabela Departamento criada com sucesso!");

        stmt.close();
        connection.close();
        return true;
    }

}
