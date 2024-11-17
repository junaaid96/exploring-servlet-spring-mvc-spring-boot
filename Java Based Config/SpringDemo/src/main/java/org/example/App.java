package org.example;

import org.example.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

//        Desktop dt = context.getBean("desk1", Desktop.class);
//        dt.compile();
//
//        Laptop lp = context.getBean(Laptop.class);
//        lp.compile();
//
//        Laptop lp1 = context.getBean(Laptop.class);
//        lp1.compile();

        Alien alien = context.getBean(Alien.class);
        System.out.println(alien.getAge());
        alien.code();


    }
}
