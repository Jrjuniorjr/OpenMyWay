package br.unicap.c3.openmyway.openmyway.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.unicap.c3.openmyway.openmyway.services.AcessoService;
import br.unicap.c3.openmyway.openmyway.dto.*;

@RestController
@RequestMapping("/acesso")
public class AcessoController {

	@Autowired
	private AcessoService acessoService;
	
	@PostMapping("/solicitarAcesso")
	public ResponseEntity<String> solicitarAcesso(@RequestParam("codigoIdentificacao") String codigoIdentificacao){
		return acessoService.solicitarAcesso(codigoIdentificacao);
	}
	
	@GetMapping("/gerarRelatorioAcessos")
	public ResponseEntity<List<AcessoDTO>> gerarRelatorioAcesso(){
		return acessoService.gerarRelatorioAcesso();
	}
	
	@PostMapping("/gerarRelatorioAcessosPorData")
	public ResponseEntity<List<AcessoDTO>> gerarRelatorioAcessoPorData(@RequestParam("data") String data){
		return acessoService.gerarRelatorioAcessoPorData(data);
	}
	
	
	
}
