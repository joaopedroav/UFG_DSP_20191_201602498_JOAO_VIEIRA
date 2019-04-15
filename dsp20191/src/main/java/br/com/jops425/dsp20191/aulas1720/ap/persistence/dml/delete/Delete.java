package br.com.jops425.dsp20191.aulas1720.ap.persistence.dml.delete;

import br.com.jops425.dsp20191.aulas1316.ap.models.Departamento;
import br.com.jops425.dsp20191.aulas1316.ap.models.Funcionario;
import br.com.jops425.dsp20191.aulas1316.ap.models.Lotacao;
import br.com.jops425.dsp20191.aulas1316.ap.persistence.connection.PersistenciaJdbc;
import br.com.jops425.dsp20191.aulas1316.ap.persistence.dml.query.QueryCargo;
import br.com.jops425.dsp20191.aulas1316.ap.models.Cargo;
import br.com.jops425.dsp20191.aulas1316.ap.persistence.dml.query.QueryDepartamento;
import br.com.jops425.dsp20191.aulas1316.ap.persistence.dml.query.QueryFuncionario;
import br.com.jops425.dsp20191.aulas1316.ap.persistence.dml.query.QueryLotacao;

import java.sql.PreparedStatement;

/**
 * Created by aluno on 11/04/19.
 */
public class Delete extends PersistenciaJdbc {

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
                System.out.printf("Cargo com id %ld não encontrado", id);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

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
                System.out.printf("Departamento com id %ld não encontrado", id);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

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
                System.out.printf("Funcionario com id %ld não encontrado", id);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean deletaLotacao(Long id) {
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
                System.out.printf("Lotação com id %ld não encontrado", id);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}
