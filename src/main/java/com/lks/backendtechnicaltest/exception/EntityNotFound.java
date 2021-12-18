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
public class EntityNotFound extends RuntimeException {

    public EntityNotFound(String message) {
        super(message);
    }
}
