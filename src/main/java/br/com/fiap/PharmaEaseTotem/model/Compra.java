package br.com.fiap.PharmaEaseTotem.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "compras")
public class Compra {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "id_cliente")
    @NotBlank(message = "compra.idCliente.notblank")
    private Long idCliente;

    @Column(name = "id_remedio")
    @NotBlank(message = "compra.idRemedio.notblank")
    private Long idRemedio;

    @Column(name = "data_compra")
    @NotBlank(message = "compra.dataCompra.notblank")
    private LocalDateTime dataCompra;

    public Compra() {
    }

    public Compra(Long id, Long idCliente, Long idRemedio, @NotBlank(message = "compra.dataCompra.notblank") LocalDateTime dataCompra) {
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

    public @NotBlank(message = "compra.dataCompra.notblank") LocalDateTime getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(@NotBlank(message = "compra.dataCompra.notblank") LocalDateTime dataCompra) {
        this.dataCompra = dataCompra;
    }
}
