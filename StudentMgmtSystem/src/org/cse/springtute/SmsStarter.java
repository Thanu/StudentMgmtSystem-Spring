package org.cse.springtute;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class SmsStarter {

    public static void main(String[] args) {
        StudentManagementSystem sms;// = new StudentManagementSystem();
        //load the bean from spring        
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        context.start();
        Student stu = (Student) context.getBean("stu");
        
        sms = (StudentManagementSystem) context.getBean("sms");
        sms.listAllStudents();
        sms.registerStudent(stu);
        sms.listAllStudents();

    }
}
