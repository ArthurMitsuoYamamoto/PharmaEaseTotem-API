package br.com.fiap.PharmaEaseTotem.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "medicamentos")
public class Medicamento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(name = "sintoma_relacionado")
    private String sintomaRelacionado;

    public Medicamento() {
    }

    public Medicamento(String nome, String sintomaRelacionado) {
        this.nome = nome;
        this.sintomaRelacionado = sintomaRelacionado;
    }

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

    public String getSintomaRelacionado() {
        return sintomaRelacionado;
    }

    public void setSintomaRelacionado(String sintomaRelacionado) {
        this.sintomaRelacionado = sintomaRelacionado;
    }
}
