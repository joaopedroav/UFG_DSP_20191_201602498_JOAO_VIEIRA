package br.com.jops425.dsp20191.aulas1316.ap.persistence.dml.query;

import br.com.jops425.dsp20191.aulas1316.ap.models.Lotacao;
import br.com.jops425.dsp20191.aulas1316.ap.persistence.connection.PersistenciaJdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class QueryLotacao extends PersistenciaJdbc {

    private Lotacao lotacao;

    public QueryLotacao() {
        lotacao = new Lotacao();
    }

    public Lotacao queryById(long id) throws Exception {
        preparaPersistencia();

        String sql = "SELECT * FROM LOTACAO WHERE id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setLong(1, id);

        ResultSet rs = ps.executeQuery(  );
        while(rs.next()){
            lotacao.setId(rs.getLong("id"));
            lotacao.setDataInicial(rs.getString("data_inicial"));
            lotacao.setDataFinal(rs.getString("data_final"));
            lotacao.setCargoId(rs.getLong("id_cargo"));
            lotacao.setDepartamentoId(rs.getLong("id_departamento"));
        }

        rs.close();
        ps.close();
        stmt.close();
        connection.close();

        return lotacao;
    }
}
