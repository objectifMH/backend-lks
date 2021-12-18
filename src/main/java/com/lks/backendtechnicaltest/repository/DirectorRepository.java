/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lks.backendtechnicaltest.repository;

import com.lks.backendtechnicaltest.entity.Director;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author omh
 */
public interface DirectorRepository extends JpaRepository<Director, Integer> {

    public Director findByName(String name);

    public Optional<Director> findByNameIgnoreCase(String name);
    
    public List<Director> findByNameContainingIgnoreCase(String name);
}
