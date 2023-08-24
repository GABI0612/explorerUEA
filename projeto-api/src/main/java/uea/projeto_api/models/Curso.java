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

@Entity
public class Curso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	private String nome;
	private String descricao;
	private LocalDate data;
	private Boolean ativo;

	@JsonIgnoreProperties(value = { "curso" })
	@ManyToOne
	@JoinColumn(name="codigo_atividade")
	private Atividade atividade;
	
	@JsonIgnoreProperties(value = { "curso" })
	@ManyToOne
	@JoinColumn(name="codigo_usuario")
	private Usuario usuario;

	public Curso() {
		super();
	}

	

	public Curso(Long codigo, String nome, String descricao, LocalDate data, Boolean ativo, Atividade atividade,
			Usuario usuario) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.descricao = descricao;
		this.data = data;
		this.ativo = ativo;
		this.atividade = atividade;
		this.usuario = usuario;
	}



	public Long getCodigo() {
		return codigo;
	}



	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}



	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
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



	public Boolean getAtivo() {
		return ativo;
	}



	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}



	public Atividade getAtividade() {
		return atividade;
	}



	public void setAtividade(Atividade atividade) {
		this.atividade = atividade;
	}



	public Usuario getUsuario() {
		return usuario;
	}



	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Curso other = (Curso) obj;
		return Objects.equals(codigo, other.codigo);
	}
	
	
	
}