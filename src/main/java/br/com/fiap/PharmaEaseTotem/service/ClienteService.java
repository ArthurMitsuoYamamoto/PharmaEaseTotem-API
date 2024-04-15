package br.com.fiap.PharmaEaseTotem.service;

import br.com.fiap.PharmaEaseTotem.model.Cliente;
import br.com.fiap.PharmaEaseTotem.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<Cliente> listarTodosClientes() {
        return clienteRepository.findAll();
    }

    public Cliente buscarClientePorId(Long id) {
        Optional<Cliente> clienteOptional = clienteRepository.findById(id);
        return clienteOptional.orElse(null);
    }
    

    public Cliente cadastrarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public void deletarCliente(Long id) {
        clienteRepository.deleteById(id);
    }

    public Cliente atualizarCliente(Long id, Cliente clienteAtualizado) {
        Optional<Cliente> clienteExistenteOptional = clienteRepository.findById(id);
        if (clienteExistenteOptional.isPresent()) {
            Cliente clienteExistente = clienteExistenteOptional.get();
            // Atualiza os campos do cliente existente com os valores do cliente atualizado
            clienteExistente.setNome(clienteAtualizado.getNome());
            clienteExistente.setCpf(clienteAtualizado.getCpf());
            // Salva o cliente atualizado no banco de dados
            return clienteRepository.save(clienteExistente);
        } else {
            return null;
        }
    }
    
    
}

