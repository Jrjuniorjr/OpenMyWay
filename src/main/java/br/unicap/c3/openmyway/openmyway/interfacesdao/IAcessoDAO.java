package br.unicap.c3.openmyway.openmyway.interfacesdao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.unicap.c3.openmyway.openmyway.model.Acesso;

public interface IAcessoDAO extends JpaRepository<Acesso, Integer>{
	
	public List<Acesso> findByData(String data);
	
	public List<Acesso> findByDataInAndHoraIn(String data, String hora);

}
