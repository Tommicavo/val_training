package utils.converter;

import model.bean.UtenteBean;
import model.dto.UtenteDto;

public class UtenteConverter {
	
	public UtenteDto toDto(UtenteBean utenteBean) {
		UtenteDto utenteDto = new UtenteDto();
		
		utenteDto.setIdUtente(utenteBean.getIdUtente());
		utenteDto.setNomeUtente(utenteBean.getNomeUtente());
		utenteDto.setCognomeUtente(utenteBean.getCognomeUtente());
		utenteDto.setEmailUtente(utenteDto.getEmailUtente());
		utenteDto.setPasswordUtente(utenteBean.getPasswordUtente());
		utenteDto.setInformazioniGeneraliUtente(utenteBean.getInformazioniGeneraliUtente());
		
		return utenteDto;
	}
	
	public UtenteBean toBean(UtenteDto utenteDto) {
		UtenteBean utenteBean = new UtenteBean();
		
		utenteBean.setIdUtente(utenteDto.getIdUtente());
		utenteBean.setNomeUtente(utenteDto.getNomeUtente());
		utenteBean.setCognomeUtente(utenteDto.getCognomeUtente());
		utenteBean.setEmailUtente(utenteDto.getEmailUtente());
		utenteBean.setPasswordUtente(utenteDto.getPasswordUtente());
		utenteBean.setInformazioniGeneraliUtente(utenteDto.getInformazioniGeneraliUtente());
		
		return utenteBean;
	}
}
