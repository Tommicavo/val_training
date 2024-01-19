package model.dto;

public class ScalaDto {
	
	// Proprietà
	private Long idScala;
	private String titoloScala;
	private String descrizioneScala;
	
	// Costruttore
	public ScalaDto() {}
	public ScalaDto(Long idScala, String titoloScala, String descrizioneScala) {
		this.idScala = idScala;
		this.titoloScala = titoloScala;
		this.descrizioneScala = descrizioneScala;
	}
	
	// Getter e Setter
	public Long getIdScala() {
		return idScala;
	}
	public void setIdScala(Long idScala) {
		this.idScala = idScala;
	}
	public String getTitoloScala() {
		return titoloScala;
	}
	public void setTitoloScala(String titoloScala) {
		this.titoloScala = titoloScala;
	}
	public String getDescrizioneScala() {
		return descrizioneScala;
	}
	public void setDescrizioneScala(String descrizioneScala) {
		this.descrizioneScala = descrizioneScala;
	}
}
