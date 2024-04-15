package br.com.fiap.PharmaEaseTotem.repository;

import br.com.fiap.PharmaEaseTotem.model.Compra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Long> {
}
