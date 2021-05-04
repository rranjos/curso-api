package br.aula.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	@GetMapping(value = "/consultar")
	public ResponseEntity<List<CadastroEntity>> consultar(
			@RequestParam("telefone") String telefone,
			@RequestParam("sexo") String sexo,
			@RequestParam("endereco") String endereco
			) {
		List<CadastroEntity> lst = service.consultar(telefone, sexo, endereco);
		return ResponseEntity.ok(lst);
	}
	
	@PostMapping(value = "/cadastrar")
	public ResponseEntity<Boolean> salvar(@RequestBody CadastroEntity entidade){
		Boolean salvo = service.salvar(entidade);
		return ResponseEntity.ok(salvo);
	}
	//se nao for possivel deletar, informar ao usuario `nao foi possivel deletar o registro selecionado`
	@DeleteMapping
	public ResponseEntity<String> deletar(@RequestParam("identificador") Integer id) throws Exception{
		
		String mensagem = service.deletar(id);
		return ResponseEntity.ok(mensagem);
	}
	
	@PatchMapping
	public ResponseEntity<Boolean> editar(@RequestBody CadastroEntity entidade){
		
		Boolean ehEditado = service.editar(entidade);
		
		return ResponseEntity.ok(ehEditado);
	}
	
	

}
