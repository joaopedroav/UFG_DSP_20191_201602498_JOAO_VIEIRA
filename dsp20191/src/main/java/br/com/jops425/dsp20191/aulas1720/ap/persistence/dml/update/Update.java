package br.com.jops425.dsp20191.aulas1720.ap.persistence.dml.update;

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
public class Update extends PersistenciaJdbc {

    public boolean atualizaCargo(Long id, String nome) {
        boolean result = false;
        try {
            Cargo cargo = new QueryCargo().queryById(id);
            if (Long.valueOf(cargo.getId()) != null) {
                preparaPersistencia();

                String sql = "UPDATE Cargo SET nome WHERE id = ?";
                PreparedStatement ps = connection.prepareStatement(sql);
                ps.setLong(1, id);
                ps.setString(2, nome);
                ps.executeUpdate();
                result = true;
                System.out.printf("Coluna 'nome' atualizada com o valor %d", nome);
                ps.close();
            } else {
                System.out.printf("Cargo com id %l não encontrado", id);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

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
