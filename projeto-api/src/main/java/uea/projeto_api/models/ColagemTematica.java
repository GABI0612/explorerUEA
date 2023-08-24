package uea.projeto_api.models;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ColagemTematica implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	private Long ordemFT;
	
	
	@ManyToOne
	@JoinColumn(name = "codigo_foto")
	private Foto foto;

	public ColagemTematica() {
		super();
	}

	public ColagemTematica(Long codigo, Long ordemFT, Foto foto) {
		super();
		this.codigo = codigo;
		this.ordemFT = ordemFT;
		this.foto = foto;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Long getOrdemFT() {
		return ordemFT;
	}

	public void setOrdemFT(Long ordemFT) {
		this.ordemFT = ordemFT;
	}

	public Foto getFoto() {
		return foto;
	}

	public void setFoto(Foto foto) {
		this.foto = foto;
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
		ColagemTematica other = (ColagemTematica) obj;
		return Objects.equals(codigo, other.codigo);
	}

	
}