package br.com.jops425.aula2932jpa.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

/**
 * Created by aluno on 22/05/19.
 */
@Data
@NoArgsConstructor
@Entity
public class Sudito implements EntidadeBase {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "sudito_id")
    private Long id;

    private String nome;

    private String nacionalidade;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Moeda> moedas;

    @ManyToOne()
    private Monarca monarca;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

}
