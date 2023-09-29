package dev.jianastrero.springbootdependencyinjectiondemo;

import dev.jianastrero.springbootdependencyinjectiondemo.beans.InjectMe;
import dev.jianastrero.springbootdependencyinjectiondemo.beans.InjectToMe;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringBootDependencyInjectionDemoApplication {

    public static void main(String[] args) {
        // Get the application context
        // This is where all the beans are stored
        ConfigurableApplicationContext context = SpringApplication.run(SpringBootDependencyInjectionDemoApplication.class, args);

        // Get the bean for InjectToMe
        InjectToMe injectToMe = context.getBean(InjectToMe.class);
        System.out.println("> injectToMe: " + injectToMe);
        injectToMe.printMessage();

        // Get the bean for InjectMe
        InjectMe injectMe = context.getBean(InjectMe.class);
        injectMe.setMessage("Custom text for injectMe");
        System.out.println("> injectMe: " + injectMe);
        injectMe.printMessage();

        // Get the bean for InjectMe
        // This should be the same as the first one
        // Because it is a singleton
        // It is only created once
        // And it is reused
        // We changed the message for injectMe
        // But it is still the same for injectMe2
        InjectMe injectMe2 = context.getBean(InjectMe.class);
        System.out.println("> injectMe2: " + injectMe2);
        injectMe2.printMessage();

        // Get the bean for InjectToMe
        InjectToMe injectToMe2 = context.getBean(InjectToMe.class);
        System.out.println("> injectToMe2: " + injectToMe2);
        injectToMe2.printMessage();
    }

}
