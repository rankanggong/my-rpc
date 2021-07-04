package protocol.entity;

import lombok.Data;

@Data
public class RpcResponse {
    private String requestId;
    private Throwable  throwable;
    private Object result;

    public String getRequestId() {
        return requestId;
    }

    public Object getResult() {
        return result;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }

    public void setResult(Object handler) {
        this.result = result;
    }

    public void setRequestId(String id) {
        this.requestId = id;
    }
}
