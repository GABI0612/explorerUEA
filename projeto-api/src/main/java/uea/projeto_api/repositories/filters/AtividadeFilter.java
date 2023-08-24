package uea.projeto_api.repositories.filters;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

public class AtividadeFilter {
	private String titulo;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataDe;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataAte;

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public LocalDate getDataDe() {
		return dataDe;
	}

	public void setDataDe(LocalDate dataDe) {
		this.dataDe = dataDe;
	}

	public LocalDate getDataAte() {
		return dataAte;
	}

	public void setDataAte(LocalDate dataAte) {
		this.dataAte = dataAte;
	}

	
}