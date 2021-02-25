package br.aula.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.aula.entidade.CadastroEntity;

@Repository
public interface CadastroRepository extends JpaRepository<CadastroEntity, Integer>{

}
