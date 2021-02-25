package br.aula.service.impl;

import java.util.List;

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

}
