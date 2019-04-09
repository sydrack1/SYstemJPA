/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guru.edu.sydrack.model.dao;

import guru.edu.sydrack.connection.ConnectionFactory;
import guru.edu.sydrack.model.bean.JobTitle;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 *
 * @author Sadrac
 */
public class JobTitleDAO {
    public JobTitle save(JobTitle jt ){
        EntityManager em = new ConnectionFactory().getConnection();
        EntityTransaction et = em.getTransaction();
        
        try{
            
            et.begin();
            if(jt.getId() == 0){
                em.persist(jt);
            }else{
                em.merge(jt);
            }
            et.commit();
            
        }catch(Exception e){
            System.err.println(e);
            et.rollback();
        }finally{
            em.close();
            ConnectionFactory.closeConnection();
        }
        
        return jt;
    }
    
    public List<JobTitle> findAll(){
        EntityManager em = new ConnectionFactory().getConnection();
        List<JobTitle> job_titles = null;
        
        try{
            
            job_titles = em.createQuery("from JobTitle j").getResultList();
            
        }catch(Exception e){
            System.err.println(e);
        }finally{
            em.close();
        }
        return job_titles;
    }
    
    public JobTitle findById(Integer id){
        EntityManager em = new ConnectionFactory().getConnection();
        JobTitle jt = null;
        
        try{
            jt = em.find(JobTitle.class, id);
        }catch(Exception e){
            System.err.println(e);
        }finally{
            em.close();
        }
        
        return jt;
    }
    public JobTitle remove(Integer id){
        EntityManager em = new ConnectionFactory().getConnection();
        EntityTransaction et = em.getTransaction();
        JobTitle jt = null;
        
        try{
            et.begin();
            jt = em.find(JobTitle.class, id);
            em.remove(jt);
            et.commit();
        }catch(Exception e){
            System.err.println(e);
            et.rollback();
        }finally{
            em.close();
        }
        
        return jt;
    }
}
