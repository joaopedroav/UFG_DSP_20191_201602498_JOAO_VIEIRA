package br.com.jops425.dsp20191.aulas1316.ap.persistence.dml.query;

import br.com.jops425.dsp20191.aulas1316.ap.models.Funcionario;
import br.com.jops425.dsp20191.aulas1316.ap.persistence.connection.PersistenciaJdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class QueryFuncionario extends PersistenciaJdbc {

    private Funcionario funcionario;

    public QueryFuncionario() {
        funcionario = new Funcionario();
    }

    public ArrayList<Funcionario> queryById() throws Exception {
        preparaPersistencia();

        ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();

        String sql = "SELECT * FROM FUNCIONARIO";
        PreparedStatement ps = connection.prepareStatement(sql);
//        ps.setLong(1, id);

        ResultSet rs = ps.executeQuery( );
        while(rs.next()){
            funcionario.setId(rs.getLong("id"));
            funcionario.setNome(rs.getString("nome"));
            funcionario.setMatricula(rs.getLong("matricula"));
            funcionarios.add(funcionario);
        }

        rs.close();
        ps.close();
        stmt.close();
        connection.close();

        return funcionarios;
    }
}
