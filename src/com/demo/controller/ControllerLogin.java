/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.controller;

import com.demo.model.ModeloUsuario;
import com.demo.model.entity.Usuario;

/**
 *
 * @author whiston
 */
public class ControllerLogin extends Controller {
    
    public ControllerLogin(){
    
    }
    
    public boolean logIn(String usuario, String clave){
        boolean band = false;
        
        Usuario user = new Usuario(usuario, clave);
        
        band = ModeloUsuario.logIn(user);
        
        return band;
    }
    
    
    public long logUp(){
        long status = 0;
        
        return status;
    }
    
    public long RecuperarClave(){
        long status = 0;
        
        return status;
    }
    
}
