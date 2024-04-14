package br.com.fiap.PharmaEaseTotem.controller;

import br.com.fiap.PharmaEaseTotem.model.Cliente;
import br.com.fiap.PharmaEaseTotem.service.ClienteService;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }

    // Endpoint para obter detalhes de um cliente por CPF
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> detalhesCliente(@PathVariable String cpf) {
        // Busca o cliente pelo CPF fornecido
        Cliente cliente = clienteService.buscarClientePorCpf(cpf);
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
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCliente(@PathVariable String cpf) {
        // Remove o cliente pelo CPF fornecido
        clienteService.deletarCliente(cpf);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
