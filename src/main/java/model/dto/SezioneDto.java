package model.dto;

public class SezioneDto {
	
	// Proprietà
	private Long idSezione;
	private String titoloSezione;
	
	// Costruttori
	public SezioneDto() {}
	public SezioneDto(Long idSezione, String titoloSezione) {
		this.idSezione = idSezione;
		this.titoloSezione = titoloSezione;
	}
	
	// Getter e Setter
	public Long getIdSezione() {
		return idSezione;
	}
	public void setIdSezione(Long idSezione) {
		this.idSezione = idSezione;
	}
	public String getTitoloSezione() {
		return titoloSezione;
	}
	public void setTitoloSezione(String titoloSezione) {
		this.titoloSezione = titoloSezione;
	}
}
