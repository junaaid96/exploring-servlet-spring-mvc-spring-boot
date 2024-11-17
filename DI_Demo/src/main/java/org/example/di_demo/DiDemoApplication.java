package org.example.di_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DiDemoApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(DiDemoApplication.class, args);

        Alien1 obj = context.getBean(Alien1.class);
        obj.code();

        Alien1 obj2 = context.getBean(Alien1.class);
        obj2.code();

        System.out.println(obj.hashCode());
        System.out.println(obj2.hashCode());
    }


}
