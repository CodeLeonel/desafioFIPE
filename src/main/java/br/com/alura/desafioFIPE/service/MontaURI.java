package br.com.alura.desafioFIPE.service;

import java.net.URI;

public class MontaURI {

	private final String API_URL = "https://parallelum.com.br/fipe/api/v1";
	
	private String marcaUrl = API_URL + "/%s/marcas";
	
	private String modelosUrl = marcaUrl + "/%s/modelos";
	
	private String anosUrl = modelosUrl + "/%s/anos";
	
	private String valorUrl = anosUrl + "/%s";
	
	
	public URI getMarcasURI(String veiculo) {
		
		String url = marcaUrl.formatted(veiculo);
		
		return getURI(url);
		
	}
	
	public URI getModelosURI(String veiculo, String marca) {
		
		String url = modelosUrl.formatted(veiculo,marca);
		
		return getURI(url);
		
	}
	
	public URI getAnosURI(String veiculo, String marca, String modelo) {
		
		String url = anosUrl.formatted(veiculo,marca,modelo);
		
		return getURI(url);
		
	}
	
	public URI getValorURI(String veiculo, String marca, String modelo, String ano) {
		
		String url = valorUrl.formatted(veiculo,marca,modelo,ano);
		
		return getURI(url);
		
	}
	
	private URI getURI(String url) {
		
		try {
			
			return URI.create(url);			
		
		}catch(Exception e) {
			
			throw new RuntimeException(e);
		
		}
		
	}
	
	
}
