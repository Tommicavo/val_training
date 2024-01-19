package utils.converter;

import model.bean.ValoreBean;
import model.dto.ValoreDto;

public class ValoreConverter {
	
	public ValoreDto toDto(ValoreBean valoreBean) {
		ValoreDto valoreDto = new ValoreDto();
		
		valoreDto.setIdValore(valoreBean.getIdValore());
		valoreDto.setNomeValore(valoreBean.getNomeValore());
		valoreDto.setVotoValore(valoreBean.getVotoValore());
		
		return valoreDto;
	}
	
	public ValoreBean toBean(ValoreDto valoreDto) {
		ValoreBean valoreBean = new ValoreBean();
		
		valoreBean.setIdValore(valoreDto.getIdValore());
		valoreBean.setNomeValore(valoreDto.getNomeValore());
		valoreBean.setVotoValore(valoreDto.getVotoValore());
		
		return valoreBean;
	}
}
