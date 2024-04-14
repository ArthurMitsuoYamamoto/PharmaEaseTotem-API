package br.com.fiap.PharmaEaseTotem.service;

import br.com.fiap.PharmaEaseTotem.model.Consulta;
import br.com.fiap.PharmaEaseTotem.repository.ConsultaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConsultaService {

    private final ConsultaRepository consultaRepository;

    public ConsultaService(ConsultaRepository consultaRepository) {
        this.consultaRepository = consultaRepository;
    }

    public List<Consulta> listarTodasConsultas() {
        return consultaRepository.findAll();
    }

    public Consulta buscarConsultaPorId(Long id) {
        Optional<Consulta> consultaOptional = consultaRepository.findById(id);
        return consultaOptional.orElse(null);
    }

    public Consulta cadastrarConsulta(Consulta consulta) {
        return consultaRepository.save(consulta);
    }

    public void deletarConsulta(Long id) {
        consultaRepository.deleteById(id);
    }

    public Consulta atualizarConsulta(Long id, Consulta consultaAtualizada) {
        Optional<Consulta> consultaExistente = consultaRepository.findById(id);
        if (consultaExistente.isPresent()) {
            Consulta consultaExistenteObj = consultaExistente.get();
            // Atualiza os campos da consulta existente com os valores da consulta atualizada
            consultaExistenteObj.setCliente(consultaAtualizada.getCliente());
            consultaExistenteObj.setDataHora(consultaAtualizada.getDataHora());
            consultaExistenteObj.setSintoma(consultaAtualizada.getSintoma());
            consultaExistenteObj.setNivelSatisfacao(consultaAtualizada.getNivelSatisfacao());
            // Salva a consulta atualizada no banco de dados
            return consultaRepository.save(consultaExistenteObj);
        } else {
            return null;
        }
    }
}
