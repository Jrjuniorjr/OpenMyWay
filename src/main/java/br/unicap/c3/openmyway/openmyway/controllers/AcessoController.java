package br.unicap.c3.openmyway.openmyway.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.unicap.c3.openmyway.openmyway.services.AcessoService;
import br.unicap.c3.openmyway.openmyway.model.Acesso;

@RestController
@RequestMapping("/acesso")
@CrossOrigin
public class AcessoController {

	@Autowired
	private AcessoService acessoService;
	
	@GetMapping("/solicitarAcessoEntrada/{codigoIdentificacao}")
	public ResponseEntity<?> solicitarAcessoEntrada(@PathVariable("codigoIdentificacao") String codigoIdentificacao){
		
		return acessoService.solicitarAcessoEntrada(codigoIdentificacao);
	
	}
	
	@GetMapping("/solicitarAcessoSaida/{codigoIdentificacao}")
	public ResponseEntity<?> solicitarAcessoSaida(@PathVariable("codigoIdentificacao") String codigoIdentificacao){
	
		return acessoService.solicitarAcessoSaida(codigoIdentificacao);
	
	}
	
	@GetMapping("/gerarRelatorioAcessos")
	public ResponseEntity<List<Acesso>> gerarRelatorioAcesso(){
	
		return acessoService.gerarRelatorioAcesso();
	
	}
	
	@GetMapping("/gerarRelatorioAcessosPorData/{data}")
	public ResponseEntity<?> gerarRelatorioAcessoPorData(@PathVariable("data") String data){
	
		return acessoService.gerarRelatorioAcessoPorData(data);
	
	}
	
	@GetMapping("/gerarRelatorioAcessosPorDataEHora/{data}/{hora}")
	public ResponseEntity<?> gerarRelatorioAcessoPorDataEHora(@PathVariable("data") String data,
			@PathVariable("hora") String hora){
	
		return acessoService.gerarRelatorioAcessosPorDataEHora(data, hora);
	
	}
	
	
}
