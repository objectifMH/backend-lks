/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lks.backendtechnicaltest.exception;

/**
 *
 * @author omh
 */

public class ResourceNotFoundException extends RuntimeException {
    
    private final String resourceName;
    private final String fieldName;
    private final Object fieldValue;


    public ResourceNotFoundException(String resourceName, String fieldName, Object fieldValue) {
        super(String.format("%s with %s : %s not found !", resourceName, fieldName, fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }
    
    

}
