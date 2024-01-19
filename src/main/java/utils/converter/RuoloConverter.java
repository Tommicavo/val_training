package utils.converter;

import model.bean.RuoloBean;
import model.dto.RuoloDto;

public class RuoloConverter {
	
	public RuoloDto toDto(RuoloBean ruoloBean) {
		RuoloDto ruoloDto = new RuoloDto();
		
		ruoloDto.setIdRuolo(ruoloBean.getIdRuolo());
		ruoloDto.setNomeRuolo(ruoloBean.getNomeRuolo());
		
		return ruoloDto;
	}
	
	public RuoloBean toBean(RuoloDto ruoloDto) {
		RuoloBean ruoloBean = new RuoloBean();
		
		ruoloBean.setIdRuolo(ruoloDto.getIdRuolo());
		ruoloBean.setNomeRuolo(ruoloDto.getNomeRuolo());
		
		return ruoloBean;
	}
}
