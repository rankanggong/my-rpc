package com.example.rpc.server.impl;


import com.example.rpc.api.HelloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TestServiceImpl implements HelloService {
    @Override
    public String sayHello(String name) {
        log.info(name);
        return "Hello " + name;
    }
}
