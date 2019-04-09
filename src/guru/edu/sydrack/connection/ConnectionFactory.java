/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guru.edu.sydrack.connection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Sadrac
 */
public class ConnectionFactory {
    
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProjectJPAPU");
    
    public EntityManager getConnection(){
        return emf.createEntityManager();
    }
    public static void closeConnection(){
        emf.close();
    }
    
}
