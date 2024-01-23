package model.dto;

public class UtenteDto {
	
	// Proprietà
	private Long idUtente;
	private String nomeUtente;
	private String cognomeUtente;
	private String emailUtente;
	private String passwordUtente;
	private String informazioniGeneraliUtente;
	private Long idRuolo;
	private Long idGruppo;
	
	// Costruttori
	public UtenteDto() {}
	public UtenteDto(Long idUtente, String nomeUtente, String cognomeUtente, String emailUtente, String passwordUtente, String informazioniGeneraliUtente) {
		this.idUtente = idUtente;
		this.nomeUtente = nomeUtente;
		this.cognomeUtente = cognomeUtente;
		this.emailUtente = emailUtente;
		this.passwordUtente = passwordUtente;
		this.informazioniGeneraliUtente = informazioniGeneraliUtente;
		this.idRuolo = 2L;
	}
	
	public UtenteDto(Long idUtente, String nomeUtente, String cognomeUtente, String emailUtente, String passwordUtente, String informazioniGeneraliUtente, Long idRuolo, Long idGruppo) {
		this(idUtente, nomeUtente, cognomeUtente, emailUtente, passwordUtente, informazioniGeneraliUtente);
		this.idRuolo = idRuolo;
		this.idGruppo = idGruppo;
	}
	
	// Getters e Setters
	public Long getIdUtente() {
		return idUtente;
	}
	public void setIdUtente(Long idUtente) {
		this.idUtente = idUtente;
	}
	public String getNomeUtente() {
		return nomeUtente;
	}
	public void setNomeUtente(String nomeUtente) {
		this.nomeUtente = nomeUtente;
	}
	public String getCognomeUtente() {
		return cognomeUtente;
	}
	public void setCognomeUtente(String cognomeUtente) {
		this.cognomeUtente = cognomeUtente;
	}
	public String getEmailUtente() {
		return emailUtente;
	}
	public void setEmailUtente(String emailUtente) {
		this.emailUtente = emailUtente;
	}
	public String getPasswordUtente() {
		return passwordUtente;
	}
	public void setPasswordUtente(String passwordUtente) {
		this.passwordUtente = passwordUtente;
	}
	public String getInformazioniGeneraliUtente() {
		return informazioniGeneraliUtente;
	}
	public void setInformazioniGeneraliUtente(String informazioniGeneraliUtente) {
		this.informazioniGeneraliUtente = informazioniGeneraliUtente;
	}
	public Long getIdRuolo() {
		return idRuolo;
	}
	public void setIdRuolo(Long idRuolo) {
		this.idRuolo = idRuolo;
	}
	public Long getIdGruppo() {
		return idGruppo;
	}
	public void setIdGruppo(Long idGruppo) {
		this.idGruppo = idGruppo;
	}
}
