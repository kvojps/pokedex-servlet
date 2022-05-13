package com.br.pokedex.model;

import java.util.ArrayList;

import lombok.Data;

@Data
public class Pokedex {
	private Integer count;
	private String next;
	private String previous;
	private ArrayList<Pokemon> results;
}
