package br.com.fiap.PharmaEaseTotem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.HttpStatus.CREATED;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.fiap.PharmaEaseTotem.model.Consulta;
import br.com.fiap.PharmaEaseTotem.service.ConsultaService;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("consultas")
public class ConsultaController {

    @Autowired
    private ConsultaService consultaService;

    // Endpoint para listar todas as consultas
    @GetMapping
    public ResponseEntity<List<Consulta>> listarConsultas() {
        List<Consulta> consultas = consultaService.listarTodasConsultas();
        return new ResponseEntity<>(consultas, OK);
    }

    // Endpoint para obter detalhes de uma consulta por ID
    @GetMapping("/{id}")
    public ResponseEntity<Consulta> detalhesConsulta(@PathVariable Long id) {
        Consulta consulta = consultaService.buscarConsultaPorId(id);
        if (consulta != null) {
            return new ResponseEntity<>(consulta, OK);
        } else {
            return new ResponseEntity<>(NOT_FOUND);
        }
    }

    // Endpoint para cadastrar uma nova consulta
    @PostMapping
    public ResponseEntity<Consulta> cadastrarConsulta(@RequestBody @Valid Consulta consulta) {
        Consulta novaConsulta = consultaService.cadastrarConsulta(consulta);
        return new ResponseEntity<>(novaConsulta, CREATED);
    }

    // Endpoint para atualizar os dados de uma consulta
    @PutMapping("/{id}")
    public ResponseEntity<Consulta> atualizarConsulta(@PathVariable Long id, @RequestBody Consulta consultaAtualizada) {
        Consulta consulta = consultaService.atualizarConsulta(id, consultaAtualizada);
        if (consulta != null) {
            return new ResponseEntity<>(consulta, OK);
        } else {
            return new ResponseEntity<>(NOT_FOUND);
        }
    }

    // Endpoint para remover uma consulta
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarConsulta(@PathVariable Long id) {
        consultaService.deletarConsulta(id);
        return new ResponseEntity<>(NO_CONTENT);
    }
}
