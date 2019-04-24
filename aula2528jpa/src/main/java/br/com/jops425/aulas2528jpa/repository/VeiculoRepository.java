package br.com.jops425.aulas2528jpa.repository;

import br.com.jops425.aulas2528jpa.model.Veiculo;

import java.util.List;

/**
 * Created by aluno on 24/04/19.
 */
public interface VeiculoRepository {

    Veiculo create(Veiculo veiculo);

    Veiculo read(Long id);

    List<Veiculo> findByModelo(String modelo);

    Veiculo update(Veiculo veiculo);

    void delete(Veiculo veiculo);

    void close();

}
