package br.com.jops425.aulas2528jpa.main;

import br.com.jops425.aulas2528jpa.model.Veiculo;

import br.com.jops425.aulas2528jpa.repository.VeiculoRepository;
import br.com.jops425.aulas2528jpa.repository.VeiculoRepositoryImpl;
import org.h2.tools.Server;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by aluno on 24/04/19.
 */
public class Main {

    private static Server server = null;
    private static VeiculoRepository veiculoRepository;

    public static void main(String[] args) throws SQLException {
        String modelo = "Ferrari", marca = "Hyundai";
        Long id = 123L, id2 = 100L;
        server = Server.createTcpServer().start();
        veiculoRepository = new VeiculoRepositoryImpl();
        createVeiculo(veiculoRepository);
        readVeiculo(veiculoRepository, modelo);
        uptateVeiculo(veiculoRepository, id, marca);
        deleteVeiculo(veiculoRepository, id2);
    }

    public static void createVeiculo(VeiculoRepository vr) {
        Veiculo veiculo = new Veiculo();
        veiculo.setId(123L);
        veiculo.setAnoFabricacao(2018);
        veiculo.setModelo("New QQ 2019");
        veiculo.setAnoModelo(2019);
        veiculo.setMarca("Chery");
        veiculo.setPotenciaMotor(5000);
        veiculo = vr.create(veiculo);
        System.out.println("Veículo adicionado.");
    }

    public static void uptateVeiculo(VeiculoRepository vr, Long id, String marca) {
        Veiculo veiculo = vr.read(id);
        if (veiculo != null) {
            veiculo.setMarca(marca);
            vr.update(veiculo);
            System.out.println("Veículo alterado para marca " + marca);
        } else {
            System.out.println("Veículo não encontrado.");
        }
    }

    public static void readVeiculo(VeiculoRepository vr, String modelo) {
        List<Veiculo> veiculos = vr.findByModelo(modelo);

        if (veiculos != null) {
            System.out.println("Veículos de modelo " + modelo);
            for (Veiculo vcs : veiculos) {
                System.out.println("Marca: " + vcs.getMarca());
                System.out.printf("Ano de fabricação: " + vcs.getAnoFabricacao());
                System.out.printf("Ano do modelo: " + vcs.getAnoModelo());
                System.out.println("Potência do motor: " + vcs.getPotenciaMotor() + " cv");
            }
        } else {
            System.out.println("Nenhum veículo encontrado.");
        }

    }

    public static void deleteVeiculo(VeiculoRepository vr, Long id) {
        Veiculo veiculo = vr.read(id);
        if (veiculo != null) {
            vr.delete(veiculo);
            System.out.println("Veículo deletado.");
        } else {
            System.out.println("Veículo não encontrado.");
        }
    }
}
