package br.com.fiap.PharmaEaseTotem.repository;

import br.com.fiap.PharmaEaseTotem.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    // Métodos personalizados, se necessário
}

