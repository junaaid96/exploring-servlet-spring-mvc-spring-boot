package org.example.config;

import org.example.Alien;
import org.example.Computer;
import org.example.Desktop;
import org.example.Laptop;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {

    @Bean
    public Alien alien(@Qualifier("laptop") Computer computer) {
        Alien alien = new Alien();
        alien.setAge(10);
        // Computer is still null so we can set the one of the implementation of computer(obj of that concrete class) here. Such as lien.setComputer(laptop()); But this will be tightly coupled.  So we will use setter injection. Used @Qualifier to specify which bean to inject if there is more than one bean of the same type. Alternatively, we can also use @Primary before the bean.
        alien.setComputer(computer);
        return alien;
    }

    // @Bean(name = {"Beast","desktop","com1"})
    @Bean(name = "desk1")
    @Primary
    public Desktop desktop() {
        return new Desktop();
    }

    @Bean()
    @Scope("prototype")
    public Laptop laptop() {
        return new Laptop();
    }
}
