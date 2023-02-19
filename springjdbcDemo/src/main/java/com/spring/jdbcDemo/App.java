package com.spring.jdbcDemo;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.jdbcDemo.dao.StudentDao;
import com.spring.jdbcDemo.model.Student;

public class App 
{
    public static void main( String[] args )
    {
       
        ApplicationContext context=new ClassPathXmlApplicationContext("com/spring/jdbcDemo/config.xml");
        StudentDao studentDao=context.getBean("studentDao",StudentDao.class);
        
//        insert
//        Student student=new Student();
//       student.setId(102);
//        student.setName("Pragya");
//        student.setCity("Delhi");
//
//      int result=studentDao.insert(student);
//      System.out.println("Value inserted");
        
//      update
//      Student student=new Student();
//      student.setId(102);
//      student.setName("Amisha");
//      student.setCity("Hyderabad");
//      
//      int result=studentDao.modify(student);
//      System.out.println(result+" Updated Successfully");
//      
      //delete
//      Student student=new Student();
//      student.setId(102);
//      int result=studentDao.delete(student);
//      System.out.println(result+" Deleted Successfully");
        
      //select one row
      List<Student>student=studentDao.getAllStudents();
      for(Student stud:student) {
    	  System.out.println(stud);
      }
    }
}
