/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dms.repository;

import java.util.List;

/**
 *
 * @author Javidan
 * @param <Type>
 */
public interface QueryRepository<Type, ID> {
    
    Type save(Type type);
    
    Type getById(ID id);
    
    List<Type> getAll();
    
    boolean delete(Type type);
    
    Type update(Type type);
}
