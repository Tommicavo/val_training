package model.bean;

import java.time.LocalDateTime;
import java.util.Objects;

public class UtenteBean {
	
	// Proprietà
	private Long idUtente;
	private String nomeUtente;
	private String cognomeUtente;
	private String emailUtente;
	private String passwordUtente;
	private String informazioniGeneraliUtente;
	private LocalDateTime dataCreazioneUtente;
	private LocalDateTime dataModificaUtente;
	private boolean flgCancellatoUtente;
	private Long idRuolo;
	private Long idGruppo;
	
	// Costruttori
	public UtenteBean() {}
	
	public UtenteBean(Long idUtente, String nomeUtente, String cognomeUtente, String emailUtente, String passwordUtente, String informazioniGeneraliUtente,
			LocalDateTime dataCreazioneUtente, LocalDateTime dataModificaUtente, boolean flgCancellatoUtente) {
		this.idUtente = idUtente;
		this.nomeUtente = nomeUtente;
		this.cognomeUtente = cognomeUtente;
		this.emailUtente = emailUtente;
		this.passwordUtente = passwordUtente;
		this.informazioniGeneraliUtente = informazioniGeneraliUtente;
		this.dataCreazioneUtente = dataCreazioneUtente;
		this.dataModificaUtente = dataModificaUtente;
		this.flgCancellatoUtente = flgCancellatoUtente;
		this.idRuolo = 1L;
	}
	
	public UtenteBean(Long idUtente, String nomeUtente, String cognomeUtente, String emailUtente, String passwordUtente, String informazioniGeneraliUtente,
            LocalDateTime dataCreazioneUtente, LocalDateTime dataModificaUtente, boolean flgCancellatoUtente, Long idRuolo, Long idGruppo) {
        this(idUtente, nomeUtente, cognomeUtente, emailUtente, passwordUtente, informazioniGeneraliUtente, dataCreazioneUtente, dataModificaUtente, flgCancellatoUtente);
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
	public LocalDateTime getDataCreazioneUtente() {
		return dataCreazioneUtente;
	}
	public void setDataCreazioneUtente(LocalDateTime dataCreazioneUtente) {
		this.dataCreazioneUtente = dataCreazioneUtente;
	}
	public LocalDateTime getDataModificaUtente() {
		return dataModificaUtente;
	}
	public void setDataModificaUtente(LocalDateTime dataModificaUtente) {
		this.dataModificaUtente = dataModificaUtente;
	}
	public boolean isFlgCancellatoUtente() {
		return flgCancellatoUtente;
	}
	public void setFlgCancellatoUtente(boolean flgCancellatoUtente) {
		this.flgCancellatoUtente = flgCancellatoUtente;
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

	@Override
    public String toString() {
        return "Utente: {" +
                "Id = " + getIdUtente() +
                ", Nome = " + getNomeUtente() +
                ", Cognome = " + getCognomeUtente() +
                ", Email = " + getEmailUtente() +
                ", Password = " + getPasswordUtente() +
                ", Id Ruolo = " + getIdRuolo() +
                ", \n Informazioni Generali = " + getInformazioniGeneraliUtente() + "}\n";
    }
	@Override
	public int hashCode() {
		return Objects.hash(emailUtente, idUtente, passwordUtente);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UtenteBean other = (UtenteBean) obj;
		return Objects.equals(emailUtente, other.emailUtente) && Objects.equals(idUtente, other.idUtente)
				&& Objects.equals(passwordUtente, other.passwordUtente);
	}
	
} 
