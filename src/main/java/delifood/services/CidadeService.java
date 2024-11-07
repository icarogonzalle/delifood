package delifood.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import delifood.entities.Cidade;
import delifood.repository.CidadeRepository;

@Service
public class CidadeService {

	@Autowired
	private CidadeRepository cidadeRepository;
	
	public List<Cidade> listar(){
		List<Cidade> cidades = cidadeRepository.findAll();
		return cidades;
	}
}
