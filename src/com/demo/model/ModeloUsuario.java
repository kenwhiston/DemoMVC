/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.model;

import com.demo.model.entity.Usuario;

/**
 *
 * @author whiston
 */
public class ModeloUsuario extends Model {
    
    static public boolean logIn(Usuario user){
        boolean band= false;
        
        if(user.getEmail().compareTo("admin@gmail.com") == 0 &&
                user.getClave().compareTo("123456") == 0){
            band = true;
        }else{
            band = false;
        }
        
        return band;
    }
    
}
