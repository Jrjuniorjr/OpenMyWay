package br.unicap.c3.openmyway.openmyway.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.unicap.c3.openmyway.openmyway.services.AcessoService;

@RestController
@RequestMapping("/acesso")
public class AcessoController {

	@Autowired
	private AcessoService acessoSerive;
	
	@PostMapping("/solicitarAcesso")
	public ResponseEntity<String> acessar(@RequestParam("codigoIdentificacao") String codigoIdentificacao){
		return acessoSerive.acessar(codigoIdentificacao);
	}
}
