package com.spring.orm;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.spring.orm.dao.StudentDao;
import com.spring.orm.entity.Student;
import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.spring.orm.entity.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args)
    {
        System.out.println("Menu Driven Using ORM");
      
  
    	 ApplicationContext cnt=
          		  new ClassPathXmlApplicationContext("com/spring/orm/config.xml"); 
    	
    	 StudentDao studentDao=cnt.getBean("studentDao",StudentDao.class);
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
  boolean go=true;
    	while(go)
   {
    System.out.println(" Press 1 for add new Student ");
    System.out.println(" Press 2 for display All Data");
    System.out.println(" Press 3 search");
    System.out.println(" Press 4 Delete data ");
    System.out.println(" Press 5 Update data");
    System.out.println(" Press 6 Exit");
   
   try
   {
	   int input=Integer.parseInt(br.readLine());
	   switch (input)
	   {
	case 1:
		System.out.println("\nEnter User Name ");
		String name=br.readLine();
		
		System.out.println("\nEnter User Id ");
		int id=Integer.parseInt(br.readLine());
				
		System.out.println("\nEnter User City ");
		String city=br.readLine();
		
		Student s=new Student();
		s.setStudentid(id);
		s.setStudentCity(city);
		s.setStudentName(name);
		
		int r=studentDao.insert(s);
		System.out.println("Data Added "+r);
		break;
	case 2:
		List<Student> allStudent=studentDao.getallStudent();
		for(Student st:allStudent)
		{
			System.out.println("\nName: "+st.getStudentName());
			System.out.println("Id: "+st.getStudentid());
			System.out.println("City: "+st.getStudentCity());
			System.out.println("------------");
		}
		break;
	case 3:
		
		System.out.println("\nEnter User Id ");
		int uid=Integer.parseInt(br.readLine());
		Student std=studentDao.getStudent(uid);
		
		System.out.println("\nName: "+std.getStudentName());
		System.out.println("Id: "+std.getStudentid());
		System.out.println("City: "+std.getStudentCity());
		System.out.println("------------");
		break;
	case 4:
		System.out.println("\nEnter User Id ");
		int sid=Integer.parseInt(br.readLine());
		
		studentDao.deleteStudent(sid);
		System.out.println("Record Deleted");
		System.out.println("------------");
		break;
	case 5:
		System.out.println("\nEnter User Name ");
		String sname=br.readLine();
		
		System.out.println("\nEnter User Id ");
		int sd=Integer.parseInt(br.readLine());
				
		System.out.println("\nEnter User City ");
		String scity=br.readLine();
		
		Student sds=new Student();
		sds.setStudentid(sd);
		sds.setStudentCity(scity);
		sds.setStudentName(sname);
		
		studentDao.updateStudent(sds);
		System.out.println("Data Updated "+sds);
		break;
	case 6:
		go=false;
		break;
	}
   }
  catch(Exception e)
   {
    	System.out.println("Invalid input try with another");
    	System.out.println(e.getMessage());
   }
    
  }
    	System.out.println("Thank YOU");
   }
}
