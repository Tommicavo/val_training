package model.bean;

import java.time.LocalDateTime;

public class ScalaBean {
	
	// Proprietà
	private Long idScala;
	private String titoloScala;
	private String descrizioneScala;
	private LocalDateTime dataCreazioneScala;
	private LocalDateTime dataModificaScala;
	private boolean flgCancellatoScala;
	
	// Costruttore
	public ScalaBean() {}
	
	public ScalaBean(Long idScala, String titoloScala, String descrizioneScala, LocalDateTime dataCreazioneScala,
			LocalDateTime dataModificaScala, boolean flgCancellatoScala) {
		this.idScala = idScala;
		this.titoloScala = titoloScala;
		this.descrizioneScala = descrizioneScala;
		this.dataCreazioneScala = dataCreazioneScala;
		this.dataModificaScala = dataModificaScala;
		this.flgCancellatoScala = flgCancellatoScala;
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
	public LocalDateTime getDataCreazioneScala() {
		return dataCreazioneScala;
	}
	public void setDataCreazioneScala(LocalDateTime dataCreazioneScala) {
		this.dataCreazioneScala = dataCreazioneScala;
	}
	public LocalDateTime getDataModificaScala() {
		return dataModificaScala;
	}
	public void setDataModificaScala(LocalDateTime dataModificaScala) {
		this.dataModificaScala = dataModificaScala;
	}
	public boolean isFlgCancellatoScala() {
		return flgCancellatoScala;
	}
	public void setFlgCancellatoScala(boolean flgCancellatoScala) {
		this.flgCancellatoScala = flgCancellatoScala;
	}
	
	@Override
    public String toString() {
        return "Scala: {" +
                "Id = " + getIdScala() +
                ", Titolo = " + getTitoloScala() +
                ", \n Descrizione = " +  getDescrizioneScala() + "}\n";
    }
}
