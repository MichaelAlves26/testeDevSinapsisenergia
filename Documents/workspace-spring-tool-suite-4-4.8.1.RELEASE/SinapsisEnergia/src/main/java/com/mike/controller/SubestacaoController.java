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

import com.mike.entity.Subestacao;
import com.mike.repository.SubestacaoRepository;


@RequestMapping("/subestacao")
@RestController
@ResponseBody

public class SubestacaoController {

	@Autowired
	SubestacaoRepository subestacaoRepository;

	@GetMapping
	public List<Subestacao> findAll() {

		return subestacaoRepository.findAll();
	}

	@GetMapping("/{idSubestacao}")
	public ResponseEntity<?> findById(@PathVariable Long idSubestacao) {
		Subestacao resposta = subestacaoRepository.findById(idSubestacao).get();

		try {
			if (resposta == null) {
				throw new Exception("O id não foi encontrado");
			} else {
				return ResponseEntity.status(200).body(resposta);
			}
		} catch (Exception ex) {
			Map<String, String> mapa = new HashMap<String, String>();
			mapa.put("error", "error na busca :" + ex.getMessage());
			return ResponseEntity.status(200).body(mapa);
		}
	}

	@PostMapping("/salvar")
	public ResponseEntity<?> cadastrarSubestacao(@RequestBody Subestacao subestacao) {
		try {
			Subestacao subestacaoResposta = subestacaoRepository.save(subestacao);

			if (subestacaoResposta == null) {
				throw new Exception("Dados nÃ£o foram salvos");
			}
			return ResponseEntity.status(200).body(subestacaoResposta);

		} catch (Exception ex) {
			Map<String, String> mapa = new HashMap<String, String>();

			mapa.put("Erro", "Erro na gravaÃ§Ã£o" + ex.getMessage());

			return ResponseEntity.status(500).body(mapa);

		}
	}

	@DeleteMapping("/deletar/{idSubestacao}")
	public void excluindoSub(@PathVariable Long idSubestacao) {

		subestacaoRepository.deleteById(idSubestacao);

	}

	@PutMapping("/alterar")
	public Subestacao atualizarSubestacao(@RequestBody Subestacao subestacao) {
		subestacaoRepository.findById(subestacao.getIdSubestacao()).orElse(null);

		return subestacaoRepository.save(subestacao);

	}

}
