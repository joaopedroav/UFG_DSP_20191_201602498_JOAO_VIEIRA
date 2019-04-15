package br.com.jops425.dsp20191.aulas1720.ap.persistence.dml;

import br.com.jops425.dsp20191.aulas1720.ap.persistence.dml.delete.Delete;
import br.com.jops425.dsp20191.aulas1720.ap.persistence.dml.update.Update;

public class TestaOperacoes {

    public static void main(String[] args) {

        Update update = new Update();
        update.atualizaCargo(0L, "Roteirista");
        update.atualizaDepartamento(0L, "Departamento de Mitologia");
        update.atualizaFuncionario(0L, 201706897L);
        update.atualizaLotacao(0L, 1L);

        Delete delete = new Delete();
        delete.deletaLotacao(9L);
        delete.deletaCargo(2L);
        delete.deletaDepartamento(3L);
        delete.deletaFuncionario(9L);

        update.atualizaSalario(2L, 3500.00);
    }
}
