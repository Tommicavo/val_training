package model.dto;

public class ParagrafoDto {
	
	// Proprietà
	private Long idParagrafo;
	private String titoloParagrafo;
	private String descrizioneParagrafo;
	
	// Costruttori
	public ParagrafoDto() {}
	public ParagrafoDto(Long idParagrafo, String titoloParagrafo, String descrizioneParagrafo) {
		this.idParagrafo = idParagrafo;
		this.titoloParagrafo = titoloParagrafo;
		this.descrizioneParagrafo = descrizioneParagrafo;
	}
	
	// Getter e Setter
	public Long getIdParagrafo() {
		return idParagrafo;
	}
	public void setIdParagrafo(Long idParagrafo) {
		this.idParagrafo = idParagrafo;
	}
	public String getTitoloParagrafo() {
		return titoloParagrafo;
	}
	public void setTitoloParagrafo(String titoloParagrafo) {
		this.titoloParagrafo = titoloParagrafo;
	}
	public String getDescrizioneParagrafo() {
		return descrizioneParagrafo;
	}
	public void setDescrizioneParagrafo(String descrizioneParagrafo) {
		this.descrizioneParagrafo = descrizioneParagrafo;
	}
}
