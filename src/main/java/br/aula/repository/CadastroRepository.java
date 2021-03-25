package br.aula.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.aula.entidade.CadastroEntity;

@Repository
public interface CadastroRepository extends JpaRepository<CadastroEntity, Integer> {

	@Query(value = "select c from CadastroEntity c where telefone = :tel or sexo = :sexo or endereco = :endereco ")
	List<CadastroEntity> consultarCadastro(
			@Param("tel") Long telefone, 
			@Param("sexo") String sexo,
			@Param("endereco") String endereco);

}
