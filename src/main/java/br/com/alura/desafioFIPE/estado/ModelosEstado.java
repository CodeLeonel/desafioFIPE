package br.com.alura.desafioFIPE.estado;

import java.util.ArrayList;
import java.util.List;

import br.com.alura.desafioFIPE.modelo.Dados;

public class ModelosEstado {

	private static List<Dados> modelos = new ArrayList<>();
	
	public static void adiciona(List<Dados> lista) {
		
		if(!modelos.isEmpty()) {
			modelos.clear();
		}
		
		modelos.addAll(lista);
		
	}
	
	public static List<Dados> obterLista() {
		
		return modelos;
		
	}
	
}
