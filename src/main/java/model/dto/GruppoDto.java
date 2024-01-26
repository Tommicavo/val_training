package model.dto;

public class GruppoDto {
	
	// Proprietà
	private Long idGruppo;
	private String nomeGruppo;
	private Long idResponsabile;
	
	// Costruttori
	public GruppoDto() {}
	public GruppoDto(Long idGruppo, String nomeGruppo) {
		this.idGruppo = idGruppo;
		this.nomeGruppo = nomeGruppo;
	}
	
	// Getter e Setter
	public Long getIdGruppo() {
		return idGruppo;
	}
	public void setIdGruppo(Long idGruppo) {
		this.idGruppo = idGruppo;
	}
	public String getNomeGruppo() {
		return nomeGruppo;
	}
	public void setNomeGruppo(String nomeGruppo) {
		this.nomeGruppo = nomeGruppo;
	}
	public Long getIdResponsabile() {
		return idResponsabile;
	}
	public void setIdResponsabile(Long idResponsabile) {
		this.idResponsabile = idResponsabile;
	}
}
