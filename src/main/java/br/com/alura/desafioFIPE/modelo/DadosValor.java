package br.com.alura.desafioFIPE.modelo;

import com.fasterxml.jackson.annotation.JsonAlias;

public record DadosValor(
		@JsonAlias("TipoVeiculo") Integer tipoVeiculo,
		@JsonAlias("Valor") String valor,
		@JsonAlias("Marca") String marca,
		@JsonAlias("Modelo") String modelo,
		@JsonAlias("AnoModelo") Integer anoModelo,
		@JsonAlias("Combustivel") String combustivel,
		@JsonAlias("CodigoFipe") String cofigoFipe,
		@JsonAlias("MesReferencia") String mesReferencia,
		@JsonAlias("SiglaCombustivel") String siglaCombustivel
		) {

}
