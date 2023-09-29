package dev.jianastrero.springbootdependencyinjectiondemo.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InjectToMe {

    // This is a bean, it is a component that can be injected
    // This is a singleton
    // It is only created once
    // And it is reused
    @Autowired
    InjectMe injectMe;

    private String message = "Hello World from InjectToMe!";

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void printMessage() {
        System.out.println(message);
        injectMe.printMessage();
    }
}
