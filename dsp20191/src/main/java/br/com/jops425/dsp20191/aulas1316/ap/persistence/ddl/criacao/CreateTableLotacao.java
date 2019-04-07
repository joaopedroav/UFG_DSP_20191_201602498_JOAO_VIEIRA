package br.com.jops425.dsp20191.aulas1316.ap.persistence.ddl.criacao;

import br.com.jops425.dsp20191.aulas1316.ap.persistence.connection.PersistenciaJdbc;

public class CreateTableLotacao extends PersistenciaJdbc {

    public boolean criaTabela() throws Exception{

        preparaPersistencia();

        System.out.println("Criando a tabela Lotação");

        String sql = "CREATE TABLE IF NOT EXISTS LOTACAO(\n" +
                "id LONG NOT NULL PRIMARY KEY,\n" +
                "data_inicial DATE NOT NULL,\n" +
                "data_final DATE NOT NULL,\n" +
                "id_cargo VARCHAR(255) NOT NULL,\n" +
                "id_departamento VARCHAR(255) NOT NULL\n" +
                ")";

        stmt.executeUpdate(sql);

        System.out.println("Tabela Lotação criada com sucesso!");

        stmt.close();
        connection.close();
        return true;
    }

}
