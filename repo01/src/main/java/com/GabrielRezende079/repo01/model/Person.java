package com.GabrielRezende079.repo01.model;

import java.io.Serializable;
import java.util.Objects;


// Model class for Person 
// It implements Serializable to allow the conversion of an object into a byte stream
// This is useful for saving the object to a file or sending it over a network

public class Person implements Serializable {
    private static final long serialVersionUID = 1L;

    // Attributes
    private Long id;
    private String FirstName;
    private String LastName;
    private String Address;
    private String Gender;

    // Constructor to initialize a Person object
    public Person(){}


    // Getters and Setters for each attribute
    // ID ---------------------------------------------------------------
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }


    // First Name --------------------------------------------------------
    public String getFirstName() {
        return FirstName;
    }
    public void setFirstName(String firstName) {
        this.FirstName = firstName;
    }


    // Last Name ---------------------------------------------------------
    public String getLastName() {
        return LastName;
    }
    public void setLastName(String lastName) {
        this.LastName = lastName;
    }


    // Address ----------------------------------------------------------
    public String getAddress() {
        return Address;
    }
    public void setAddress(String address) {
        this.Address = address;
    }


    // Gender -----------------------------------------------------------
    public String getGender() {
        return Gender;
    }
    public void setGender(String gender) {
        this.Gender = gender;
    } 

    // Override methods for equality check and hash code generation 
    // isso é importante para comparar objetos e usá-los em coleções baseadas em hash
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Person person)) return false;
        return Objects.equals(getId(), person.getId()) && Objects.equals(getFirstName(), person.getFirstName()) && Objects.equals(getLastName(), person.getLastName()) && Objects.equals(getAddress(), person.getAddress()) && Objects.equals(getGender(), person.getGender());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFirstName(), getLastName(), getAddress(), getGender());
    }

}
