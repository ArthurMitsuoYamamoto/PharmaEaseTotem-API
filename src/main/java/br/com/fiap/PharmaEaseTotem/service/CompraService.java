package br.com.fiap.PharmaEaseTotem.service;

import br.com.fiap.PharmaEaseTotem.model.Compra;
import br.com.fiap.PharmaEaseTotem.repository.CompraRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CompraService {

    private final CompraRepository compraRepository;

    public CompraService(CompraRepository compraRepository) {
        this.compraRepository = compraRepository;
    }

    public List<Compra> listarCompras() {
        return compraRepository.findAll();
    }

    public Optional<Compra> detalhesCompra(Long id) {
        return compraRepository.findById(id);
    }

    public Compra cadastrarCompra(Compra compra) {
        return compraRepository.save(compra);
    }

    public Optional<Compra> atualizarCompra(Long id, Compra compraAtualizada) {
        Optional<Compra> optionalCompra = compraRepository.findById(id);
        if (optionalCompra.isPresent()) {
            Compra compraExistente = optionalCompra.get();
            compraExistente.setIdCliente(compraAtualizada.getIdCliente());
            compraExistente.setIdRemedio(compraAtualizada.getIdRemedio());
            compraExistente.setDataCompra(compraAtualizada.getDataCompra());
            return Optional.of(compraRepository.save(compraExistente));
        } else {
            return Optional.empty();
        }
    }

    public boolean excluirCompra(Long id) {
        Optional<Compra> optionalCompra = compraRepository.findById(id);
        if (optionalCompra.isPresent()) {
            compraRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
