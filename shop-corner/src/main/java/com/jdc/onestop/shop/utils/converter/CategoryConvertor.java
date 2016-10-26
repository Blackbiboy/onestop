package com.jdc.onestop.shop.utils.converter;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;

import com.jdc.onestop.shop.entity.Category;

@Named
@RequestScoped
public class CategoryConvertor implements Converter {

	@Inject
	private List<Category> allCategory;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {

		if (null != value) {
			for (Category category : allCategory) {
				if (category.getName().equals(value)) {
					return category;
				}
			}
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (null != value) {
			Category c = (Category) value;
			return c.getName();

		}
		return null;
	}

}
