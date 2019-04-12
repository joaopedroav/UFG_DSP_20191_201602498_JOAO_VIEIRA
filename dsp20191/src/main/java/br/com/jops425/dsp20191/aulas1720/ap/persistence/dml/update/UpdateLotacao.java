package br.com.jops425.dsp20191.aulas1720.ap.persistence.dml.update;

import br.com.jops425.dsp20191.aulas1316.ap.persistence.connection.PersistenciaJdbc;
import br.com.jops425.dsp20191.aulas1316.ap.persistence.dml.query.QueryLotacao;
import br.com.jops425.dsp20191.aulas1316.ap.models.Lotacao;

import java.sql.PreparedStatement;

/**
 * Created by aluno on 11/04/19.
 */
public class UpdateLotacao extends PersistenciaJdbc {

    public boolean atualizaLotacao(Long id, String nome, Long idCargo) {
        boolean result = false;
        try {
            Lotacao cargo = new QueryLotacao().queryById(id);
            if (Long.valueOf(cargo.getId()) != null) {
                preparaPersistencia();

                String sql = "UPDATE Lotacao SET id_cargo WHERE id = ?";
                PreparedStatement ps = connection.prepareStatement(sql);
                ps.setLong(1, id);
                ps.setLong(2, idCargo);
                ps.executeUpdate();
                result = true;
                System.out.printf("Coluna 'id_cargo' atualizada com o valor %l", nome);
                ps.close();
            } else {
                System.out.printf("Lotação com id %l não encontrada", id);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
