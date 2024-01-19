package model.bean;

import java.time.LocalDateTime;
import java.util.Objects;

public class ValoreBean {
	
	// Proprietà
	private Long idValore;
	private String nomeValore;
	private String votoValore;
	private LocalDateTime dataCreazioneValore;
	private LocalDateTime dataModificaValore;
	private boolean flgCancellatoValore;
	
	// Costruttori
	public ValoreBean() {}
	
	public ValoreBean(Long idValore, String nomeValore, String votoValore, LocalDateTime dataCreazioneValore,
			LocalDateTime dataModificaValore, boolean flgCancellatoValore) {
		this.idValore = idValore;
		this.nomeValore = nomeValore;
		this.votoValore = votoValore;
		this.dataCreazioneValore = dataCreazioneValore;
		this.dataModificaValore = dataModificaValore;
		this.flgCancellatoValore = flgCancellatoValore;
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
	public LocalDateTime getDataCreazioneValore() {
		return dataCreazioneValore;
	}
	public void setDataCreazioneValore(LocalDateTime dataCreazioneValore) {
		this.dataCreazioneValore = dataCreazioneValore;
	}
	public LocalDateTime getDataModificaValore() {
		return dataModificaValore;
	}
	public void setDataModificaValore(LocalDateTime dataModificaValore) {
		this.dataModificaValore = dataModificaValore;
	}
	public boolean isFlgCancellatoValore() {
		return flgCancellatoValore;
	}
	public void setFlgCancellatoValore(boolean flgCancellatoValore) {
		this.flgCancellatoValore = flgCancellatoValore;
	}
	
	@Override
    public String toString() {
        return "Valore: {" +
                "Id = " + getIdValore() +
                ", Nome = " + getNomeValore() +
                ", Voto = " + getVotoValore() + "}\n";
    }
	@Override
	public int hashCode() {
		return Objects.hash(idValore);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ValoreBean other = (ValoreBean) obj;
		return Objects.equals(idValore, other.idValore);
	}
}
