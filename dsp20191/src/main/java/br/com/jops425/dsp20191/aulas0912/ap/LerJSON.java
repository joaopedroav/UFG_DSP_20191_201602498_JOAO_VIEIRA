package br.com.jops425.dsp20191.aulas0912.ap;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * Created by aluno on 28/03/19.
 */
public class LerJSON {

    public static void main(String[] args) throws FileNotFoundException {
        final String caminho = "src/main/resources/students.json";
        ler(caminho);
    }

    public static void ler(final String caminho) throws FileNotFoundException {
        Gson gson = new Gson();
        BufferedReader br = new BufferedReader(new FileReader(caminho));
        Students students = gson.fromJson(br, Students.class);
    }
}
