package br.com.fiap.PharmaEaseTotem.repository;

import br.com.fiap.PharmaEaseTotem.model.Medicamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicamentoRepository extends JpaRepository<Medicamento, Long> {
    // Métodos personalizados, se necessário
}
