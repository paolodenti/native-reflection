package com.example.demo;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args)
            throws InvocationTargetException, InstantiationException, IllegalAccessException, ClassNotFoundException,
            NoSuchMethodException {
        if (args.length > 0) {
            Constructor<?> c = Class.forName(args[0]).getConstructor(String.class);
            Object o = c.newInstance("123.4");
            System.out.println(o);
        }
    }

}
