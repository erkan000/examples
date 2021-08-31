package example.jsf.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("UserConverter")
public class UserConverter implements Converter<String>{

	@Override
	public String getAsObject(FacesContext context, UIComponent component, String value) {
		return "https://" + value;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, String value) {
		return value;
	}

	

}
