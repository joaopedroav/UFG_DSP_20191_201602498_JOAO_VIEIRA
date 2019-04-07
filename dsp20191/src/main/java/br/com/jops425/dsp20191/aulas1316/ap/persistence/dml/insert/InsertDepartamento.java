package br.com.jops425.dsp20191.aulas1316.ap.persistence.dml.insert;

import br.com.jops425.dsp20191.aulas1316.ap.models.Departamento;
import br.com.jops425.dsp20191.aulas1316.ap.persistence.connection.PersistenciaJdbc;

public class InsertDepartamento extends PersistenciaJdbc {

    public boolean persisteDepartamento(Departamento departamento) throws Exception {

        preparaPersistencia();

        String sql = "INSERT INTO DEPARTAMENTO " +
                "VALUES(" + departamento.getId() +
                "," + departamento.getNome() +
                ")";

        stmt.executeUpdate(sql);
        System.out.println("O Departamento foi persistido corretamente.");
        stmt.close();
        connection.close();

        return true;
    }

}
