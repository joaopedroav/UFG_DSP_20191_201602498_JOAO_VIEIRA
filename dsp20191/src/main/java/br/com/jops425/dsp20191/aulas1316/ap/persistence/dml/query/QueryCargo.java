package br.com.jops425.dsp20191.aulas1316.ap.persistence.dml.query;

import br.com.jops425.dsp20191.aulas1316.ap.models.Cargo;
import br.com.jops425.dsp20191.aulas1316.ap.persistence.connection.PersistenciaJdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class QueryCargo extends PersistenciaJdbc {

    private Cargo cargo;

    public QueryCargo() {
        cargo = new Cargo();
    }

    public Cargo queryById(String id) throws Exception {
        preparaPersistencia();

        String sql = "SELECT * FROM CARGO WHERE id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, id);

        ResultSet rs = ps.executeQuery(  );
        while(rs.next()){
            cargo.setId(rs.getLong("id"));
            cargo.setNome(rs.getString("nome"));
            cargo.setSalario(rs.getDouble("salario"));
        }

        rs.close();
        ps.close();
        stmt.close();
        connection.close();

        return cargo;
    }
}
