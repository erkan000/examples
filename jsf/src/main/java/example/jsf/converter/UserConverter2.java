package example.jsf.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import example.jsf.pojos.User;

@FacesConverter("UserConverter2")
public class UserConverter2 implements Converter<User>{

	@Override
	public User getAsObject(FacesContext context, UIComponent component, String userValue) {
		System.out.println("Obj " + userValue); 
		User u = new User();
		if(userValue.equals("Name 1")) {
			u.setName("admin");
			u.setSurname("admin surname");
		}else if(userValue.equals("Name 2")) {
			u.setName("user");
			u.setSurname("user surname");
		}
		return u;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, User uu) {
		System.out.println("Str " + uu);
		if(uu != null) {
			return uu.getName();
		}else {
			return null;
		}
	}



	

}
