package br.com.jloja.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class MsgUtil {

	public static void msgInfo(String mensagem){
		FacesMessage facesmsg = new FacesMessage(FacesMessage.SEVERITY_INFO, mensagem, mensagem);
		FacesContext facesContext = FacesContext.getCurrentInstance(); facesContext.addMessage(null, facesmsg);
	
	}
	
	public static void msgErro(String mensagem){
		FacesMessage facesmsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, mensagem, mensagem);
		FacesContext facesContext = FacesContext.getCurrentInstance(); facesContext.addMessage(null, facesmsg);
	}

}
