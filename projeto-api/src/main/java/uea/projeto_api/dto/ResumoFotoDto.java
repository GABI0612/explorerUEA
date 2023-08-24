package uea.projeto_api.dto;

public class ResumoFotoDto {
	private Long codigo;
	private String url;
	private String descricao;
	
	public ResumoFotoDto() {
		super();
	}
	
	public ResumoFotoDto(Long codigo, String url, String descricao) {
		super();
		this.codigo = codigo;
		this.url = url;
		this.descricao = descricao;
	}
	
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
