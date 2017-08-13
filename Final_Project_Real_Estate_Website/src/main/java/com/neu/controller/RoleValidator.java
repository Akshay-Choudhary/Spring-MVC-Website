package com.neu.controller;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.neu.pojo.Person;

public class RoleValidator implements Validator {

	public boolean supports(Class aClass)
    {
        return aClass.equals(Person.class);
    }

    public void validate(Object obj, Errors errors)
    {
        
        //ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "error.invalid.firstName", "First Name Required");
        //ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "error.invalid.lastName", "Last Name Required");
        //ValidationUtils.rejectIfEmptyOrWhitespace(errors, "country", "error.invalid.country", "Country Name Required");
        //ValidationUtils.rejectIfEmptyOrWhitespace(errors, "city", "error.invalid.password", "City Name Required");
        //ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dateOfBirth", "error.invalid.dateOfBirth", "Date Of Birth Required");
        //ValidationUtils.rejectIfEmptyOrWhitespace(errors, "gender", "error.invalid.gender", "Gender Required");
        //ValidationUtils.rejectIfEmptyOrWhitespace(errors, "contactInfo", "error.invalid.contactInfo", "Address Required");
        //ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "error.invalid.email", "Email Required");
    }
}
