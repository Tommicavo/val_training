package model.dto;

public class RuoloDto {
	
	// Proprietà
	private Long idRuolo;
	private String nomeRuolo;
	
	// Costruttori
	public RuoloDto() {}
	public RuoloDto(Long idRuolo, String nomeRuolo) {
		this.idRuolo = idRuolo;
		this.nomeRuolo = nomeRuolo;
	}
	
	// Getter e Setter
	public Long getIdRuolo() {
		return idRuolo;
	}
	public void setIdRuolo(Long idRuolo) {
		this.idRuolo = idRuolo;
	}
	public String getNomeRuolo() {
		return nomeRuolo;
	}
	public void setNomeRuolo(String nomeRuolo) {
		this.nomeRuolo = nomeRuolo;
	}	
}
