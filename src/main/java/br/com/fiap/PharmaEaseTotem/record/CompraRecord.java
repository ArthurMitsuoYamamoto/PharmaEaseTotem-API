package br.com.fiap.PharmaEaseTotem.record;

import java.time.LocalDateTime;
import java.util.Random;

public record CompraRecord(Long id, Long idCliente, Long idRemedio,  LocalDateTime dataCompra) {
        public CompraRecord(Long id, Long idCliente, Long idRemedio,  LocalDateTime dataCompra){
       this.id  = (id == null)? Math.abs (new Random().nextLong()) : id;
       this.idCliente = idCliente;
       this.idRemedio = idRemedio;
       this.dataCompra = dataCompra;
        }
    }
