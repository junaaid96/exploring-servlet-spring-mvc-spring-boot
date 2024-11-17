package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Alien {

    @Value("25")
    private int age;

    //    @Autowired
    // by default bean name will be class name with first letter small. otherwise we can use custom bean name using  @Component("bean_name")
//    @Qualifier("desktop")
    private Computer computer;

    public Alien() {
        System.out.println("Alien object created");
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {    // Setter Injection
        System.out.println("Setter called");
        this.age = age;
    }

    public Computer getComputer() {
        return computer;
    }

    @Autowired //Setter Injection
    public void setComputer(@Qualifier("desktop") Computer computer) {
        this.computer = computer;
    }

    public void code() {
        System.out.println("Coding...");
        computer.compile();
    }

}

