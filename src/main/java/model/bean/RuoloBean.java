package model.bean;

import java.util.Objects;

public class RuoloBean {
	
	// Proprietà
	private Long idRuolo;
	private String nomeRuolo;
	private Long idResponsabile;
	
	// Costruttori
	public RuoloBean() {}
	public RuoloBean(Long idRuolo, String nomeRuolo) {
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
	public Long getIdResponsabile() {
		return idResponsabile;
	}
	public void setIdResponsabile(Long idResponsabile) {
		this.idResponsabile = idResponsabile;
	}
	@Override
    public String toString() {
        return "Ruolo: {" +
                "Id = " + getIdRuolo() +
                ", Nome = " + getNomeRuolo() + "}\n";
    }
	@Override
	public int hashCode() {
		return Objects.hash(idRuolo);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RuoloBean other = (RuoloBean) obj;
		return Objects.equals(idRuolo, other.idRuolo);
	}
}
