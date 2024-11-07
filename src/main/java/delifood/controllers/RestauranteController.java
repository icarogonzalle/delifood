package delifood.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import delifood.entities.Cozinha;
import delifood.entities.Restaurante;
import delifood.exception.EntidadeEmUsoException;
import delifood.exception.EntidadeNaoEncontradaException;
import delifood.services.RestauranteService;

@RestController
@RequestMapping("/restaurantes")
public class RestauranteController {

	@Autowired
	private RestauranteService restauranteService;
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping
	public Restaurante salvar(@RequestBody Restaurante restaurante) {
		restaurante = restauranteService.salvar(restaurante);
		return restaurante;
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> remover(@PathVariable Long id) {
		try {
			Restaurante restaurante = restauranteService.remover(id);
			restauranteService.remover(id);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

		} catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		} catch (EntidadeEmUsoException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
	}
	
}
