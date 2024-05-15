package br.com.alura.desafioFIPE.principal;

import java.util.Scanner;

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
		
		listaMarcas.forEach(System.out::println);
		

	}

}
