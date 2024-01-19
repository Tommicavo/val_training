package model.dto;

public class ValoreDto {
	
	// Proprietà
	private Long idValore;
	private String nomeValore;
	private String votoValore;
	
	// Costruttori
	public ValoreDto() {}
	public ValoreDto(Long idValore, String nomeValore, String votoValore) {
		this.idValore = idValore;
		this.nomeValore = nomeValore;
		this.votoValore = votoValore;
	}
	
	// Getter e Setter
	public Long getIdValore() {
		return idValore;
	}
	public void setIdValore(Long idValore) {
		this.idValore = idValore;
	}
	public String getNomeValore() {
		return nomeValore;
	}
	public void setNomeValore(String nomeValore) {
		this.nomeValore = nomeValore;
	}
	public String getVotoValore() {
		return votoValore;
	}
	public void setVotoValore(String votoValore) {
		this.votoValore = votoValore;
	}
}
