package model.bean;

import java.time.LocalDateTime;

public class ParagrafoBean {
	
	// Proprietà
	private Long idParagrafo;
	private String titoloParagrafo;
	private String descrizioneParagrafo;
	private LocalDateTime dataCreazioneParagrafo;
	private LocalDateTime dataModificaParagrafo;
	private boolean flgCancellatoParagrafo;
	
	// Costruttori
	public ParagrafoBean() {}
	
	public ParagrafoBean(Long idParagrafo, String titoloParagrafo, String descrizioneParagrafo,
			LocalDateTime dataCreazioneParagrafo, LocalDateTime dataModificaParagrafo, boolean flgCancellatoParagrafo) {
		this.idParagrafo = idParagrafo;
		this.titoloParagrafo = titoloParagrafo;
		this.descrizioneParagrafo = descrizioneParagrafo;
		this.dataCreazioneParagrafo = dataCreazioneParagrafo;
		this.dataModificaParagrafo = dataModificaParagrafo;
		this.flgCancellatoParagrafo = flgCancellatoParagrafo;
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
	public LocalDateTime getDataCreazioneParagrafo() {
		return dataCreazioneParagrafo;
	}
	public void setDataCreazioneParagrafo(LocalDateTime dataCreazioneParagrafo) {
		this.dataCreazioneParagrafo = dataCreazioneParagrafo;
	}
	public LocalDateTime getDataModificaParagrafo() {
		return dataModificaParagrafo;
	}
	public void setDataModificaParagrafo(LocalDateTime dataModificaParagrafo) {
		this.dataModificaParagrafo = dataModificaParagrafo;
	}
	public boolean isFlgCancellatoParagrafo() {
		return flgCancellatoParagrafo;
	}
	public void setFlgCancellatoParagrafo(boolean flgCancellatoParagrafo) {
		this.flgCancellatoParagrafo = flgCancellatoParagrafo;
	}
	
	@Override
    public String toString() {
        return "Paragrafo: {" +
                "Id = " + getIdParagrafo() +
                ", Titolo = " + getTitoloParagrafo() +
                ", \n Descrizione = " +  getDescrizioneParagrafo() + "}\n";
    }
}
