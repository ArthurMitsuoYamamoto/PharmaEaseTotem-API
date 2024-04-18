package br.com.fiap.PharmaEaseTotem.record;

import java.util.Random;

public record MedicamentoRecord(Long id, String nome, String sintomaRelacionado) {
        public MedicamentoRecord(Long id, String nome, String sintomaRelacionado){
       this.id  = (id == null)? Math.abs (new Random().nextLong()) : id;
       this.nome = nome;
       this.sintomaRelacionado = sintomaRelacionado;
        }
    }

