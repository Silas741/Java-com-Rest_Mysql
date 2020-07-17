package com.example.demo.controller.resource;

import java.net.URI;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.example.demo.model.bean.Cidade;
import com.example.demo.model.repository.CidadeRepository;
@RestController
@RequestMapping("/Cidades")
public class CidadeResource {

	@Autowired
	private CidadeRepository CidadeRepo;
	
	@GetMapping ("/listaCidades")	
	public List <Cidade> todasCidades(){
		return CidadeRepo.findAll();
}
	
	@GetMapping("/{letra}")
	public List <Cidade> ListadoLetra (@PathVariable String letra){
		return CidadeRepo.nome(letra);
		
	}
	
	@GetMapping("/{latitude}/{longitude}")
	public Cidade LatitudeLongi (@PathVariable String latitude){
		return CidadeRepo.findBylatitude(latitude);
		
	 }
	
	
	
	@PostMapping ("/Cadastrar")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Cidade> salvar (@RequestBody Cidade cidade, HttpServletResponse response) {
	Cidade cidades = CidadeRepo.save(cidade);
		URI uri = ServletUriComponentsBuilder.fromCurrentServletMapping().path("/{id}").buildAndExpand(cidades.getid()).toUri();
		return ResponseEntity.created(uri).body(cidades);		
	}
	
}
