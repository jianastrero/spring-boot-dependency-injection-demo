# Spring Boot Dependency Injection Demo

## Description
This is a demo project to show how to use dependency injection in Spring Boot.

## Dependency Injection
Dependency injection is a technique whereby one object (or static method) supplies the dependencies of another object. A dependency is an object that can be used (a service). An injection is the passing of a dependency to a dependent object (a client) that would use it. The service is made part of the client's state. Passing the service to the client, rather than allowing a client to build or find the service, is the fundamental requirement of the pattern.

## Dependency Injection in Spring Boot
Spring Boot is a framework that allows you to build stand-alone, production-grade Spring based Applications that you can "just run". It takes an opinionated view of the Spring platform so that new and existing users can quickly get to the bits they need.

## Components (Classes to be injected)
* [InjectMe.java](src/main/java/dev/jianastrero/springbootdependencyinjectiondemo/beans/InjectMe.java)
  * Simple class that doesn't get another class injected to it
* [InjectToMe.java](src/main/java/dev/jianastrero/springbootdependencyinjectiondemo/beans/InjectToMe.java)
  * Simple class that gets another class injected to it

## Usage
[SpringBootDependencyInjectionDemoApplication.java](src/main/java/dev/jianastrero/springbootdependencyinjectiondemo/SpringBootDependencyInjectionDemoApplication.java)
```java
    // Get the application context
    // This is where all the beans are stored
    ConfigurableApplicationContext context = SpringApplication.run(SpringBootDependencyInjectionDemoApplication.class, args);
    
    // Get the bean for InjectToMe
    InjectToMe injectToMe = context.getBean(InjectToMe.class);
    System.out.println("> injectToMe: " + injectToMe);
    injectToMe.printMessage();
    
    // Get the bean for InjectMe
    InjectMe injectMe = context.getBean(InjectMe.class);
    System.out.println("> injectMe: " + injectMe);
    injectMe.printMessage();
    
    // Get the bean for InjectMe
    // This should be the same as the first one
    // Because it is a singleton
    // It is only created once
    // And it is reused
    InjectMe injectMe2 = context.getBean(InjectMe.class);
    injectMe2.setMessage("Custom text for injectMe");
    System.out.println("> injectMe2: " + injectMe2);
    injectMe2.printMessage();
    
    // Get the bean for InjectMe
    // This should be the same as the first one
    // Because it is a singleton
    // It is only created once
    // And it is reused
    // But since we changed the message for injectMe2
    // The message for injectMe3 is also changed
    InjectMe injectMe3 = context.getBean(InjectMe.class);
    System.out.println("> injectMe3: " + injectMe3);
    injectMe3.printMessage();
    
    // Get the bean for InjectToMe
    // This should be the same as the first one
    // Because it is a singleton
    // But since we changed the message for injectMe
    // The message for the injectMe inside injectToMe2 is also changed
    InjectToMe injectToMe2 = context.getBean(InjectToMe.class);
    System.out.println("> injectToMe2: " + injectToMe2);
    injectToMe2.printMessage();
```

## Log
```text
> injectToMe: dev.jianastrero.springbootdependencyinjectiondemo.beans.InjectToMe@2ee48610
Hello World from InjectToMe!
Hello World from InjectMe!
> injectMe: dev.jianastrero.springbootdependencyinjectiondemo.beans.InjectMe@1d901f20
Hello World from InjectMe!
> injectMe2: dev.jianastrero.springbootdependencyinjectiondemo.beans.InjectMe@1d901f20
Custom text for injectMe
> injectMe3: dev.jianastrero.springbootdependencyinjectiondemo.beans.InjectMe@1d901f20
Custom text for injectMe
> injectToMe2: dev.jianastrero.springbootdependencyinjectiondemo.beans.InjectToMe@2ee48610
Hello World from InjectToMe!
Custom text for injectMe
```
