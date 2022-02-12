# Tiny RPC for self-learning

## Intro:
RPC(Remote procedure call) is a request-response protocol, and widely used in microservice. RPC client could call a remote server and excute certain code. This's a simplified version of Dubbo, and used for self-learning. It only includes the functionality of remote calling, there are still many parts need to be done in the future.

## How the rpc works:

![image](https://user-images.githubusercontent.com/54407936/153694299-ee37ac32-905a-410f-9414-b815fd2a05c1.png)

  1. Client calls the dynamic proxy.
  2. The proxy serialize the request.
  3. The serialized byte stream would be send to the server through Netty.
  4. The server deserializes the request to the original calling, and execute the function by reflection.
  5. If the calling are supposed to have a response value, the result can be returned to the client through netty.

## Tools and framework
  - Spring boot
  - Netty
  - Maven
