package br.com.jops425.dsp20191.aulas1720.ap.persistence.dml;

import br.com.jops425.dsp20191.aulas1316.ap.models.Funcionario;
import br.com.jops425.dsp20191.aulas1316.ap.persistence.dml.query.QueryFuncionario;
import br.com.jops425.dsp20191.aulas1720.ap.persistence.dml.delete.Delete;
import br.com.jops425.dsp20191.aulas1720.ap.persistence.dml.query.Query;
import br.com.jops425.dsp20191.aulas1720.ap.persistence.dml.update.Update;

import java.util.ArrayList;

public class TestaOperacoes {

    public static void main(String[] args) throws Exception {

        Update update = new Update();
        update.atualizaCargo(0L, "Roteirista");
        update.atualizaDepartamento(0L, "Departamento de Mitologia");
        update.atualizaFuncionario(0L, 201706897L);
        update.atualizaLotacao(0L, 1L);

        update.atualizaSalario(0L, 3500.00);
        Query query = new Query();
        ArrayList<Funcionario> funcs = query.queryByIdCargo(2L);

        System.out.println("Nomes dos funcionários com salário atualizado: ");
        for(Funcionario fun : funcs) {
            System.out.println(fun.getNome());
        }

        Delete delete = new Delete();
        delete.deletaLotacao(9L);
        delete.deletaCargo(2L);
        delete.deletaDepartamento(3L);
        delete.deletaFuncionario(9L);
    }
}
