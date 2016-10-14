package com.jdc.shout.model.converter;

import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;

import com.jdc.shout.entity.Category;
import com.jdc.shout.repository.CategoryRepository;

@Named
@RequestScoped
public class CategoryConverter implements Converter{

	@Inject
	private CategoryRepository repo;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if(null != value) {
			int id = Integer.parseInt(value);
			return repo.findById(id);
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(null != value) {
			Category cat = (Category) value;
			return String.valueOf(cat.getId());
		}
		return null;
	}

}
