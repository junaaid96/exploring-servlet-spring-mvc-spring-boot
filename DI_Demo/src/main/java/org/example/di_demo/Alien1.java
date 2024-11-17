package org.example.di_demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Alien1 {
    @Autowired
    PC pc;

    public void code() {
        pc.compile();
    }
}
