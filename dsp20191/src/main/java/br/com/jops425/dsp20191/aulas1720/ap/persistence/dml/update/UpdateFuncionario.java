package br.com.jops425.dsp20191.aulas1720.ap.persistence.dml.update;

import br.com.jops425.dsp20191.aulas1316.ap.persistence.connection.PersistenciaJdbc;
import br.com.jops425.dsp20191.aulas1316.ap.persistence.dml.query.QueryFuncionario;
import br.com.jops425.dsp20191.aulas1316.ap.models.Funcionario;

import java.sql.PreparedStatement;

/**
 * Created by aluno on 11/04/19.
 */
public class UpdateFuncionario extends PersistenciaJdbc {

    public boolean atualizaFuncionario(Long id, String nome, Long matricula) {
        boolean result = false;
        try {
            Funcionario cargo = new QueryFuncionario().queryById(id);
            if (Long.valueOf(cargo.getId()) != null) {
                preparaPersistencia();

                String sql = "UPDATE Funcionario SET matricula WHERE id = ?";
                PreparedStatement ps = connection.prepareStatement(sql);
                ps.setLong(1, id);
                ps.setLong(2, matricula);
                ps.executeUpdate();
                result = true;
                System.out.printf("Coluna 'matricula' atualizada com o valor %l", nome);
                ps.close();
            } else {
                System.out.printf("Funcionario com id %l não encontrado", id);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}
