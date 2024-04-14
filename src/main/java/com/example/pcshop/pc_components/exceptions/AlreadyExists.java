package com.example.pcshop.pc_components.exceptions;

public class AlreadyExists extends RuntimeException {
    public AlreadyExists(String message){
        super(message);
    }
}
