package br.com.jops425.dsp20191.aulas1316.ap.persistence.ddl.alteracao;

import br.com.jops425.dsp20191.aulas1316.ap.persistence.connection.PersistenciaJdbc;

public class AddFKTableLotacao extends PersistenciaJdbc {

    public boolean alteraTabela() throws Exception{

        preparaPersistencia();

        System.out.println("Alterando a Tabela Lotação");

        String sql = "ALTER TABLE LOTACAO\n" +
                "ADD FOREIGN (id_cargo) REFERENCES CARGO(id) ON DELETE CASCADE\n" +
                "ADD FOREIGN (id_departamento) REFERENCES DEPARTAMENTO(id) ON DELETE CASCADE";

        stmt.executeUpdate(sql);

        System.out.println("Tabela Lotação alterada com sucesso!");

        stmt.close();
        connection.close();
        return true;
    }

}
