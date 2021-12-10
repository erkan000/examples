package app.schema.registy;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SchemaPojo {
	
	private String type;
	private Fields[] fields;

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Fields[] getFields() {
		return fields;
	}
	public void setFields(Fields[] fields) {
		this.fields = fields;
	}
}

@JsonIgnoreProperties(ignoreUnknown = true)
class Fields{
	private String[] type;
	private String name;


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String[] getType() {
		return type;
	}
	public void setType(String[] type) {
		this.type = type;
	}
}
