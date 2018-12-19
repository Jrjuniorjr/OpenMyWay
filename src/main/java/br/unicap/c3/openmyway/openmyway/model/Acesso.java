package br.unicap.c3.openmyway.openmyway.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.persistence.*;


@Entity
@Table(name="Acesso")
public class Acesso {
	@Id 
	@Column (name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Enumerated(EnumType.STRING)
	@Column(name="tipoAcesso", columnDefinition="enum('Entrada', 'Saida')")
	private TipoAcesso tipoAcesso;
	
	@ManyToOne(
			fetch = FetchType.EAGER)
	@JoinColumn(name = "idUsuario")
	private Usuario usuario;
	
	@Column (name = "data")
	private String data;
	
	@Column (name = "hora")
	private String hora;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TipoAcesso getTipoAcesso() {
		return tipoAcesso;
	}

	public void setTipoAcesso(TipoAcesso tipoAcesso) {
		this.tipoAcesso = tipoAcesso;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public void converterCalendarToStringAcesso() {
		Calendar cdl = Calendar.getInstance();
		DateFormat df = new SimpleDateFormat("dd-MM-yy HH:mm:ss");
		String dataHora = df.format(cdl.getTime());
		String [] arraySplit = new String [2];
		arraySplit = dataHora.split(" ");
		this.data = arraySplit[0];
		this.hora = arraySplit[1];
	}
	
	
}
