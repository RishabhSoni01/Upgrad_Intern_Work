package org.example;

import java.util.ArrayList;
import java.util.Arrays;

public class MissingGradeException extends Exception{
    public MissingGradeException(String message){
        super(message);
    }
}