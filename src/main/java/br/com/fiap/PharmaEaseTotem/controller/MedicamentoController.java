package br.com.fiap.PharmaEaseTotem.controller;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.HttpStatus.OK;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.PharmaEaseTotem.model.Medicamento;
import br.com.fiap.PharmaEaseTotem.service.MedicamentoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("medicamentos")
public class MedicamentoController {

    @Autowired
    private MedicamentoService medicamentoService;

    // Endpoint para listar todos os medicamentos
    @GetMapping
    public ResponseEntity<List<Medicamento>> listarMedicamentos() {
        List<Medicamento> medicamentos = medicamentoService.listarTodosMedicamentos();
        return new ResponseEntity<>(medicamentos, OK);
    }

    // Endpoint para obter detalhes de um medicamento por ID
   @GetMapping("{id}")
   public ResponseEntity<Medicamento> detalhesMedicamento(@PathVariable Long id) {
       Optional<Medicamento> medicamento = medicamentoService.buscarMedicamentoPorId(id);
       if (medicamento.isPresent()) {
           return new ResponseEntity<>(medicamento.get(), OK);
       } else {
           return new ResponseEntity<>(NOT_FOUND);
       }
   }
   

    // Endpoint para cadastrar um novo medicamento
    @PostMapping
    public ResponseEntity<Medicamento> cadastrarMedicamento(@RequestBody @Valid Medicamento medicamento) {
        Medicamento novoMedicamento = medicamentoService.cadastrarMedicamento(medicamento);
        return new ResponseEntity<>(novoMedicamento, CREATED);
    }

    // Endpoint para atualizar os dados de um medicamento
    @PutMapping("{id}")
    public ResponseEntity<Medicamento> atualizarMedicamento(@PathVariable Long id, @RequestBody Medicamento medicamentoAtualizado) {
        Medicamento medicamento = medicamentoService.atualizarMedicamento(id, medicamentoAtualizado);
        if (medicamento != null) {
            return new ResponseEntity<>(medicamento, OK);
        } else {
            return new ResponseEntity<>(NOT_FOUND);
        }
    }

    // Endpoint para remover um medicamento
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deletarMedicamento(@PathVariable Long id) {
        medicamentoService.deletarMedicamento(id);
        return new ResponseEntity<>(NO_CONTENT);
    }
}
