package br.unicap.c3.openmyway.openmyway.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.unicap.c3.openmyway.openmyway.model.Usuario;
import br.unicap.c3.openmyway.openmyway.services.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping("/cadastrar")
	public ResponseEntity<String> cadastrarUsuario(
			@RequestParam("cpf") String cpf, @RequestParam("codigoIdentificacao") String codigoIdentificacao,
			@RequestParam("nome") String nome, @RequestParam("sobrenome") String sobrenome){
		return usuarioService.cadastrarUsuario(cpf, codigoIdentificacao, nome, sobrenome);
	}
	
	@PostMapping("/consultarPorCodigoIdentificacao")
	public ResponseEntity<Usuario> consultarUsuarioPorCodigoIdentificacaco(
			@RequestParam("codigoIdentificacao") String codigoIdentificacao){
		return usuarioService.consultarUsuarioPorCodigoIdentificacao(codigoIdentificacao);
	}
	
	@PostMapping("/consultarPorCpf")
	public ResponseEntity<Usuario> consultarUsuarioPorCpf(@RequestParam("cpf") String cpf){
		return usuarioService.consultarUsuarioPorCpf(cpf);
	}
	
	@PostMapping("/deletarPorCodigoIdentificacao")
	public ResponseEntity<String> deletarUsuarioPorCodigoIdentificacao(
			@RequestParam("codigoIdentificacao") String codigoIdentificacao){
		return usuarioService.deletarUsuarioPorCodigoIdentificacao(codigoIdentificacao);
	}
}
