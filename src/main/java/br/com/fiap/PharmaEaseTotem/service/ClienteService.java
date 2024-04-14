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

    public Cliente buscarClientePorCpf(String cpf) {
        Optional<Cliente> clienteOptional = clienteRepository.findById(cpf);
        return clienteOptional.orElse(null);
    }

    public Cliente cadastrarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public void deletarCliente(String cpf) {
        clienteRepository.deleteById(cpf);
    }

    public Cliente atualizarCliente(String cpf, Cliente clienteAtualizado) {
        Optional<Cliente> clienteExistente = clienteRepository.findById(cpf);
        if (clienteExistente.isPresent()) {
            Cliente clienteExistenteObj = clienteExistente.get();
            // Atualiza os campos do cliente existente com os valores do cliente atualizado
            clienteExistenteObj.setNome(clienteAtualizado.getNome());
            // Salva o cliente atualizado no banco de dados
            return clienteRepository.save(clienteExistenteObj);
        } else {
            return null;
        }
    }
}
