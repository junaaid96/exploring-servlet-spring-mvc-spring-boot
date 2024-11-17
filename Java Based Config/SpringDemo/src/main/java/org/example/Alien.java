package org.example;

public class Alien {

    private int age;
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

    public void setComputer(Computer computer) {
        this.computer = computer;
    }

    public void code() {
        System.out.println("Coding...");
        computer.compile();
    }

}

