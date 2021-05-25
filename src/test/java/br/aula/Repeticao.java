package br.aula;

public class Repeticao {
	
	
	public static void main(String[] args) {
		
		int contador = 1;
		
		while (contador <= 5 ) {
			//System.out.println("OLÁ");
			contador++;
		}
		
		for (int i = 0 ; i <= 10 ; i++ ) {
			//System.out.println("OLÁ");
		}
		
		String[] nomes = new String[] {"Joao", "Maria", "Pedro", "Junior"};
		
		for(int i = 0 ; i < nomes.length ; i++) {
			
			System.out.println( nomes[i]) ;	
			
		}
		
		
		
	}
	

}
