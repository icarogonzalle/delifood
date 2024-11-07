package delifood.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import delifood.entities.Estado;
import delifood.services.EstadoService;

@RestController
@RequestMapping("/estados")
public class EstadoController {

	@Autowired
	private EstadoService estadoService;

	
	@GetMapping
	public List<Estado> listar(){
		List<Estado> estados = estadoService.listar();
		return estados;
	}
}
