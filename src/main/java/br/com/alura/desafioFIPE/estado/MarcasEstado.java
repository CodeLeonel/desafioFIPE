package br.com.alura.desafioFIPE.estado;

import java.util.ArrayList;
import java.util.List;

import br.com.alura.desafioFIPE.modelo.Dados;

public class MarcasEstado {

	private static List<Dados> marcas = new ArrayList<>();
	
	public static void adiciona(List<Dados> lista) {
		
		if(!marcas.isEmpty()) {
			marcas.clear();
		} 
		
		marcas.addAll(lista);			
		
	}
	
	public static List<Dados> obterLista() {
		
		return marcas;
		
	}
	
}
