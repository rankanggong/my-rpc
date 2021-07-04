package impl;

import common.annotation.api.HelloService;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TestServiceImpl implements HelloService {

    public String sayHello(String name) {
        log.info(name);
        return "Hello" + name;
    }
}
