package br.aula;

import br.aula.entidade.CadastroEntity;

public class Teste {

	public static void main(String[] args) {
		
		CadastroEntity entidade = new CadastroEntity();
		entidade.setNome("Ricardo");
		
		System.out.println(entidade.getNome());

	}

}
