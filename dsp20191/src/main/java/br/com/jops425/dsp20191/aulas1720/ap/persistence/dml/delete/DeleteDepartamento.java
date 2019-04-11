package br.com.jops425.dsp20191.aulas1720.ap.persistence.dml.delete;

import br.com.jops425.dsp20191.aulas1316.ap.persistence.connection.PersistenciaJdbc;
import br.com.jops425.dsp20191.aulas1316.ap.persistence.dml.query.QueryDepartamento;
import br.com.jops425.dsp20191.aulas1316.ap.models.Departamento;

import java.sql.PreparedStatement;

/**
 * Created by aluno on 11/04/19.
 */
public class DeleteDepartamento extends PersistenciaJdbc {

    public boolean deletaDepartamento(Long id) {
        boolean result = false;
        try {
            Departamento depto = new QueryDepartamento().querybyId(id);
            if (Long.valueOf(depto.getId()) != null) {
                preparaPersistencia();

                String sql = "DELETE FROM Departamento WHERE id = ?";
                PreparedStatement ps = connection.prepareStatement(sql);
                ps.setLong(1, id);
                ps.executeUpdate();
                result = true;
                System.out.println("Departamento excluído corretamente");
                ps.close();
            } else {
                System.out.printf("Departamento com id %l não encontrado", id);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}
