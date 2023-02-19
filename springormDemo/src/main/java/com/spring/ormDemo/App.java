package com.spring.ormDemo;

import java.util.List;
import java.util.Scanner;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm.dao.StudentDao;
import com.spring.orm.model.Student;

public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context=new ClassPathXmlApplicationContext("config.xml");
        StudentDao studentDao=context.getBean("studentDao",StudentDao.class);
        
        boolean ch=true;
        while(ch) {
        	System.out.println("Press 1 to add new student");
        	System.out.println("Press 2 to display student detail");
        	System.out.println("Press 3 to display all student");
        	System.out.println("Press 4 for deleting student");
        	System.out.println("Press 5 for updating student");
        	System.out.println("Press 6 to exit");
        	System.out.println("Enter choice");
        	try {
	        	Scanner scan=new Scanner(System.in);
	        	int choice=scan.nextInt();
	        	switch (choice) {
				case 1:
					System.out.println("Enter student Id: ");
					int sId=scan.nextInt();
					System.out.println("Enter student name: ");
					String sName=scan.next();
					System.out.println("Enter student city: ");
					String sCity=scan.next();
					Student s1=new Student();
					s1.setId(sId);
					s1.setName(sName);
					s1.setCity(sCity);
					int r=studentDao.insert(s1);
					System.out.println(r+" student added");
					break;
				case 2:
					System.out.println("Enter student id:");
					int id=scan.nextInt();
					System.out.println(studentDao.getStudent(id));
					break;
				case 3:
					List<Student>studList=studentDao.getAllStudents();
					for(Student s:studList) {
						System.out.println(s);
					}
					break;
				case 4:
					System.out.println("Enter student id:");
					int studId=scan.nextInt();
					studentDao.delete(studId);
					System.out.println("Record Deleted Successfully");
					break;
				case 5:
					System.out.println("Enter student Id: ");
					int sId1=scan.nextInt();
					System.out.println("Enter student name: ");
					String sName1=scan.next();
					System.out.println("Enter student city: ");
					String sCity1=scan.next();
					Student s2=new Student();
					s2.setId(sId1);
					s2.setName(sName1);
					s2.setCity(sCity1);
					studentDao.update(s2);
					System.out.println("Record Updated Successfully");
					break;
				case 6:
					ch=false;
					break;
				default:
					break;
				}
        	}catch(Exception e) {
        		System.out.println("Invalid Input");
        		System.out.println(e.getMessage());
        	}
        }
    }
}
