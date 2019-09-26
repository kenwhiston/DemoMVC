/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.model;

import com.demo.model.entity.Usuario;
import java.util.Iterator;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author whiston
 */
public class ModeloUsuario extends Model {
    
    static public boolean logIn(Usuario user){
        boolean band= false;
        Session session = null;
        try{
            
            //creamos el objeto factory de hibernate
            SessionFactory sessionFactory = new org.hibernate.cfg.Configuration().configure().buildSessionFactory();
            session =sessionFactory.openSession();
            session.beginTransaction();

            //armamos la consulta HQL
            String HQL_QUERY ="from Usuario user where user.email = :userEmail and user.clave = :userClave";
            org.hibernate.Query query = session.createQuery(HQL_QUERY);
            //Preparar query statement
            query.setParameter("userEmail",user.getEmail());
            query.setParameter("userClave", user.getClave());
            
            System.out.println("Reading values");
            for(Iterator it=query.iterate();it.hasNext();){
                com.demo.model.persistencia.Usuario usuario = (com.demo.model.persistencia.Usuario) it.next();
                System.out.println(usuario.getEmail());
                band = true;
            }
            session.getTransaction().commit();
            System.out.println("Done!");
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        finally{
          session.flush();
          session.close();
        }
        
        
        
        
        /*if(user.getEmail().compareTo("admin@gmail.com") == 0 &&
                user.getClave().compareTo("123456") == 0){
            band = true;
        }else{
            band = false;
        }*/
        
        return band;
    }
    
}
