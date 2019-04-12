package br.com.jops425.dsp20191.aulas1720.ap.persistence.dml.update;

import br.com.jops425.dsp20191.aulas1316.ap.persistence.connection.PersistenciaJdbc;
import br.com.jops425.dsp20191.aulas1316.ap.persistence.dml.query.QueryDepartamento;
import br.com.jops425.dsp20191.aulas1316.ap.models.Departamento;

import java.sql.PreparedStatement;

/**
 * Created by aluno on 11/04/19.
 */
public class UpdateDepartamento extends PersistenciaJdbc {

    public boolean atualizaDepartamento(Long id, String nome) {
        boolean result = false;
        try {
            Departamento cargo = new QueryDepartamento().querybyId(id);
            if (Long.valueOf(cargo.getId()) != null) {
                preparaPersistencia();

                String sql = "UPDATE Departamento SET nome WHERE id = ?";
                PreparedStatement ps = connection.prepareStatement(sql);
                ps.setLong(1, id);
                ps.setString(2, nome);
                ps.executeUpdate();
                result = true;
                System.out.printf("Coluna 'nome' atualizada com o valor %d", nome);
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
