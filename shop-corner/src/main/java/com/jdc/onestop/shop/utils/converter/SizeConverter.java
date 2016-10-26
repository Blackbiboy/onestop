package com.jdc.onestop.shop.utils.converter;

import javax.enterprise.inject.Model;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import com.jdc.onestop.shop.entity.Product.Size;

@Model
public class SizeConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if(null != value) {
			return Size.valueOf(value);
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(null != value) {
			return value.toString();
		}
		return null;
	}

}
