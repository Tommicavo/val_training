package utils.converter;

import model.bean.ParagrafoBean;
import model.dto.ParagrafoDto;

public class ParagrafoConverter {
	
	public ParagrafoDto toDto(ParagrafoBean paragrafoBean) {
		ParagrafoDto paragrafoDto = new ParagrafoDto();
		
		paragrafoDto.setIdParagrafo(paragrafoBean.getIdParagrafo());
		paragrafoDto.setTitoloParagrafo(paragrafoBean.getTitoloParagrafo());
		paragrafoDto.setDescrizioneParagrafo(paragrafoBean.getDescrizioneParagrafo());
		
		return paragrafoDto;
	}
	
	public ParagrafoBean toBean(ParagrafoDto paragrafoDto) {
		ParagrafoBean paragrafoBean = new ParagrafoBean();
		
		paragrafoBean.setIdParagrafo(paragrafoDto.getIdParagrafo());
		paragrafoBean.setTitoloParagrafo(paragrafoDto.getTitoloParagrafo());
		paragrafoBean.setDescrizioneParagrafo(paragrafoDto.getDescrizioneParagrafo());
		
		return paragrafoBean;
	}
}
