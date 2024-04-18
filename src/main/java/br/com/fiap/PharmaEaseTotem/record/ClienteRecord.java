package br.com.fiap.PharmaEaseTotem.record;

import java.util.Random;

public record ClienteRecord(Long id, String cpf, String nome) {
        public ClienteRecord(Long id, String cpf,  String nome){
       this.id  = (id == null)? Math.abs (new Random().nextLong()) : id;
       this.cpf = cpf;
       this.nome = nome;
        }
    }

