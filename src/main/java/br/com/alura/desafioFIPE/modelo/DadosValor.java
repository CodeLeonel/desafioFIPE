package br.com.alura.desafioFIPE.modelo;

public record DadosValor(
		Integer tipoVeiculo,
		String valor,
		String marca,
		String modelo,
		Integer anoModelo,
		String combustivel,
		String cofigoFipe,
		String mesReferencia,
		String siglaCombustivel
		) {

}
