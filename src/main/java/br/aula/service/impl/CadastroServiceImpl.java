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
		return cadastroRepository.findByTelefoneOrSexoIgnoreCaseOrEndereco(new Long(telefone), sexo, endereco);
	}

	@Override
	public Boolean salvar(CadastroEntity entity) {
		
		Boolean resposta = false;
		
		
			
			cadastroRepository.save(entity);
			resposta = true;
			
		

		
		return resposta;
	}

	@Override
	public Boolean deletar(Integer id) {
		CadastroEntity entity = new CadastroEntity();
		entity.setId(id);
		
		cadastroRepository.delete(entity);
		
		return true;
	}
	
	@Override
	public Boolean editar(CadastroEntity entidade) {
		Optional<CadastroEntity> resultado = cadastroRepository.findById(entidade.getId());
		CadastroEntity e = resultado.get();
		
		if(entidade.getNome() != null) {
			e.setNome(entidade.getNome());
		}
		
		if(entidade.getEndereco() != null) {
			e.setEndereco(entidade.getEndereco());
		}
		
		if(entidade.getSexo() != null) {
			e.setSexo(entidade.getSexo());
		}
		
		if(entidade.getTelefone() != null) {
			e.setTelefone(entidade.getTelefone());
		}
			
		cadastroRepository.save(e);
		return true;
	}
 
}
