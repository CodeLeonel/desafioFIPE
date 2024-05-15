package br.com.alura.desafioFIPE.service;

import java.util.List;

import br.com.alura.desafioFIPE.estado.AnosEstado;
import br.com.alura.desafioFIPE.estado.MarcasEstado;
import br.com.alura.desafioFIPE.estado.ModelosEstado;
import br.com.alura.desafioFIPE.modelo.Dados;
import br.com.alura.desafioFIPE.modelo.DadosLiterais;
import br.com.alura.desafioFIPE.modelo.DadosValor;
import br.com.alura.desafioFIPE.modelo.Modelos;

public class ManipulaAPI {

	private String veiculo;
	
	private Dados marca;

	private Dados modelo;

	private DadosLiterais ano;

	private DadosValor valor;
	
	private MontaURI montaUri = new MontaURI();
	
	private ConsumoAPI consumoAPI = new ConsumoAPI();
	
	private ConverteDados converte = new ConverteDados();

	public List<Dados> buscaMarcas(String veiculo) {
		
		this.setVeiculo(veiculo);
		
		var listaDados = converte.obterLista(consumoAPI.obterDados(montaUri.getMarcasURI(veiculo)), Dados.class); 
		
		MarcasEstado.adiciona(listaDados);
		
		return listaDados;
		
	}
	
	public List<Dados> buscaModelos(Dados marca) {
		
		this.setMarca(marca);
		
		var dadosModelos = converte.obterDados(consumoAPI.obterDados(montaUri.getModelosURI(veiculo, marca.codigo().toString())), Modelos.class);
		
		var listaModelos = dadosModelos.modelos();
		
		ModelosEstado.adiciona(listaModelos);
		
		return listaModelos;
		
	}
	
	public List<DadosLiterais> buscaAnos(Dados modelo) {
		
		this.setModelo(modelo);
		
		var dadosAnos = converte.obterLista(consumoAPI.obterDados(montaUri.getAnosURI(veiculo, marca.codigo().toString(),modelo.codigo().toString())), DadosLiterais.class);
		
		AnosEstado.adiciona(dadosAnos);
		
		return dadosAnos;
		
	}
	
	public DadosValor buscaValor(DadosLiterais ano) {
	
		this.setAno(ano);
		
		var dadosValor = converte.obterDados(consumoAPI.obterDados(
				montaUri.getValorURI(veiculo, marca.codigo().toString(),modelo.codigo().toString(),ano.codigo())), 
				DadosValor.class);
		
		this.setValor(dadosValor);
		
		return dadosValor;
		
	}
	
	
	
	public String getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(String veiculo) {
		this.veiculo = veiculo;
	}

	public Dados getMarca() {
		return marca;
	}

	public void setMarca(Dados marca) {
		this.marca = marca;
	}

	public Dados getModelo() {
		return modelo;
	}

	public void setModelo(Dados modelo) {
		this.modelo = modelo;
	}

	public DadosLiterais getAno() {
		return ano;
	}

	public void setAno(DadosLiterais ano) {
		this.ano = ano;
	}

	public DadosValor getValor() {
		return valor;
	}

	public void setValor(DadosValor valor) {
		this.valor = valor;
	}
	
	
}
