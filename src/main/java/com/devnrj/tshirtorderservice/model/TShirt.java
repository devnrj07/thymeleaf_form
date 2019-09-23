package com.devnrj.tshirtorderservice.model;

import lombok.Data;

@Data
public class TShirt {

	String fullName;
	String address;
	String dateOfBirth;
    String color;
    boolean designType;
    String[] multiCheckboxSelectedValues;
    String radioButtonSelectedValue;
    String dropdownSelectedValue;
}
