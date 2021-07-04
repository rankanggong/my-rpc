package common.annotation.api;

import common.annotation.RpcInterface;

@RpcInterface
public interface HelloService {
    String sayHello(String name);
}
