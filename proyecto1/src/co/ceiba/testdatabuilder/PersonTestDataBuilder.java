package co.ceiba.testdatabuilder;

import co.ceiba.service.Persona;

public class PersonTestDataBuilder {
	
	private String name;
	private String lastName;
	
	public PersonTestDataBuilder() {
		
		this.name="Ceiba";
		this.lastName="Software";
	}
	
	public PersonTestDataBuilder withName(String name) {
		this.name=name;
		return this;
	}
	
	public PersonTestDataBuilder withLastName(String lastName) {
		this.lastName=lastName;
		return this;
	}
	
	public Persona build() {
		return new Persona(this.name,this.lastName);
	}

}
