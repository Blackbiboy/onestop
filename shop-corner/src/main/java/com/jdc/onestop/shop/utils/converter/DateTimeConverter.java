package com.jdc.onestop.shop.utils.converter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.enterprise.inject.Model;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

@Model
public class DateTimeConverter implements Converter {
	
	private DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {

		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {

		if(null != value) {
			return df.format(value);
		}
		return null;
	}

}
