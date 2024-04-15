package br.com.fiap.PharmaEaseTotem.controller;

import static org.springframework.http.HttpStatus.CREATED;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.PharmaEaseTotem.model.Compra;
import br.com.fiap.PharmaEaseTotem.repository.CompraRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/compras")
public class CompraController {

    private final CompraRepository compraRepository;

    public CompraController(CompraRepository compraRepository) {
        this.compraRepository = compraRepository;
    }

    @GetMapping
    public ResponseEntity<List<Compra>> listarCompras() {
        List<Compra> compras = compraRepository.findAll();
        return ResponseEntity.ok(compras);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Compra> detalhesCompra(@PathVariable Long id) {
        Optional<Compra> optionalCompra = compraRepository.findById(id);
        return optionalCompra.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Compra> cadastrarCompra(@RequestBody @Valid Compra compra) {
        Compra novaCompra = compraRepository.save(compra);
        return new ResponseEntity<>(novaCompra, CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Compra> atualizarCompra(@PathVariable Long id, @RequestBody @Valid Compra compraAtualizada) {
        Optional<Compra> optionalCompra = compraRepository.findById(id);
        if (optionalCompra.isPresent()) {
            Compra compraExistente = optionalCompra.get();
            compraExistente.setIdCliente(compraAtualizada.getIdCliente());
            compraExistente.setIdRemedio(compraAtualizada.getIdRemedio());
            compraExistente.setDataCompra(compraAtualizada.getDataCompra());
            compraRepository.save(compraExistente);
            return ResponseEntity.ok(compraExistente);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirCompra(@PathVariable Long id) {
        Optional<Compra> optionalCompra = compraRepository.findById(id);
        if (optionalCompra.isPresent()) {
            compraRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
