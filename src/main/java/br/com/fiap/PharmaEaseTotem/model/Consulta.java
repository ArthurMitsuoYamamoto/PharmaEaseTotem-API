package br.com.fiap.PharmaEaseTotem.model;

import java.time.LocalDateTime;

import org.hibernate.validator.constraints.Range;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "consultas")
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cliente_cpf", referencedColumnName = "cpf")
    private Cliente cliente;

    @Column(nullable = false)
    private LocalDateTime dataHora;

    @Column(nullable = false)
    private String sintoma;

    @Column(nullable = false)
    @Range(min = 0, max = 5)
    private int nivelSatisfacao;

    public Consulta() {
    }

    public Consulta(Cliente cliente, LocalDateTime dataHora, String sintoma, int nivelSatisfacao) {
        this.cliente = cliente;
        this.dataHora = dataHora;
        this.sintoma = sintoma;
        this.nivelSatisfacao = nivelSatisfacao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public String getSintoma() {
        return sintoma;
    }

    public void setSintoma(String sintoma) {
        this.sintoma = sintoma;
    }

    public int getNivelSatisfacao() {
        return nivelSatisfacao;
    }

    public void setNivelSatisfacao(int nivelSatisfacao) {
        this.nivelSatisfacao = nivelSatisfacao;
    }
}

