package br.unicap.c3.openmyway.openmyway.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.unicap.c3.openmyway.openmyway.services.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping("/cadastrar")
	public ResponseEntity<String> cadastrarUsuario(
			@RequestParam("cpf") String cpf, @RequestParam("codigoIdentificacao") String codigoIdentificacao){
		return usuarioService.cadastrarUsuario(cpf, codigoIdentificacao);
	}
	
	@PostMapping("/deletar")
	public ResponseEntity<String> deletarUsuario(@RequestParam("codigoIdentificacao") String codigoIdentificacao){
		return usuarioService.deletarUsuario(codigoIdentificacao);
	}
}
