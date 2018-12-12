package br.unicap.c3.openmyway.openmyway.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.unicap.c3.openmyway.openmyway.services.AcessoService;
import br.unicap.c3.openmyway.openmyway.dto.*;

@RestController
@RequestMapping("/acesso")
public class AcessoController {

	@Autowired
	private AcessoService acessoService;
	
	@GetMapping("/solicitarAcessoEntrada")
	public HttpStatus solicitarAcessoEntrada(@PathVariable("codigoIdentificacao") String codigoIdentificacao){
		return acessoService.solicitarAcessoEntrada(codigoIdentificacao);
	}
	
	@GetMapping("/solicitarAcessoSaida")
	public HttpStatus solicitarAcessoSaida(@PathVariable("codigoIdentificacao") String codigoIdentificacao){
		return acessoService.solicitarAcessoSaida(codigoIdentificacao);
	}
	
	@GetMapping("/gerarRelatorioAcessos")
	public ResponseEntity<List<AcessoDTO>> gerarRelatorioAcesso(){
		return acessoService.gerarRelatorioAcesso();
	}
	
	@GetMapping("/gerarRelatorioAcessosPorData")
	public ResponseEntity<List<AcessoDTO>> gerarRelatorioAcessoPorData(@PathVariable String data){
		return acessoService.gerarRelatorioAcessoPorData(data);
	}
	
	
	
}
