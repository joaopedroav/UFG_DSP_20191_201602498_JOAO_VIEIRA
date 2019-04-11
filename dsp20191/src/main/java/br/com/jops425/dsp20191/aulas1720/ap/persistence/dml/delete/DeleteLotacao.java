package br.com.jops425.dsp20191.aulas1720.ap.persistence.dml.delete;

import br.com.jops425.dsp20191.aulas1316.ap.persistence.connection.PersistenciaJdbc;
import br.com.jops425.dsp20191.aulas1316.ap.persistence.dml.query.QueryLotacao;
import br.com.jops425.dsp20191.aulas1316.ap.models.Lotacao;

import java.sql.PreparedStatement;

/**
 * Created by aluno on 11/04/19.
 */
public class DeleteLotacao extends PersistenciaJdbc {

    public boolean deletaFuncionario(Long id) {
        boolean result = false;
        try {
            Lotacao depto = new QueryLotacao().queryById(id);
            if (Long.valueOf(depto.getId()) != null) {
                preparaPersistencia();

                String sql = "DELETE FROM Lotacao WHERE id = ?";
                PreparedStatement ps = connection.prepareStatement(sql);
                ps.setLong(1, id);
                ps.executeUpdate();
                result = true;
                System.out.println("Lotação excluída corretamente");
                ps.close();
            } else {
                System.out.printf("Lotação com id %l não encontrado", id);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}
