package utils.converter;

import model.bean.GruppoBean;
import model.dto.GruppoDto;

public class GruppoConverter {
	
	public GruppoDto toDto(GruppoBean gruppoBean) {
		GruppoDto gruppoDto = new GruppoDto();
		
		gruppoDto.setIdGruppo(gruppoBean.getIdGruppo());
		gruppoDto.setNomeGruppo(gruppoBean.getNomeGruppo());
		
		return gruppoDto;
	}
	
	public GruppoBean toBean(GruppoDto gruppoDto) {
		GruppoBean gruppoBean = new GruppoBean();
		
		gruppoBean.setIdGruppo(gruppoDto.getIdGruppo());
		gruppoBean.setNomeGruppo(gruppoDto.getNomeGruppo());
		
		return gruppoBean;
	}
}
