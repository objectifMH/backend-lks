/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lks.backendtechnicaltest.service;

import com.lks.backendtechnicaltest.entity.Director;
import java.util.List;

/**
 *
 * @author omh
 */
public interface DirectorService {
    
    List<Director> findAll();
    
    Director save(Director director);
    
    Director findById(Integer id);
    
    Director findByName(String name);
    
    List<Director> findDirectorsByName(String name);
    
    void deleteById(Integer id);
}
