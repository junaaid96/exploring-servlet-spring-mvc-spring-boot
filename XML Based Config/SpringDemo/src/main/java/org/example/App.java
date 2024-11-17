package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        // Creating container
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        // Getting the bean which is created by spring boot.
        // Retrieves the bean by its class type. It assumes that there is only one bean of type Alien in the Spring context. If there are multiple beans of the same type, this will throw an exception.
//        Alien alien = context.getBean(Alien.class);
        // Retrieves the bean by its class type. It assumes that there is only one bean of type Alien in the Spring context. If there are multiple beans of the same type, this will throw an exception.
        Alien alien = (Alien) context.getBean("alien");
        //    	alien.setAge(21);
        System.out.println(alien.getAge());

        alien.code();
    }
}
