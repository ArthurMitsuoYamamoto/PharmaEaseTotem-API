package br.com.fiap.PharmaEaseTotem.service;

import br.com.fiap.PharmaEaseTotem.model.Medicamento;
import br.com.fiap.PharmaEaseTotem.repository.MedicamentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicamentoService {

    private final MedicamentoRepository medicamentoRepository;

    public MedicamentoService(MedicamentoRepository medicamentoRepository) {
        this.medicamentoRepository = medicamentoRepository;
    }

    public List<Medicamento> listarTodosMedicamentos() {
        return medicamentoRepository.findAll();
    }

    public Optional<Medicamento> buscarMedicamentoPorId(Long id) {
        return medicamentoRepository.findById(id);
    }

    public Medicamento cadastrarMedicamento(Medicamento medicamento) {
        return medicamentoRepository.save(medicamento);
    }

    public void deletarMedicamento(Long id) {
        medicamentoRepository.deleteById(id);
    }

    public Medicamento atualizarMedicamento(Long id, Medicamento medicamentoAtualizado) {
        Optional<Medicamento> medicamentoExistente = medicamentoRepository.findById(id);
        if (medicamentoExistente.isPresent()) {
            // Obtém o medicamento existente do banco de dados
            Medicamento medicamento = medicamentoExistente.get();

            // Atualiza os campos do medicamento existente com os valores do medicamento atualizado
            medicamento.setNome(medicamentoAtualizado.getNome());
            medicamento.setSintomaRelacionado(medicamentoAtualizado.getSintomaRelacionado());

            // Salva o medicamento atualizado no banco de dados
            return medicamentoRepository.save(medicamento);
        } else {
            return null;
        }
    }
}
