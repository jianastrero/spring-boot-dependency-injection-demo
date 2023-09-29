package dev.jianastrero.springbootdependencyinjectiondemo.beans;

import org.springframework.stereotype.Component;

@Component // This is a bean, it is a component that can be injected
public class InjectMe {

    private String message = "Hello World from InjectMe!";

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void printMessage() {
        System.out.println(message);
    }
}
