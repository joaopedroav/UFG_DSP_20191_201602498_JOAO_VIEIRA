package br.com.jops425.dsp20191.aulas1316.ap.persistence.dml.insert;

import br.com.jops425.dsp20191.aulas1316.ap.models.Funcionario;
import br.com.jops425.dsp20191.aulas1316.ap.persistence.connection.PersistenciaJdbc;

public class InsertFuncionario extends PersistenciaJdbc {

    public boolean persisteFuncionario(Funcionario funcionario) throws Exception {

        preparaPersistencia();

        String sql = "INSERT INTO FUNCIONARIO " +
                "VALUES(" + funcionario.getId() +
                "," + funcionario.getNome() +
                "," + funcionario.getMatricula() +
                ")";

        stmt.executeUpdate(sql);
        System.out.println("O Funcionário foi persistido corretamente.");
        stmt.close();
        connection.close();

        return true;
    }

}
