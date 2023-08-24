package uea.projeto_api.dto;

import java.time.LocalDate;

public class ResumoAtividadeDto {
	private Long codigo;
	private String titulo;
	private String descricao;
	private LocalDate data;
	private String categoria;
	private String pessoa;
	private String publicacao;
	

	public ResumoAtividadeDto() {
		super();

	}


	public ResumoAtividadeDto(Long codigo, String titulo, String descricao, LocalDate data, String categoria,
			String pessoa, String publicacao) {
		super();
		this.codigo = codigo;
		this.titulo = titulo;
		this.descricao = descricao;
		this.data = data;
		this.categoria = categoria;
		this.pessoa = pessoa;
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


	public String getCategoria() {
		return categoria;
	}


	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}


	public String getPessoa() {
		return pessoa;
	}


	public void setPessoa(String pessoa) {
		this.pessoa = pessoa;
	}


	public String getPublicacao() {
		return publicacao;
	}


	public void setPublicacao(String publicacao) {
		this.publicacao = publicacao;
	}

	
	
}