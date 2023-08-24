package uea.projeto_api.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Atividade implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	@NotBlank(message = "titulo é obrigatório")
	private String titulo;
	@NotBlank(message = "Descrição é obrigatório")
	private String descricao;
	@NotNull(message = "Data é obrigatório")
	private LocalDate data;
	
	@NotNull(message = "Categoria é obrigatório")
	@ManyToOne
	@JoinColumn(name="codigo_categoria")
	private Categoria categoria;

	
	
	@ManyToOne
	@JoinColumn(name="codigo_usuario")
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name="codigo_publicacao")
	private Publicacao publicacao;

	public Atividade() {
		super();
	}

	


	public Atividade(Long codigo, @NotBlank(message = "titulo é obrigatório") String titulo,
			@NotBlank(message = "Descrição é obrigatório") String descricao,
			@NotNull(message = "Data é obrigatório") LocalDate data,
			@NotNull(message = "Categoria é obrigatório") Categoria categoria, Usuario usuario, Publicacao publicacao) {
		super();
		this.codigo = codigo;
		this.titulo = titulo;
		this.descricao = descricao;
		this.data = data;
		this.categoria = categoria;
		this.usuario = usuario;
		this.publicacao = publicacao;
	}




	public Long getCodigo() {
		return codigo;
	}




	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}




	public String getTitulo() {
		return titulo;
	}




	public void setTitulo(String titulo) {
		this.titulo = titulo;
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




	public Categoria getCategoria() {
		return categoria;
	}




	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}




	public Usuario getUsuario() {
		return usuario;
	}




	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}




	public Publicacao getPublicacao() {
		return publicacao;
	}




	public void setPublicacao(Publicacao publicacao) {
		this.publicacao = publicacao;
	}




	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Atividade other = (Atividade) obj;
		return Objects.equals(codigo, other.codigo);
	}

}