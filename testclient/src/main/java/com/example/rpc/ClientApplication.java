package com.example.rpc;


import com.example.rpc.api.HelloService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ClientApplication {
    public static void main (String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ClientApplication.class);
        HelloService helloService = context.getBean(HelloService.class);
        System.out.println(helloService.sayHello("test"));
    }
}
