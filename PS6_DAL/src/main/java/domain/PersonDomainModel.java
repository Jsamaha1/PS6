package domain;


import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import util.LocalDateAdapter;

public class PersonDomainModel {

    private  UUID personID;
	protected  String firstName;
    protected  String lastName;
    protected  String street;
    protected  Integer postalCode;
    protected  String city;
    protected  Date birthday;

    /**
     * Default constructor.
     */
    public PersonDomainModel(){
    }
    
    public PersonDomainModel(String firstname, String lastname, String street,
    		Integer postalCode, String city, Date birthday) {
    	super();
    	this.setPersonID(UUID.randomUUID());
    	this.firstName = firstname;
    	this.lastName = lastname;
    	this.street = street;
    	this.postalCode = postalCode;
    	this.city = city;
    	this.birthday = birthday;
    }
    
    public PersonDomainModel(UUID personID) {
		super();
		this.personID = personID;		
	}

	public UUID getPersonID() {
		return this.personID;
	}
	public void setPersonID(UUID personID) {
		this.personID = personID;
	}

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String firstNameProperty() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String lastNameProperty() {
        return lastName;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String streetProperty() {
        return street;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public Integer postalCodeProperty() {
        return postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
       }

    public String cityProperty() {
        return city;
    }

    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date localDate) {
        this.birthday = localDate;
    }

    public Date birthdayProperty() {
        return birthday;
    }
}