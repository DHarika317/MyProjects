package org.javahd.spring.aop;

import org.javahd.spring.bean.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext cxt = new ClassPathXmlApplicationContext("spring.xml");
		Student s1 = (Student)cxt.getBean("s1");
		System.out.println(s1.getName()+ " " + s1.getRollno()+ " " + s1.getDept()+ " " + s1.getFee());
		

	}

}
