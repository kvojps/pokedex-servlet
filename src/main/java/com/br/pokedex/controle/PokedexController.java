package com.br.pokedex.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.pokedex.model.Pokedex;
import com.br.pokedex.services.PokedexServico;

@RestController
@RequestMapping("/pokedex")
public class PokedexController {
	@Autowired
	PokedexServico servico;
	
	@GetMapping
	Pokedex getPokedex() {
		return servico.getPokedex();
	}
}
