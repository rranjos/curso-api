package br.aula.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_cadastro", schema = "public")
public class CadastroEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	public Integer id;
	
	@Column(name="nome")
	public String nome;
	
	@Column(name="endereco")
	public String endereco;
	
	@Column(name="telefone")
	public Long telefone;
	
	@Column(name="sexo")	
	public String sexo;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public Long getTelefone() {
		return telefone;
	}
	public void setTelefone(Long telefone) {
		this.telefone = telefone;
	}
	public String getSexo() {
	    return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
}