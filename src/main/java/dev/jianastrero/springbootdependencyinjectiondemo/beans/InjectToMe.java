package dev.jianastrero.springbootdependencyinjectiondemo.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InjectToMe {

    @Autowired
    InjectMe injectMe;

    private String message = "Hello World from InjectMe!";

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void printMessage() {
        System.out.println("Hello World from InjectToMe!");
        System.out.println(message);
        injectMe.printMessage();
    }
}
