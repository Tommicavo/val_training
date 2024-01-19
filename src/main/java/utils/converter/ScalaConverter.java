package utils.converter;

import model.bean.ScalaBean;
import model.dto.ScalaDto;

public class ScalaConverter {
	
	public ScalaDto toDto(ScalaBean scalaBean) {
		ScalaDto scalaDto = new ScalaDto();
		
		scalaDto.setIdScala(scalaBean.getIdScala());
		scalaDto.setTitoloScala(scalaBean.getTitoloScala());
		scalaDto.setDescrizioneScala(scalaBean.getDescrizioneScala());
		
		return scalaDto;
	}
	
	public ScalaBean toBean(ScalaDto scalaDto) {
		ScalaBean scalaBean = new ScalaBean();
		
		scalaBean.setIdScala(scalaDto.getIdScala());
		scalaBean.setTitoloScala(scalaDto.getTitoloScala());
		scalaBean.setDescrizioneScala(scalaDto.getDescrizioneScala());
		
		return scalaBean;
	} 
}
