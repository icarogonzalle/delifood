package delifood.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import delifood.entities.Estado;
import delifood.repository.EstadoRepository;

@Service
public class EstadoService {

	@Autowired
	private EstadoRepository estadoRepository;
	
	public List<Estado> listar(){
		List<Estado> estados = estadoRepository.findAll();
		return estados;
	}
}
