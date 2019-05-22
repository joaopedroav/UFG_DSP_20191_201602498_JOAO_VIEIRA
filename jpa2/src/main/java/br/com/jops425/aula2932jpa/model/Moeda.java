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
public class Moeda implements EntidadeBase {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "moeda_id")
    private Long id;

    private String nome;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Sudito> suditos;

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

}
