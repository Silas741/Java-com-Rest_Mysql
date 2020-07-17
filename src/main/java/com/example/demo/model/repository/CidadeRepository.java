package com.example.demo.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.bean.Cidade;

@Repository
public interface CidadeRepository  extends JpaRepository <Cidade, Long>{		
	public Cidade findBylongitude (String longitude);
	//public Cidade nome(long latitude, long longitude);
	public List<Cidade> nome(String letra);
	public Cidade findBylatitude (String latitude);
	
}
