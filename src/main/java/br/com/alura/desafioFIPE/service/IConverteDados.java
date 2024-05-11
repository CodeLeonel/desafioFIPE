package br.com.alura.desafioFIPE.service;

public interface IConverteDados {

	<T> T obterDados(String json, Class<T> classe);
	
}
