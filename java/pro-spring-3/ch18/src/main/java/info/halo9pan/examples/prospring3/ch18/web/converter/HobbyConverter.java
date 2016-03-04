/**
 * Created on Dec 29, 2011
 */
package info.halo9pan.examples.prospring3.ch18.web.converter;

import info.halo9pan.examples.prospring3.ch18.domain.Hobby;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 * @author Clarence
 *
 */
@FacesConverter("hobby")
public class HobbyConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext ctx, UIComponent component, String value) {
		return new Hobby(value);
	}

	@Override
	public String getAsString(FacesContext ctx, UIComponent component, Object value) {
		return (String) value;
	}

}
