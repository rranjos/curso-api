package br.aula.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.aula.entidade.CadastroEntity;

@Service
public interface CadastroService {
	
	public List<CadastroEntity> listar ();
	public List<CadastroEntity> consultar(String telefone, String sexo, String endereco);
	public Boolean salvar(CadastroEntity entity);
	public String deletar(Integer id) throws Exception;
	public Boolean editar(CadastroEntity entidade);

}
