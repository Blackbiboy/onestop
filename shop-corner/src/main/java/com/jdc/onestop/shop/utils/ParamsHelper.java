package com.jdc.onestop.shop.utils;

import javax.faces.context.FacesContext;

public class ParamsHelper {
	public static String getParam(String name) {
		return FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get(name);
	}
}
