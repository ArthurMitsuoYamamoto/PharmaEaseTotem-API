package br.com.fiap.PharmaEaseTotem.controller;

import br.com.fiap.PharmaEaseTotem.model.Cliente;
import br.com.fiap.PharmaEaseTotem.service.ClienteService;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.http.HttpStatus.OK;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    // Endpoint para listar todos os clientes
    @GetMapping
    public ResponseEntity<List<Cliente>> listarClientes() {
        List<Cliente> clientes = clienteService.listarTodosClientes();
        return new ResponseEntity<>(clientes, OK);
    }

    // Endpoint para obter detalhes de um cliente por ID
@GetMapping("{id}")
public ResponseEntity<Cliente> detalhesCliente(@PathVariable Long id) {
    // Busca o cliente pelo ID fornecido
    Cliente cliente = clienteService.buscarClientePorId(id);
    // Verifica se o cliente foi encontrado
    if (cliente != null) {
        return new ResponseEntity<>(cliente, HttpStatus.OK);
    } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

    // Endpoint para cadastrar um novo cliente
    @PostMapping
    public ResponseEntity<Cliente> cadastrarCliente(@RequestBody @Valid Cliente cliente) {
        // Cadastra o cliente e retorna o cliente cadastrado
        Cliente novoCliente = clienteService.cadastrarCliente(cliente);
        return new ResponseEntity<>(novoCliente, HttpStatus.CREATED);
    }

    // Endpoint para remover um cliente
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deletarCliente(@PathVariable Long id) {
        // Remove o cliente pelo CPF fornecido
        clienteService.deletarCliente(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Endpoint para atualizar um cliente existente
    @PutMapping("{id}")
    public ResponseEntity<Cliente> atualizarCliente(@PathVariable Long id, @RequestBody @Valid Cliente clienteAtualizado) {
        // Atualiza o cliente pelo ID fornecido
        Cliente cliente = clienteService.atualizarCliente(id, clienteAtualizado);
        // Verifica se o cliente foi atualizado com sucesso
        if (cliente != null) {
            return new ResponseEntity<>(cliente, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
