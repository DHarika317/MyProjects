package org.javahd.spring;

import org.javahd.spring.bean.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	//ApplicationContext is a bean container
    	//AbstractApplicationContext to handle destroy method which ApplicationContext cannot handle
    	AbstractApplicationContext appcxt = new ClassPathXmlApplicationContext("spring.xml");
    	appcxt.registerShutdownHook();// while shutting down spring framework the spring container looks for destroy method of beans
        System.out.println( "Welcome to Spring Framework");
        //calling object s1 from spring bean container/ injecting the bean into your class
        Student s1 = (Student)appcxt.getBean("s1");
        System.out.println(s1);
        Student s2 = (Student)appcxt.getBean("s2");
        System.out.println(s2);
        Student s3 = (Student)appcxt.getBean("s3");
        System.out.println(s3);
    }
}
