package br.aula.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.aula.entidade.CadastroEntity;

@Repository
public interface CadastroRepository extends JpaRepository<CadastroEntity, Integer>{

	List<CadastroEntity> findByTelefoneOrSexoIgnoreCaseOrEndereco(Long telefone, String sexo, String endereco);

}
