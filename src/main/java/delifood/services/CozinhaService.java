package delifood.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import delifood.entities.Cozinha;
import delifood.exception.EntidadeEmUsoException;
import delifood.exception.EntidadeNaoEncontradaException;
import delifood.repository.CozinhaRepository;

@Service
public class CozinhaService {

	@Autowired
	private CozinhaRepository cozinhaRepository;

	public List<Cozinha> listar() {
		List<Cozinha> cozinhas = cozinhaRepository.findAll();
		return cozinhas;
	}

	public Cozinha buscarOuFalhar(Long id) {
		return cozinhaRepository.findById(id).orElseThrow(() -> new EntidadeNaoEncontradaException(
				String.format("Não existe um cadastro de cozinha de código %d.", id)));
	}

	@Transactional
	public Cozinha salvar(Cozinha cozinha) {
		cozinha = cozinhaRepository.save(cozinha);
		return cozinha;
	}

	@Transactional
	public void remover(Cozinha cozinha) {
		try {
			cozinhaRepository.delete(cozinha);
			cozinhaRepository.flush();
			
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
					String.format("Não existe um cadastro de cozinha de código %d.", cozinha.getId()));
		}
	}

}
