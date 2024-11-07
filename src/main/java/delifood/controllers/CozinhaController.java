package delifood.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import delifood.entities.Cozinha;
import delifood.exception.EntidadeEmUsoException;
import delifood.exception.EntidadeNaoEncontradaException;
import delifood.services.CozinhaService;

@RestController
@RequestMapping("/cozinhas")
public class CozinhaController {

	@Autowired
	private CozinhaService cozinhaService;

	@ResponseStatus(HttpStatus.OK)
	@GetMapping
	public List<Cozinha> listar() {
		List<Cozinha> cozinhas = cozinhaService.listar();
		return cozinhas;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Cozinha> buscar(@PathVariable Long id) {
		try {
			Cozinha cozinha = cozinhaService.buscarOuFalhar(id);
			return ResponseEntity.status(HttpStatus.OK).body(cozinha);
		} catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping
	public Cozinha adicionar(@RequestBody Cozinha cozinha) {
		cozinha = cozinhaService.salvar(cozinha);
		return cozinha;
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> remover(@PathVariable Long id) {
		try {
			Cozinha cozinha = cozinhaService.buscarOuFalhar(id);
			cozinhaService.remover(cozinha);
			return ResponseEntity.notFound().build();

		} catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.notFound().build();
		} catch (EntidadeEmUsoException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
	}

}
