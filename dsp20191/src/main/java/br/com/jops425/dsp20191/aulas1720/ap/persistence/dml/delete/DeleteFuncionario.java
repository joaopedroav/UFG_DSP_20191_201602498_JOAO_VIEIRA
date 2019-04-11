package br.com.jops425.dsp20191.aulas1720.ap.persistence.dml.delete;

import br.com.jops425.dsp20191.aulas1316.ap.persistence.connection.PersistenciaJdbc;
import br.com.jops425.dsp20191.aulas1316.ap.persistence.dml.query.QueryFuncionario;
import br.com.jops425.dsp20191.aulas1316.ap.models.Funcionario;

import java.sql.PreparedStatement;

/**
 * Created by aluno on 11/04/19.
 */
public class DeleteFuncionario extends PersistenciaJdbc {

    public boolean deletaFuncionario(Long id) {
        boolean result = false;
        try {
            Funcionario depto = new QueryFuncionario().queryById(id);
            if (Long.valueOf(depto.getId()) != null) {
                preparaPersistencia();

                String sql = "DELETE FROM Funcionario WHERE id = ?";
                PreparedStatement ps = connection.prepareStatement(sql);
                ps.setLong(1, id);
                ps.executeUpdate();
                result = true;
                System.out.println("Funcionario excluído corretamente");
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
