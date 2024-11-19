# Spring Overview

## Core Technologies

### Maven
- Industry-standard build automation and dependency management tool
- Uses `pom.xml` for project configuration
- Handles project dependencies, build lifecycle, and artifact generation
- Provides consistent build process across different environments

### JDBC (Java Database Connectivity)
- Standard Java API for database-independent connectivity
- Provides common interface for database operations
- Supports SQL execution, result set handling, and transaction management
- Used as foundation for higher-level database abstractions

### Servlet & Web Container
#### Servlet
- Java classes that handle HTTP requests and responses
- Core building block for Java web applications
- Manages web application lifecycle and request processing

#### Servlet Container
- Runtime environment for Java web applications
- Manages servlet lifecycle and request handling
- Popular containers: Apache Tomcat, Jetty, WildFly

### Apache Tomcat
- Lightweight, open-source web server and servlet container
- Implements Java Servlet and JavaServer Pages specifications
- Provides HTTP server environment for Java applications
- Commonly used for deploying Spring applications

## Spring Framework Components

### Spring MVC
- Implementation of Model-View-Controller pattern
- Handles web requests through `@Controller` classes
- Provides robust request mapping and view resolution
- Features:
  - Form handling
  - Validation
  - REST support
  - View templating

### Spring Boot MVC
- Autoconfigured version of Spring MVC
- Reduces boilerplate configuration
- Embedded server (Tomcat by default)
- Production-ready features out of the box

## Configuration Approaches

### XML Configuration
```xml
<beans>
    <bean id="userService" class="com.example.UserService">
        <!-- property configurations -->
    </bean>
</beans>
```
- Traditional Spring configuration method
- Explicit and verbose
- External configuration
- Still used in legacy applications

### Java-based Configuration
```java
@Configuration
public class AppConfig {
    @Bean
    public UserService userService() {
        return new UserService();
    }
}
```
- Type-safe configuration
- Better refactoring support
- Programmatic bean creation

### Annotation-based Configuration
```java
@Component
public class UserService {
    @Autowired
    private UserRepository userRepository;
}
```
- Minimal configuration required
- Component scanning
- Dependency injection through annotations
- Most popular approach in modern applications

## Modern Spring Features

### Spring Boot REST
- Built on Spring MVC
- Simplified REST API development
- Features:
  - Automatic response conversion
  - Built-in support for JSON/XML
  - Exception handling
  - HATEOAS support

### Spring Data JPA
- Simplifies data access layer
- Reduces boilerplate code
- Features:
  - Repository interfaces
  - Query methods
  - Custom queries
  - Pagination and sorting

### Spring Data REST
- Automatically exposes JPA repositories as REST resources
- HATEOAS compliant
- Built-in pagination, sorting, and filtering
- Customizable endpoints and responses

### Spring AOP (Aspect-Oriented Programming)
- Modularizes cross-cutting concerns
- Common use cases:
  - Logging
  - Transaction management
  - Security
  - Performance monitoring

## Getting Started
To use these technologies, add appropriate dependencies to your `pom.xml`:

```xml
<dependencies>
    <!-- Spring Boot Starter Web -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    
    <!-- Spring Boot Starter Data JPA -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
</dependencies>
```
