package br.com.alura.desafioFIPE.estado;

import java.util.ArrayList;
import java.util.List;

import br.com.alura.desafioFIPE.modelo.DadosLiterais;

public class AnosEstado {

	private static List<DadosLiterais> anos = new ArrayList<>();
	
	public static void adiciona(List<DadosLiterais> lista) {
		
		if(!anos.isEmpty()) {
			anos.clear();
		}
		
		anos.addAll(lista);
		
	}
	
	public static List<DadosLiterais> obterLista() {
		
		return anos;
		
	}
	
}
