package br.unicap.c3.openmyway.openmyway.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.unicap.c3.openmyway.openmyway.dto.AcessoDTO;
import br.unicap.c3.openmyway.openmyway.dto.UsuarioDTO;
import br.unicap.c3.openmyway.openmyway.interfacesdao.IUsuarioDAO;
import br.unicap.c3.openmyway.openmyway.model.Acesso;
import br.unicap.c3.openmyway.openmyway.model.Usuario;

@Service
public class UsuarioService {

	@Autowired
	private IUsuarioDAO iUsuarioDAO;

	private boolean validarCpf(String cpf) {

		if (cpf == null) {

			return false;
		}

		else {

			return true;

		}

	}

	private boolean validarCodigoIdentificacao(String codigoIdentificacao) {

		if (codigoIdentificacao == null) {

			return false;
		}

		else {

			return true;

		}

	}

	private boolean validarNome(String nome) {

		if (nome == null) {

			return false;
		}

		else {

			return true;

		}

	}

	private boolean validarSobrenome(String sobrenome) {

		if (sobrenome == null) {

			return false;
		}

		else {

			return true;

		}

	}

	public ResponseEntity<String> cadastrarUsuario(Usuario usuario) {

		if (!validarCpf(usuario.getCpf())) {

			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("CPF inválido!");

		}

		if (!validarCodigoIdentificacao(usuario.getCodigoIdentificacao())) {

			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Codigo de identificação inválido!");

		}

		if (!validarNome(usuario.getNome())) {

			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Nome inválido!");

		}

		if (!validarSobrenome(usuario.getSobrenome())) {

			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Sobrenome inválido!");

		}
		
		Usuario usuarioPorCodigo = iUsuarioDAO.findByCodigoIdentificacao(usuario.getCodigoIdentificacao());

		Usuario usuarioPorCpf = iUsuarioDAO.findByCpf(usuario.getCpf());

		if (usuarioPorCodigo != null) {

			return ResponseEntity.status(HttpStatus.CONFLICT)
					.body("Usuario com o codigo de identificação passado já cadastrado!");

		} else if (usuarioPorCpf != null) {

			return ResponseEntity.status(HttpStatus.CONFLICT).body("Usuario com o cpf passado já cadastrado");

		} else {

			iUsuarioDAO.save(usuario);

			return ResponseEntity.ok("O usuario foi cadastrado com sucesso!");

		}

	}

	public ResponseEntity<?> consultarUsuarioPorCodigoIdentificacaoParaExibicao(String codigoIdentificacao) {

		if(!validarCodigoIdentificacao(codigoIdentificacao)) {

			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Codigo de Identificação inválido!");

			
		}
		
		Usuario usuario = iUsuarioDAO.findByCodigoIdentificacao(codigoIdentificacao);

		UsuarioDTO usuarioDTO = null;
		
		if (usuario == null) {
		
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado!");
		
		}

		else {
			
			usuarioDTO = new UsuarioDTO(usuario.getCpf(), usuario.getCodigoIdentificacao(), usuario.getNome(),
					usuario.getSobrenome());
			
			return ResponseEntity.ok(usuarioDTO);
		}

	}

	public ResponseEntity<?> consultarUsuarioPorCpfParaExibicao(String cpf) {
		
		if(!validarCpf(cpf)) {
			
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("CPF invalido!");
			
		}
		
		Usuario usuario = iUsuarioDAO.findByCpf(cpf);
		
		UsuarioDTO usuarioDTO = null;
		
		if (usuario == null) {
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario não encontrado!");
		
		}
		
		else {
			usuarioDTO = new UsuarioDTO(usuario.getCpf(), usuario.getCodigoIdentificacao(), usuario.getNome(),
					usuario.getSobrenome());
		
			return ResponseEntity.ok(usuarioDTO);
		
		}

	}

