package br.com.jops425.dsp20191.aulas1316.ap.persistence.dml.query;

import br.com.jops425.dsp20191.aulas1316.ap.models.Departamento;
import br.com.jops425.dsp20191.aulas1316.ap.persistence.connection.PersistenciaJdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class QueryDepartamento extends PersistenciaJdbc {

    private Departamento departamento;

    public QueryDepartamento() {
        departamento = new Departamento();
    }

    public Departamento querybyId(String id) throws Exception {
        preparaPersistencia();

        String sql = "SELECT * FROM DEPARTAMENTO WHERE id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, id);

        ResultSet rs = ps.executeQuery(  );
        while(rs.next()){
            departamento.setId(rs.getString("id"));
            departamento.setNome(rs.getString("nome"));
        }

        rs.close();
        ps.close();
        stmt.close();
        connection.close();

        return departamento;
    }
}
