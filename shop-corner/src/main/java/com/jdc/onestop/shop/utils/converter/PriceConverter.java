package com.jdc.onestop.shop.utils.converter;

import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;

import javax.enterprise.inject.Model;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;

import com.jdc.onestop.shop.entity.Price;
import com.jdc.onestop.shop.utils.PriceUtils;

@Model
public class PriceConverter implements Converter {
	
	@Inject
	private PriceUtils priceUtils;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {

		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		
		if(null != value) {
			@SuppressWarnings("unchecked")
			List<Price> list = (List<Price>) value;
			Price p = priceUtils.getCurrentPrice(list);
			DecimalFormat df = new DecimalFormat("###,###,###.00 MMK");
			return df.format(p.getPrice());
		}
		
		return null;
	}
	

}
