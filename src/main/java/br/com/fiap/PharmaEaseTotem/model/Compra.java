package br.com.fiap.PharmaEaseTotem.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "compras")
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "id_cliente")
    private Long idCliente;

    @Column(name = "id_remedio")
    private Long idRemedio;

    @Column(name = "data_compra")
    private LocalDateTime dataCompra;

    public Compra() {
    }

    public Compra(Long id, Long idCliente, Long idRemedio,  LocalDateTime dataCompra) {
        this.id = id;
        this.idCliente = idCliente;
        this.idRemedio = idRemedio;
        this.dataCompra = dataCompra;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public Long getIdRemedio() {
        return idRemedio;
    }

    public void setIdRemedio(Long idRemedio) {
        this.idRemedio = idRemedio;
    }

    public LocalDateTime getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(LocalDateTime dataCompra) {
        this.dataCompra = dataCompra;
    }
    
}
