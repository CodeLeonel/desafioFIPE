package br.com.alura.desafioFIPE.modelo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public record Modelos(List<Dados> modelos) {

}
