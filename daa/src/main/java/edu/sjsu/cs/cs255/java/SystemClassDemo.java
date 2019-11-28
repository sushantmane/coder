package edu.sjsu.cs.cs255.java;

import java.io.Console;
import java.util.Properties;

public class SystemClassDemo {

    public String run() {
        Console console = System.console();
        return console == null ? null : console.readLine("%s", "cmd>>");
    }

    public static void main(String[] args) {
        SystemClassDemo demo = new SystemClassDemo();
        demo.run();
        Properties properties = System.getProperties();

        for (Object name : properties.keySet()) {
//            System.out.println(name + " :: " + properties.getProperty(name.toString()));
        }

        System.out.println(System.getenv("PATH"));
    }
}
