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
	public ResponseEntity<String> cadastrarUsuario(@RequestBody Usuario usuario){
	
		return usuarioService.cadastrarUsuario(usuario);
	
	}
	
	@PutMapping("/alterar")
	public ResponseEntity<?> alterarUsuario(@RequestBody Usuario usuario){
		return usuarioService.alterarUsuario(usuario);
	}
	
	@GetMapping("/consultarPorCodigoIdentificacao/{codigoIdentificacao}")
	public ResponseEntity<?> consultarUsuarioPorCodigoIdentificacaco(
			@PathVariable("codigoIdentificacao") String codigoIdentificacao){
		
		return usuarioService.consultarUsuarioPorCodigoIdentificacao(codigoIdentificacao);
	
	}
	
	@GetMapping("/consultarPorCpf/{cpf}")
	public ResponseEntity<?> consultarUsuarioPorCpf(@PathVariable("cpf") String cpf){
	
		return usuarioService.consultarUsuarioPorCpf(cpf);
	
	}
	
	@DeleteMapping("/deletarPorCodigoIdentificacao")
	public ResponseEntity<String> deletarUsuarioPorCodigoIdentificacao(
			@RequestParam("codigoIdentificacao") String codigoIdentificacao){
		
		return usuarioService.deletarUsuarioPorCodigoIdentificacao(codigoIdentificacao);
	
	}
	
	@DeleteMapping("/deletarPorCpf")
	public ResponseEntity<String> deletarUsuarioPorCpf(@RequestParam("cpf") String cpf){
	
		return usuarioService.deletarUsuarioPorCpf(cpf);
	
	}
	
	@GetMapping("/gerarRelatorioAcessosPorCodigoIdentificacao/{codigoIdentificacao}")
	public ResponseEntity<?> gerarRelatorioPorCodigoIdentificacao(
			@PathVariable("codigoIdentificacao") String codigoIdentificacao){
	
		return usuarioService.gerarRelatorioAcessoPorCodigoIdentificacao(codigoIdentificacao);
	
	}
	
	@GetMapping("/gerarRelatorioAcessosPorCpf/{cpf}")
	public ResponseEntity<?> gerarRelatorioPorCpf(@PathVariable("cpf") String cpf){
	
		return usuarioService.gerarRelatorioAcessoPorCpf(cpf);
	
	}

}