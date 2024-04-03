package com.example.newcalculator;

public class Operations {
    private double firstNumber;
    private double secondNumber;

    public Operations(double firstNumber, double secondNumber) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
    }

    public double sum(){
        return firstNumber+secondNumber;
    }

    public double min(){
        return firstNumber-secondNumber;
    }

    public double multiply(){
        return firstNumber*secondNumber;
    }

    public double divide(){
        return firstNumber/secondNumber;
    }

}
