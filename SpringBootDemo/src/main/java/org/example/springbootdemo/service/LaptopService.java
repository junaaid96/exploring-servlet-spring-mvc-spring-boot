package org.example.springbootdemo.service;

import org.example.springbootdemo.model.Laptop;
import org.example.springbootdemo.repository.LaptopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LaptopService {
    private final LaptopRepository laptopRepository;

    @Autowired
    LaptopService(LaptopRepository laptopRepository) {
        this.laptopRepository = laptopRepository;
    }

    public void addLaptop(Laptop laptop) {
        laptopRepository.save(laptop);
    }

    public boolean isGoodForProgramming(Laptop laptop) {
        return true;
    }
}
