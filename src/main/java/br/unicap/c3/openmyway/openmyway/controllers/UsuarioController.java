package br.unicap.c3.openmyway.openmyway.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.unicap.c3.openmyway.openmyway.model.IntegranteUniversidade;
import br.unicap.c3.openmyway.openmyway.model.Usuario;
import br.unicap.c3.openmyway.openmyway.services.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping("/cadastrarUsuario")
	public ResponseEntity<String> cadastrarUsuario(@RequestBody Usuario usuario){
	
		return usuarioService.cadastrarUsuario(usuario);
	
	}
	
	@PostMapping("/cadastrarIntegranteUniversidade")
	public ResponseEntity<String> cadastrarIntegranteUniversidade(
			@RequestBody IntegranteUniversidade integranteUniversidade){
	
		return usuarioService.cadastrarIntegranteUniversidade(integranteUniversidade);
	
	}
	
	@PutMapping("/alterarUsuario")
	public ResponseEntity<?> alterarUsuario(@RequestBody Usuario usuario){
		return usuarioService.alterarUsuario(usuario);
	}
	
	
	@PutMapping("/alterarIntegranteUniversidade")
	public ResponseEntity<?> alterarIntegranteUniversidade(@RequestBody IntegranteUniversidade integranteUniversidade){
		return usuarioService.alterarUsuario(integranteUniversidade);
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
			@RequestHeader("codigoIdentificacao") String codigoIdentificacao){
		
		return usuarioService.deletarUsuarioPorCodigoIdentificacao(codigoIdentificacao);
	
	}
	
	@DeleteMapping("/deletarPorCpf")
	public ResponseEntity<String> deletarUsuarioPorCpf(@RequestHeader("cpf") String cpf){
	
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