package model.bean;

import java.time.LocalDateTime;

public class SezioneBean {
	
	// Proprietà
	private Long idSezione;
	private String titoloSezione;
	private LocalDateTime dataCreazioneSezione;
	private LocalDateTime dataModificaSezione;
	private boolean flgCancellatoSezione;
	
	// Costruttori
	public SezioneBean() {}

	public SezioneBean(Long idSezione, String titoloSezione, LocalDateTime dataCreazioneSezione,
			LocalDateTime dataModificaSezione, boolean flgCancellatoSezione) {
		this.idSezione = idSezione;
		this.titoloSezione = titoloSezione;
		this.dataCreazioneSezione = dataCreazioneSezione;
		this.dataModificaSezione = dataModificaSezione;
		this.flgCancellatoSezione = flgCancellatoSezione;
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
	public LocalDateTime getDataCreazioneSezione() {
		return dataCreazioneSezione;
	}
	public void setDataCreazioneSezione(LocalDateTime dataCreazioneSezione) {
		this.dataCreazioneSezione = dataCreazioneSezione;
	}
	public LocalDateTime getDataModificaSezione() {
		return dataModificaSezione;
	}
	public void setDataModificaSezione(LocalDateTime dataModificaSezione) {
		this.dataModificaSezione = dataModificaSezione;
	}
	public boolean isFlgCancellatoSezione() {
		return flgCancellatoSezione;
	}
	public void setFlgCancellatoSezione(boolean flgCancellatoSezione) {
		this.flgCancellatoSezione = flgCancellatoSezione;
	}
	
	@Override
    public String toString() {
        return "Sezione: {" +
                "Id = " + getIdSezione() +
                ", Titolo = " + getTitoloSezione() + "}\n";
    }
}
