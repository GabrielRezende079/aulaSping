package com.GabrielRezende079.repo01.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.http.MediaType;

import com.GabrielRezende079.repo01.Services.PersonServices;
import com.GabrielRezende079.repo01.model.Person;



@RestController
@RequestMapping("/person")
public class PersonController {

    
    @Autowired
   private PersonServices sevices;
    // private final PersonServices service = new PersonServices();


    // http://localhost:8080/person
    // API to get all persons GET
    @RequestMapping(  
    method = RequestMethod.GET, 
    produces = MediaType.APPLICATION_JSON_VALUE)  // specify that the return type is JSON
    public List<Person> findAll(){
        return sevices.findAll(String.valueOf(Person.class)); //  casting to String to fix the error
        
    }


    // http://localhost:8080/person/{id}
    // API to get person by id GET
    @RequestMapping( value = "/{id}", 
    method = RequestMethod.GET,
    produces = MediaType.APPLICATION_JSON_VALUE) 
    // Get person by id
    public Person findById(@PathVariable("id")String id){
        return sevices.findById(id);
    }


    // API to create person POST
    @RequestMapping(
    method = RequestMethod.POST, 
    produces = MediaType.APPLICATION_JSON_VALUE) 
    // Get person by id
    public Person createPerson(@RequestBody Person person){
        return sevices.createPerson(person);
    }
    /*  Example of JSON to create a person
    
    {
    "firstName" : "Gabriel",
    "lastName" :"Rezende",
    "address":"Brazil",
    "gender" : "Male"
    }

     */


    // API to update person PUT/EDIT
    @RequestMapping(
    method = RequestMethod.PUT, 
    produces = MediaType.APPLICATION_JSON_VALUE) 
    // Its the same as using "Get person by id"
    public Person updatingPerson(@RequestBody Person person){
        return sevices.updatingPerson(person);
    }

    // API to delete person DELETE
    @RequestMapping( value = "/{id}", 
    method = RequestMethod.DELETE) 
    //Over again, same as "Get person by id"
    public void DeletingPerson(@PathVariable("id")String id){
        sevices.DeletingPerson(id);
    }

}
