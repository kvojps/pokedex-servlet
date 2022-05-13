package com.br.pokedex.services;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.br.pokedex.model.Pokedex;

@Service
public class PokedexServico {
	@Autowired
	RestTemplate template;

	public Pokedex getPokedex() {
		final String baseUrl = "https://pokeapi.co/api/v2/pokemon?offset=20&limit=20";
		URI uri;
		ResponseEntity<Pokedex> result = null;
		try {
			uri = new URI(baseUrl);
			HttpHeaders headers = new HttpHeaders();
			headers.set("X-COM-PERSIST", "true");  
			headers.set("X-COM-LOCATION", "USA");
			
			HttpEntity<Pokedex> requestEntity = new HttpEntity<>(null, headers);
			
			result = template.exchange(uri, HttpMethod.GET, requestEntity, Pokedex.class);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result.getBody();
		
	}
}
