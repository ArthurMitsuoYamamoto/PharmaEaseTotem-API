package br.com.fiap.PharmaEaseTotem.repository;

import br.com.fiap.PharmaEaseTotem.model.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
    // Métodos personalizados, se necessário
}

