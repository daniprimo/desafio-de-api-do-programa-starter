package gft.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import gft.entities.Atendimento;
import gft.exception.EntityNotFoundException;
import gft.repository.AtendimentoRepository;

@Service
public class AtendimentoService {

	private final AtendimentoRepository atendimentoRepository;

	public AtendimentoService(AtendimentoRepository atendimentoRepository) {
		this.atendimentoRepository = atendimentoRepository;
	}

	public Atendimento registrarOAtendimento(Atendimento atendimento) {
		try {
			return atendimentoRepository.save(atendimento);
		} catch (EntityNotFoundException e) {
			throw new EntityNotFoundException("Problema ao registrar atendimento");
		}
	}

	public List<Atendimento> listarTodosatendiemnto() {
		try {
			return atendimentoRepository.findAll();
		} catch (EntityNotFoundException e) {
			throw new EntityNotFoundException("Erro ao listar todos o atendimetno");
		}
	}

	public Atendimento buscarAtendimentoPeloId(Long id) {
		try {
			Optional<Atendimento> optional = atendimentoRepository.findById(id);
			return optional.orElseThrow(() -> new EntityNotFoundException("Atendimento não encontrado"));
		} catch (Exception e) {

			throw new EntityNotFoundException("Erro ao buscar atendiemnto");
		}
	}

	public Atendimento atualizarAtendimentoPeloId(Atendimento atendimento, Long id) {
		try {
			Atendimento original = buscarAtendimentoPeloId(id);
			atendimento.setId(original.getId());
			return atendimentoRepository.save(atendimento);
		} catch (EntityNotFoundException e) {
			throw new EntityNotFoundException("Erro ao buscar editar atendimento");
		}
	}

	public void excluirAtendimentoPorId(Long id) {
		try {
			Atendimento atendimento = buscarAtendimentoPeloId(id);
			atendimentoRepository.delete(atendimento);
		} catch (Exception e) {
			throw new EntityNotFoundException("Erro ao excluir atendimento");
		}
	}

}
