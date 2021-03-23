package br.aula.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.aula.entidade.CadastroEntity;
import br.aula.service.CadastroService;

@RestController
@RequestMapping({ "/cadastro" })
@CrossOrigin(origins = "*")
public class CadastroController {

	@Autowired
	CadastroService service;

	@GetMapping(value = "/listar")
	public ResponseEntity<List<CadastroEntity>> listar() {
		List<CadastroEntity> lst = service.listar();
		return ResponseEntity.ok(lst);
	}

	// TODO Mudar o parametro para telefone
	@GetMapping(value = "/consultar")
	public ResponseEntity<List<CadastroEntity>> consultar(
			@RequestParam("telefone") String telefone,
			@RequestParam("sexo") String sexo,
			@RequestParam("endereco") String endereco
			) {
		List<CadastroEntity> lst = service.consultar(telefone, sexo, endereco);
		return ResponseEntity.ok(lst);
	}

}
