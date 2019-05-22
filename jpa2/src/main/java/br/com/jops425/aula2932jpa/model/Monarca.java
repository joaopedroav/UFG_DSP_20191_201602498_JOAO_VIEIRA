package br.com.jops425.aula2932jpa.model;

import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by aluno on 22/05/19.
 */

@Data
@NoArgsConstructor
@Entity
public class Monarca implements EntidadeBase {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "monarca_id")
    private Long id;

    private String nome;

    private String dinastia;

    @OneToOne(mappedBy = "monarca")
    private Reino reino;

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

    public String getDinastia() {
        return dinastia;
    }

    public void setDinastia(String dinastia) {
        this.dinastia = dinastia;
    }

}
