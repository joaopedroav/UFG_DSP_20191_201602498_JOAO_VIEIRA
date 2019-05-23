package br.com.jops425.aula2932jpa;

import br.com.jops425.aula2932jpa.model.Moeda;
import br.com.jops425.aula2932jpa.model.Monarca;
import br.com.jops425.aula2932jpa.model.Reino;
import br.com.jops425.aula2932jpa.model.Sudito;
import br.com.jops425.aula2932jpa.persistencia.DaoGenerico;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aluno on 22/05/19.
 */
public class Main {

    public static void main(String[] args) {

        Monarca monarca = new Monarca();
        monarca.setNome("Anne Regina");
        monarca.setDinastia("Stuart");

        Reino reino = new Reino();
        reino.setMonarca(monarca);
        reino.setContinente("Europa");
        reino.setNome("Reino da Grã-Bretanha & Irlanda");

        monarca.setReino(reino);

        Sudito sudito = new Sudito();
        sudito.setNome("Sarah Churchill");
        sudito.setMonarca(monarca);
        Sudito sudito1 = new Sudito();
        sudito1.setNome("Abigail Masham");
        sudito1.setMonarca(monarca);
        Sudito sudito2 = new Sudito();
        sudito2.setNome("Mr. Spencer");
        sudito2.setMonarca(monarca);

        ArrayList<Sudito> suditos = new ArrayList<>();
        suditos.add(sudito);
        suditos.add(sudito1);
        suditos.add(sudito2);

        Moeda moeda = new Moeda();
        moeda.setNome("Ouro");
        moeda.setSuditos(suditos);
        Moeda moeda2 = new Moeda();
        moeda2.setNome("Prata");
        moeda2.setSuditos(suditos);

        ArrayList<Moeda> moedas = new ArrayList<>();
        moedas.add(moeda);
        moedas.add(moeda2);
        sudito.setMoedas(moedas);
        sudito1.setMoedas(moedas);
        sudito2.setMoedas(moedas);

        DaoGenerico<Monarca> daoMn = new DaoGenerico<>();
        DaoGenerico<Reino> daoR = new DaoGenerico<>();
        DaoGenerico<Sudito> daoS = new DaoGenerico<>();
        DaoGenerico<Moeda> daoMo = new DaoGenerico<>();

        daoMn.saveOrUpdate(monarca);
        daoR.saveOrUpdate(reino);
        daoS.saveOrUpdate(sudito);
        daoS.saveOrUpdate(sudito1);
        daoS.saveOrUpdate(sudito2);
        daoMo.saveOrUpdate(moeda);
        daoMo.saveOrUpdate(moeda2);
    }
}
