package uea.projeto_api.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;

@Entity
public class Publicacao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	private String descricao;
	
	@NotNull(message = "data é obrigatoria")
	private LocalDate data;

	@JsonIgnoreProperties(value = { "Publicacao" })
	@ManyToOne
	@JoinColumn(name = "codigo_foto")
	private Foto foto;
	
	
	@ManyToOne
	@JoinColumn(name = "codigo_usuario")
	private Usuario usuario;

	public Publicacao() {

	}

	
	
	

	public Publicacao(Long codigo, String descricao, @NotNull(message = "data é obrigatoria") LocalDate data, Foto foto,
			Usuario usuario) {
		super();
		this.codigo = codigo;
		this.descricao = descricao;
		this.data = data;
		this.foto = foto;
		this.usuario = usuario;
	}





	public Long getCodigo() {
		return codigo;
	}





	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}





	public String getDescricao() {
		return descricao;
	}





	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}





	public LocalDate getData() {
		return data;
	}





	public void setData(LocalDate data) {
		this.data = data;
	}





	public Foto getFoto() {
		return foto;
	}





	public void setFoto(Foto foto) {
		this.foto = foto;
	}





	public Usuario getUsuario() {
		return usuario;
	}





	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}





	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Publicacao other = (Publicacao) obj;
		return Objects.equals(codigo, other.codigo);
	}
	
	
	
}