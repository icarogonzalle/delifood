package delifood.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import delifood.entities.Cozinha;
import delifood.entities.Restaurante;
import delifood.exception.EntidadeEmUsoException;
import delifood.repository.RestauranteRepository;

@Service
public class RestauranteService {
	
	@Autowired
	private RestauranteRepository restauranteRepository;

	
	public List<Restaurante> listar(){
		List<Restaurante> restaurante = restauranteRepository.findAll();
		return restaurante;
	}
	
	@Transactional
	public Restaurante salvar(Restaurante restaurante) {
		restaurante = restauranteRepository.save(restaurante);
		return restaurante;
	}
	
	@Transactional
	public Restaurante remover(Long id) {
		try {
			restauranteRepository.deleteById(id);
			restauranteRepository.flush();
			
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException("Não existe um cadastro de restaurante com esse código");	
		}
		return null;
	}
}
