package model.bean;

import java.time.LocalDateTime;
import java.util.Objects;

public class GruppoBean {
	
	// Proprietà
	private Long idGruppo;
	private String nomeGruppo;
	private LocalDateTime dataCreazioneGruppo;
	private LocalDateTime dataModificaGruppo;
	private boolean flgCancellatoGruppo;
	
	// Costruttori
	public GruppoBean() {}
	
	public GruppoBean(Long idGruppo, String nomeGruppo, LocalDateTime dataCreazioneGruppo,
			LocalDateTime dataModificaGruppo, boolean flgCancellatoGruppo) {
		this.idGruppo = idGruppo;
		this.nomeGruppo = nomeGruppo;
		this.dataCreazioneGruppo = dataCreazioneGruppo;
		this.dataModificaGruppo = dataModificaGruppo;
		this.flgCancellatoGruppo = flgCancellatoGruppo;
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
	public LocalDateTime getDataCreazioneGruppo() {
		return dataCreazioneGruppo;
	}
	public void setDataCreazioneGruppo(LocalDateTime dataCreazioneGruppo) {
		this.dataCreazioneGruppo = dataCreazioneGruppo;
	}
	public LocalDateTime getDataModificaGruppo() {
		return dataModificaGruppo;
	}
	public void setDataModificaGruppo(LocalDateTime dataModificaGruppo) {
		this.dataModificaGruppo = dataModificaGruppo;
	}
	public boolean isFlgCancellatoGruppo() {
		return flgCancellatoGruppo;
	}
	public void setFlgCancellatoGruppo(boolean flgCancellatoGruppo) {
		this.flgCancellatoGruppo = flgCancellatoGruppo;
	}
	
	@Override
    public String toString() {
        return "Gruppo: {" +
                "Id = " + getIdGruppo() +
                ", Nome = " + getNomeGruppo() + "}\n";
    }
	@Override
	public int hashCode() {
		return Objects.hash(idGruppo);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GruppoBean other = (GruppoBean) obj;
		return Objects.equals(idGruppo, other.idGruppo);
	}
}
