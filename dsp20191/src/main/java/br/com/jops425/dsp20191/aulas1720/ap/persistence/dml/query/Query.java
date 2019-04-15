package br.com.jops425.dsp20191.aulas1720.ap.persistence.dml.query;

import br.com.jops425.dsp20191.aulas1316.ap.models.Funcionario;
import br.com.jops425.dsp20191.aulas1316.ap.persistence.connection.PersistenciaJdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Query extends PersistenciaJdbc {

    private Funcionario funcionario;

    public Query() {
        funcionario = new Funcionario();
    }

    public ArrayList<Funcionario> queryById(long idCargo) throws Exception {
        preparaPersistencia();

        ArrayList<Funcionario> funcs = new ArrayList<Funcionario>();

        String sql = "SELECT id,nome,matricula FROM Funcionario JOIN Lotacao" +
                "WHERE Funcionario.id = Lotacao.id_funcionario AND id_cargo = 1";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setLong(1, idCargo);

        ResultSet rs = ps.executeQuery( );
        while(rs.next()){
            funcionario.setId(rs.getLong("id"));
            funcionario.setNome(rs.getString("nome"));
            funcionario.setMatricula(rs.getLong("matricula"));
            funcs.add(funcionario);
        }

        rs.close();
        ps.close();
        stmt.close();
        connection.close();

        return funcs;
    }

}
