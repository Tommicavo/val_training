package utils.converter;

import model.bean.SezioneBean;
import model.dto.SezioneDto;

public class SezioneConverter {
	
	public SezioneDto toDto(SezioneBean sezioneBean) {
		SezioneDto sezioneDto = new SezioneDto();
		
		sezioneDto.setIdSezione(sezioneBean.getIdSezione());
		sezioneDto.setTitoloSezione(sezioneBean.getTitoloSezione());
		
		return sezioneDto;
	}
	
	public SezioneBean toBean(SezioneDto sezioneDto) {
		SezioneBean sezioneBean = new SezioneBean();
		
		sezioneBean.setIdSezione(sezioneDto.getIdSezione());
		sezioneBean.setTitoloSezione(sezioneDto.getTitoloSezione());

		return sezioneBean;
	}
}
