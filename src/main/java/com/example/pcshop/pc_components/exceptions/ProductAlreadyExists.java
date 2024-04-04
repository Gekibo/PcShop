package com.example.pcshop.pc_components.exceptions;

public class ProductAlreadyExists extends RuntimeException {
    public ProductAlreadyExists(String message){
        super(message);
    }
}
