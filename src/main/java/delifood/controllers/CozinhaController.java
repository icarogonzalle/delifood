package delifood.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import delifood.entities.Cozinha;
import delifood.services.CozinhaService;

@RestController
@RequestMapping("/cozinhas")
public class CozinhaController {

	@Autowired
	private CozinhaService cozinhaService;
	
	
	@GetMapping
	public List<Cozinha> listar(){
		List<Cozinha> cozinhas = cozinhaService.listar();
		return cozinhas;
	}
	
}
