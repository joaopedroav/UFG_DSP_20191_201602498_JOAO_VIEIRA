package br.com.jops425.dsp20191.aulas1316.ap.persistence.dml.insert;

import br.com.jops425.dsp20191.aulas1316.ap.models.Lotacao;
import br.com.jops425.dsp20191.aulas1316.ap.persistence.connection.PersistenciaJdbc;

public class InsertLotacao extends PersistenciaJdbc {

    public boolean persisteLotacao(Lotacao lotacao) throws Exception {

        preparaPersistencia();

        String sql = "INSERT INTO LOTACAO " +
                "VALUES(" + lotacao.getId() +
                "," + lotacao.getDataInicial() +
                "," + lotacao.getDataFinal() +
                "," + lotacao.getCargoId() +
                "," + lotacao.getDepartamentoId() +
                ")";

        stmt.executeUpdate(sql);
        System.out.println("A Lotação foi persistida corretamente.");
        stmt.close();
        connection.close();

        return true;
    }

}
