package br.aula.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.aula.entidade.CadastroEntity;
import br.aula.repository.CadastroRepository;
import br.aula.service.CadastroService;

@Service
public class CadastroServiceImpl implements CadastroService{
	
	@Autowired
	private CadastroRepository cadastroRepository;

	@Override
	public List<CadastroEntity> listar() {		
		return cadastroRepository.findAll();
	}
	
	@Override
	public List<CadastroEntity> consultar(String telefone,  String sexo, String endereco){
		
		if(telefone.equals("")) {
			telefone = "0";
		}
		return cadastroRepository.consultarCadastro(new Long(telefone), sexo, endereco);
	}
 
}
