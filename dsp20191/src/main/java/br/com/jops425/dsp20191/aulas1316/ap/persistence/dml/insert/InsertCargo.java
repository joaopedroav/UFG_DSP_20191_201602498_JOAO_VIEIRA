package br.com.jops425.dsp20191.aulas1316.ap.persistence.dml.insert;

import br.com.jops425.dsp20191.aulas1316.ap.models.Cargo;
import br.com.jops425.dsp20191.aulas1316.ap.persistence.connection.PersistenciaJdbc;

public class InsertCargo extends PersistenciaJdbc {

    public boolean persisteCargo(Cargo cargo) throws Exception {

        preparaPersistencia();

        String sql = "INSERT INTO CARGO " +
                "VALUES('" + cargo.getId() +
                "','" + cargo.getNome() +
                "')";

        stmt.executeUpdate(sql);
        System.out.println("O Cargo foi persistido corretamente.");
        stmt.close();
        connection.close();

        return true;
    }

}
