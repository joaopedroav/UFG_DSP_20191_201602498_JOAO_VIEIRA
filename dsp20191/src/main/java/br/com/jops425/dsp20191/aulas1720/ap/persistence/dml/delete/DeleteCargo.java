package br.com.jops425.dsp20191.aulas1720.ap.persistence.dml.delete;

import br.com.jops425.dsp20191.aulas1316.ap.persistence.connection.PersistenciaJdbc;
import br.com.jops425.dsp20191.aulas1316.ap.persistence.dml.query.QueryCargo;
import br.com.jops425.dsp20191.aulas1316.ap.models.Cargo;

import java.sql.PreparedStatement;

/**
 * Created by aluno on 11/04/19.
 */
public class DeleteCargo extends PersistenciaJdbc {

    public boolean deletaCargo(Long id) {
        boolean result = false;
        try {
            Cargo cargo = new QueryCargo().queryById(id);
            if (Long.valueOf(cargo.getId()) != null) {
                preparaPersistencia();

                String sql = "DELETE FROM Cargo WHERE id = ?";
                PreparedStatement ps = connection.prepareStatement(sql);
                ps.setLong(1, id);
                ps.executeUpdate();
                result = true;
                System.out.println("Cargo excluído corretamente");
                ps.close();
            } else {
                System.out.printf("Cargo com id %l não encontrado", id);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}
