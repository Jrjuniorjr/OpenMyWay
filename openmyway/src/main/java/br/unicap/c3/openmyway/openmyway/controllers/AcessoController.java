package br.unicap.c3.openmyway.openmyway.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.unicap.c3.openmyway.openmyway.interfacesdao.IUsuarioDAO;
import br.unicap.c3.openmyway.openmyway.services.UsuarioService;

@RestController
@RequestMapping("/acesso")
public class AcessoController {

	@PostMapping("/acessar")
	public ResponseEntity<String> acessar(@RequestBody String codigoIdentificacao){
		
	}
}