	public ResponseEntity<Usuario> consultarUsuarioPorCodigoIdentificacao(String codigoIdentificacao) {

		Usuario usuario = iUsuarioDAO.findByCodigoIdentificacao(codigoIdentificacao);

		if (usuario == null) {
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(usuario);
		
		}

		else {
		
			return ResponseEntity.ok(usuario);
		
		}

	}

	public ResponseEntity<Usuario> consultarUsuarioPorCpf(String cpf) {
		
		Usuario usuario = iUsuarioDAO.findByCpf(cpf);

		if (usuario == null) {
		
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(usuario);
		
		}

		else {
			return ResponseEntity.ok(usuario);
		}

	}

	public ResponseEntity<String> deletarUsuarioPorCodigoIdentificacao(String codigoIdentificacao) {

		if(!validarCodigoIdentificacao(codigoIdentificacao)) {

			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Codigo de Identificação inválido!");

		}
		
		Usuario usuario = iUsuarioDAO.findByCodigoIdentificacao(codigoIdentificacao);

		if (usuario == null) {
		
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario não encontrado!");
		
		} else {

			iUsuarioDAO.delete(usuario);
			
			return ResponseEntity.ok("O usuario foi deletado com sucesso!");
		
		}
	
	}

	public ResponseEntity<String> deletarUsuarioPorCpf(String cpf) {

		if(!validarCpf(cpf)) {
			
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("CPF invalido!");
			
		}	
		
		Usuario usuario = iUsuarioDAO.findByCpf(cpf);

		if (usuario == null) {
		
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario não encontrado!");
		
		} else {
			
			iUsuarioDAO.delete(usuario);
		
			return ResponseEntity.ok("O usuario foi deletado com sucesso!");
	
		}

	}

	public ResponseEntity<?> gerarRelatorioAcessoPorCodigoIdentificacao(String codigoIdentificacao) {
		
		if(!validarCodigoIdentificacao(codigoIdentificacao)) {

			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Codigo de Identificação inválido!");

		}
		
		Usuario usuario = iUsuarioDAO.findByCodigoIdentificacao(codigoIdentificacao);
		
		List<AcessoDTO> acessosDTO = new ArrayList<>();

		if (usuario == null) {
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(acessosDTO);
		
		}

		if (usuario.getAcessos().isEmpty()) {
		
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(acessosDTO);
		
		}

		else {
			
			for (Acesso acesso : usuario.getAcessos()) {
				
				AcessoDTO acessoDTO = new AcessoDTO(acesso.getUsuario().getCpf(),
						acesso.getUsuario().getCodigoIdentificacao(), acesso.getUsuario().getNome(),
						acesso.getUsuario().getSobrenome(), acesso.getTipoAcesso(), acesso.getData(), acesso.getHora());
			
				acessosDTO.add(acessoDTO);
		
			}

			return ResponseEntity.ok(acessosDTO);
	
		}
	
	}

	public ResponseEntity<?> gerarRelatorioAcessoPorCpf(String cpf) {

		if(!validarCpf(cpf)) {
			
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("CPF invalido!");
			
		}	
		
		Usuario usuario = iUsuarioDAO.findByCpf(cpf);
		
		List<AcessoDTO> acessosDTO = new ArrayList<>();

		if (usuario == null) {
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario não encontrado!");
		
		}

		if (usuario.getAcessos().isEmpty()) {
		
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario não possui acessos!");
		
		}

		else {
			
			for (Acesso acesso : usuario.getAcessos()) {
		
				AcessoDTO acessoDTO = new AcessoDTO(acesso.getUsuario().getCpf(),
						acesso.getUsuario().getCodigoIdentificacao(), acesso.getUsuario().getNome(),
						acesso.getUsuario().getSobrenome(), acesso.getTipoAcesso(), acesso.getData(), acesso.getHora());
			
				acessosDTO.add(acessoDTO);
			
			}

			return ResponseEntity.ok(acessosDTO);
	
		}
	
	}
	
}
