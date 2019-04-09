/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guru.edu.sydrack.model.dao;

import guru.edu.sydrack.connection.ConnectionFactory;
import guru.edu.sydrack.model.bean.Employee;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

/**
 *
 * @author Sadrac
 */
public class EmployeeDAO {
    
    public Employee saveAndUpdate(Employee emp){
        EntityManager em = new ConnectionFactory().getConnection();
        EntityTransaction et = em.getTransaction();
        
        try{
            et.begin();
            if(emp.getId() == null){
                em.persist(emp);
            }else{
                em.merge(emp);
           }
            et.commit();
        }catch(Exception e){
            System.err.println(e);
            et.rollback();
        }finally{
            em.close();
           ConnectionFactory.closeConnection();
        }
        
        return emp;
    }
    
    public Employee findById(Integer id){
        EntityManager em = new ConnectionFactory().getConnection();
        Employee emp = null;
        try{
            emp = em.find(Employee.class, id);
        }catch(Exception e){
            System.err.println(e);
        }finally{
            em.close();
        }
        
        return emp;
    }
    
    public List<Employee> findAll(){
        EntityManager em = new ConnectionFactory().getConnection();
        List<Employee> employees = null;
        
        try{
            employees = em.createQuery("from Employee e").getResultList();
        }catch(Exception e){
            System.err.println(e);
        }finally{
            em.close();
        }
        
        return employees;
    }
    
    public Employee remove(Integer id){
        EntityManager em = new ConnectionFactory().getConnection();
        EntityTransaction et = em.getTransaction();
        Employee emp = null;
        try{
            et.begin();
            emp = em.find(Employee.class, id);
            em.remove(emp);
            et.commit();
        }catch(Exception e){
            System.err.println(e);
            et.rollback();
        }finally{
            em.close();
        }
        
        return emp;
    }
    
}
