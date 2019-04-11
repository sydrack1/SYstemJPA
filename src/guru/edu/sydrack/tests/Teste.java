/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guru.edu.sydrack.tests;

import guru.edu.sydrack.connection.ConnectionFactory;
import guru.edu.sydrack.converter.LocalDateAttributeConverter;
import guru.edu.sydrack.model.bean.JobTitle;

import guru.edu.sydrack.model.bean.Employee;
import guru.edu.sydrack.model.dao.EmployeeDAO;
import java.time.LocalDate;
import java.util.Date;

//import guru.edu.sydrack.model.dacdo.JobTitleDAO;

/**
 *
 * @author Sydrack
 */
public class Teste {
    public static void main(String[] args) {
        // REMOVE-----REMOVE FUNCIONÁRIO-----EMPLOYEE
        int id = 1;
        EmployeeDAO eDAO = new EmployeeDAO();
        eDAO.remove(id);
        ConnectionFactory.closeConnection();
        /*  BUSCA-----FIND FUNCIONÁRIO-----EMPLOYEE
        * //int id = 1;
        *EmployeeDAO eDAO = new EmployeeDAO();
        * //System.out.println("Nome: "+eDAO.findById(id).getName()+" Cargo: "+eDAO.findById(id).getJob_title().getName());
        *eDAO.findAll().forEach(emp -> {
        *    System.out.println("ID: "+emp.getId()+" Nome: "+emp.getName()+" Cargo: "+emp.getJob_title().getName());
        *});
        *ConnectionFactory.closeConnection();
        */
                
                
        /* CRIA E ATUALIZA------CREATE AND UPDATE  FUNCIONÁRIO-----EMPLOYEE
        JobTitle jt = new JobTitle();
        jt.setId(1);
        Employee e = new Employee();
        EmployeeDAO eDAO = new EmployeeDAO();
        e.setId(2);
        e.setName("Teste update");
            // DATA NASCIMENTO
        String date_string = "28/03/1979";
        String[] date_preformated = date_string.split("/");
        LocalDate date_nasciment = LocalDate.of(Integer.parseInt(date_preformated[2]), Integer.parseInt(date_preformated[1]), Integer.parseInt(date_preformated[0]));
        Date ldac =new LocalDateAttributeConverter().convertToDatabaseColumn(date_nasciment);
        e.setData_nascimento(ldac);
            // DATA ADMISSÃO
        String date_str = "04/12/2018";
        String[] date_preformated_nasc = date_str.split("/");
        LocalDate date_admission = LocalDate.of(Integer.parseInt(date_preformated_nasc[2]), Integer.parseInt(date_preformated_nasc[1]), Integer.parseInt(date_preformated_nasc[0]));
        Date admissao =new LocalDateAttributeConverter().convertToDatabaseColumn(date_admission);
        e.setData_admissao(admissao);
            //
        e.setJob_title(jt);
        eDAO.saveAndUpdate(e);
        */
        
        
       /* BUSCA-----FIND  CARGO------JOB TITLE
        *JobTitle jt = new JobTitle();
//      *  JobTitleDAO jtDAO = new JobTitleDAO();
//      *  jt.setId(2);
//      *  jt.setName("Ajudante de pedreiro");
//      *  jtDAO.save(jt);
//      *  jtDAO.findAll().forEach(jt -> {
//      *      System.out.println("Nome: "+jt.getName()+" ID: "+jt.getId());
////    *    });
//      *  System.out.println("Nome: "+jtDAO.findById(2).getName()+" ID: "+jtDAO.findById(2).getId());
        *  REMOVE-----REMOVE   CARGO------JOB TITLE
        * jtDAO.remove(2);
        */ 
       
    }
}
