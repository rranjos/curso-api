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
	
	// Todo imlementar regra que só permita deletar usuário que não são do perfil adm

	@Override
	public String deletar(Integer id) throws Exception {
		
		String mensagem = "";
		
		try {
			
			//Bloco com as operações em caso de normalidade ou o ideal a ser feito
			CadastroEntity entity = new CadastroEntity();
			entity.setId(id);
			
			//Recuperar o registro que será deletado
			Optional<CadastroEntity> resultado = cadastroRepository.findById(id);
			CadastroEntity e= resultado.get();
			
			//Verificar se o resgistro é do perfil adm. Se não for, permitir deletar. Caso seja emitir uma msg de não permitido
			
			if(!e.getPerfil().equals("adm") && !e.getAtivo()) {
				cadastroRepository.delete(entity);
			}
		} catch(Exception exeption) {
			// Bloco com as operações em caso de não conseguir executar o bloco principal
			throw new Exception("Erro ao tentar excluir o registro!");
			
		}
		
		return mensagem;
		/* um exemplo
		CadastroEntity entity = new CadastroEntity();
		entity.setId(id);
		
		//recuperar o registro que será deletado.
		Optional<CadastroEntity> resultado = cadastroRepository.findById(id);
		CadastroEntity e = resultado.get();
		
		//Verificar se o registro é do perfil adm. Se não for permitir deletar. Caso seja emitir mensagem de não permitido
		if(!e.getPerfil().equals("adm") && !e.getAtivo()) {
			cadastroRepository.delete(entity);
			
			mensagem = "O registro foi deletado com sucesso!";
			
		} else {
			
			mensagem = "Não foi possível deletar o registro selecionado!";
		}
		
		return mensagem;
		*/
	}
	
	@Override
	public Boolean editar(CadastroEntity entidade) {
		
		Optional<CadastroEntity> resultado = cadastroRepository.findById(entidade.getId());
		CadastroEntity e = resultado.get();
		
		//testar o e verificando se o perfil não é adm, caso seja tru executar o bloco abaixo.
		
		
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
