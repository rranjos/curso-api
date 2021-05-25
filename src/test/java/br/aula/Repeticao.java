package br.aula;

import javax.swing.JOptionPane;

public class Repeticao {
	
	
	public static void main(String[] args) {
		
		int contador = 1;
		
		while (contador <= 5 ) {
			System.out.println("OLÁ");
			contador++;
		}
		
		for (int i = 0 ; i <= 10 ; i++ ) {
			System.out.println("OLÁ");
		}
		
		String[] nomes = new String[] {"Joao", "Maria", "Pedro", "Junior"};
		
		for(int i = 0 ; i < nomes.length ; i++) {
			
			System.out.println( nomes[i]) ;	
			
		}
		
		//FORMA DINÂMICA
		String qtdDependentes = JOptionPane.showInputDialog("Digite a quantidade de dependentes", null);
		Integer qtdDependentesInt = Integer.parseInt(qtdDependentes);
		String[] nomesDinamicos = new String[qtdDependentesInt];

		for (int i = 0; i < qtdDependentesInt.intValue(); i++) {

			String nome = JOptionPane.showInputDialog("Digite o nome do: " + i, null);
			nomesDinamicos[i] = nome;

		}

		for (int i = 0; i < nomesDinamicos.length; i++) {

			System.out.println(nomesDinamicos[i]);

		}
		
		
		
	}
	

}
