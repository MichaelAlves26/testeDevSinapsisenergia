package com.mike.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mike.entity.RedeMT;
import com.mike.repository.RedeMTRepository;

@RestController
@RequestMapping("/redemt")
@ResponseBody
public class RedeMTController{
	
	@Autowired
	RedeMTRepository redeMTRepository;
	
	@GetMapping
	public List<RedeMT> listarTodos(){
		return redeMTRepository.findAll();
	}
	
	@GetMapping("/{idRedeMt}")
	public ResponseEntity<RedeMT> acharRedeMTPorId(@PathVariable Long idRedeMt){
		return redeMTRepository.findById(idRedeMt).map(redeResposta -> ResponseEntity.ok().body(redeResposta)).
				orElse(ResponseEntity.notFound().build());
		
	
	}
	
	@PostMapping("/salvar")
	public ResponseEntity<?> salvarRede(@RequestBody RedeMT redeMT){
		try {
			RedeMT redeMtResposta = redeMTRepository.save(redeMT);
			
			if(redeMtResposta == null) {
				throw new Exception("Dados nÃ£o foram salvos");
			}
			return ResponseEntity.status(200).body(redeMtResposta);
			
		}catch(Exception ex){
			Map<String, String> mapa = new HashMap<String, String>();
			
			mapa.put("Erro", "Erro na gravacao" + ex.getMessage());
			
			return ResponseEntity.status(500).body(mapa);
			
		}
	}
	
	
	
	
	@DeleteMapping("/removerrede/{idRedeMt}")
	public void excluindoRede(@PathVariable Long idRedeMt) {
		
		redeMTRepository.deleteById(idRedeMt);
	}
	
	

	@PutMapping("/alterar")
	public RedeMT atualizarRede(@RequestBody RedeMT redeMT) {
		redeMTRepository.findById(redeMT.getIdRedeMT()).orElse(null);
	
		
		return redeMTRepository.save(redeMT);
		 
	}
	   
	

}
