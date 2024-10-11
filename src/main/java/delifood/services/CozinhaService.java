package delifood.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import delifood.entities.Cozinha;
import delifood.repository.CozinhaRepository;

@Service
public class CozinhaService {

	@Autowired
	private CozinhaRepository cozinhaRepository;
	
	
	public List<Cozinha> listar(){
		List<Cozinha> cozinhas = cozinhaRepository.findAll();
		return cozinhas;
	}


}
