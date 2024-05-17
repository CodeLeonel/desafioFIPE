package br.com.alura.desafioFIPE.principal;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import br.com.alura.desafioFIPE.modelo.Dados;
import br.com.alura.desafioFIPE.modelo.DadosLiterais;
import br.com.alura.desafioFIPE.modelo.DadosValor;
import br.com.alura.desafioFIPE.modelo.Veiculo;
import br.com.alura.desafioFIPE.service.ManipulaAPI;

public class Principal {

	private Scanner leitura = new Scanner(System.in);

	private ManipulaAPI manipulaAPI = new ManipulaAPI();

	public void inicio() {

		var menu = """
				Veículos

				1 - carros
				2 - motos
				3 - caminhoes
				
				Digite uma das opções:""";

		System.out.print(menu);

		var opcao = leitura.nextInt();
		leitura.nextLine();
		
		String veiculo = null;
		
		switch (opcao) {

		case 1:
			veiculo = Veiculo.carros.toString();
			break;
		case 2:
			veiculo = Veiculo.motos.toString();
			break;
		case 3:
			veiculo = Veiculo.caminhoes.toString();
			break;
		default:
			throw new RuntimeException("Opção inválida");
		}
		
		var listaMarcas = manipulaAPI.buscaMarcas(veiculo);
		
		listaMarcas = listaMarcas.stream()
		.sorted(Comparator.comparing(Dados::codigo))
		.collect(Collectors.toList());
		
		listaMarcas.forEach(System.out::println);
		
		System.out.print("Escolha um dos códigos de marca: ");
		
		var codigoMarca = leitura.nextInt();
		leitura.nextLine();
		
		
		
		var optMarca = listaMarcas.stream().filter(m -> m.codigo().equals(codigoMarca)).findFirst();
		
		List<Dados> modelos = null;
		
		if(optMarca.isPresent()) {
			
			modelos = manipulaAPI.buscaModelos(optMarca.get());
		
			modelos.forEach(System.out::println);
			
		}
		
		System.out.print("Escolha um dos códigos de modelo: ");
		
		var codigoModelo = leitura.nextInt();
		leitura.nextLine();
		
		List<DadosLiterais> anos = null;
		
		if(!modelos.isEmpty()) {
			
			var optModelo = modelos.stream().filter(m -> m.codigo().equals(codigoModelo)).findFirst();
			
			if(optModelo.isPresent()) {
				
				anos = manipulaAPI.buscaAnos(optModelo.get());
				
				anos.forEach(System.out::println);
				
			}
			
		}
		
		List<DadosValor> valores = new ArrayList<>();
		
		if(!anos.isEmpty()) {
			
			for(var ano : anos) {
				
				var valor = manipulaAPI.buscaValor(ano);
				
				valores.add(valor);			
			}
			
			valores.forEach(System.out::println);
			
		}
		

	}

}
