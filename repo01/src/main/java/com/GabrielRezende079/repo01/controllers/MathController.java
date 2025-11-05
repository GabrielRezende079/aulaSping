package com.GabrielRezende079.repo01.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.GabrielRezende079.repo01.exception.UnsupportedMathOperationException;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/math") // http://localhost:8080/math
public class MathController {

    // http://localhost:8080/math/sum

    //http://localhost:8080/math/sum/5/3 for example

    //explanation of @PathVariable: it binds the method parameters to the values passed in the URL path
    @RequestMapping("/sum/{numberOne}/{numberTwo}")
    public double sum( 
        @PathVariable("numberOne") String numberOne, 
        @PathVariable("numberTwo") String numberTwo
        ) throws Exception { 
        
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        return convertToDouble(numberOne)  + convertToDouble(numberTwo);
    }   

    // Subtraction
    @RequestMapping("/sub/{numberOne}/{numberTwo}")
    public double subtract( 
        @PathVariable("numberOne") String numberOne, 
        @PathVariable("numberTwo") String numberTwo
        ) throws Exception { 
        
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        return convertToDouble(numberOne) - convertToDouble(numberTwo);
    }

    // Multiplication
    @RequestMapping("/mult/{numberOne}/{numberTwo}")
    public double Multiplication( 
        @PathVariable("numberOne") String numberOne, 
        @PathVariable("numberTwo") String numberTwo
        ) throws Exception { 
        
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        return convertToDouble(numberOne) * convertToDouble(numberTwo);
    }

    // Division
    @RequestMapping("/div/{numberOne}/{numberTwo}")
    public double Division(
        @PathVariable("numberOne")String numberOne,
        @PathVariable("numberTwo")String numberTwo
        ) throws Exception {
         
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        return convertToDouble(numberOne) / convertToDouble(numberTwo);

        }

    // Avarage
    @RequestMapping("/avarage/{numberOne}/{numberTwo}")    
    public double avarage(
        @PathVariable("numberOne") String numberOne, 
        @PathVariable("numberTwo") String numberTwo
        ) throws Exception { 
        
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        return (convertToDouble(numberOne) + convertToDouble(numberTwo)) / 2;
    }
    
    // Square Root
    @RequestMapping("/squareRoot/{number}")
    public double squareRoot(
        @PathVariable("number") String number
    ) throws Exception {

        if (!isNumeric(number)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        return Math.sqrt(convertToDouble(number));
    }
    


    // this method converts a string to a double for math operations and also handles comma as decimal separator
    private double convertToDouble(String strNumber){
        if(strNumber == null || strNumber.isEmpty()){
             throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        String number = strNumber.replace(",",".");
        return Double.parseDouble(number);
    }


    // this method checks if a string is numeric or not
    private boolean isNumeric(String strNumber) {

        if(strNumber == null || strNumber.isEmpty()){
            return false;
        }
        String number = strNumber.replace(",",".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }
}
