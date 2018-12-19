package br.unicap.c3.openmyway.openmyway.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.unicap.c3.openmyway.openmyway.dto.*;
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
	
	@GetMapping("/consultarPorCodigoIdentificacao/{codigoIdentificacao}")
	public ResponseEntity<UsuarioDTO> consultarUsuarioPorCodigoIdentificacaco(
			@PathVariable("codigoIdentificacao") String codigoIdentificacao){
		return usuarioService.consultarUsuarioPorCodigoIdentificacaoParaExibicao(codigoIdentificacao);
	}
	
	@GetMapping("/consultarPorCpf/{cpf}")
	public ResponseEntity<UsuarioDTO> consultarUsuarioPorCpf(@PathVariable("cpf") String cpf){
		return usuarioService.consultarUsuarioPorCpfParaExibicao(cpf);
	}
	
	@PostMapping("/deletarPorCodigoIdentificacao")
	public ResponseEntity<String> deletarUsuarioPorCodigoIdentificacao(
			@RequestParam("codigoIdentificacao") String codigoIdentificacao){
		return usuarioService.deletarUsuarioPorCodigoIdentificacao(codigoIdentificacao);
	}
	
	@PostMapping("/deletarPorCpf")
	public ResponseEntity<String> deletarUsuarioPorCpf(@RequestParam("cpf") String cpf){
		return usuarioService.deletarUsuarioPorCpf(cpf);
	}
	
	@GetMapping("/gerarRelatorioAcessosPorCodigoIdentificacao/{codigoIdentificacao}")
	public ResponseEntity<List<AcessoDTO>> gerarRelatorioPorCodigoIdentificacao(
			@PathVariable("codigoIdentificacao") String codigoIdentificacao){
		return usuarioService.gerarRelatorioAcessoPorCodigoIdentificacao(codigoIdentificacao);
	}
	
	@GetMapping("/gerarRelatorioAcessosPorCpf/{cpf}")
	public ResponseEntity<List<AcessoDTO>> gerarRelatorioPorCpf(@PathVariable("cpf") String cpf){
		return usuarioService.gerarRelatorioAcessoPorCpf(cpf);
	}
}
