package com.busyzero.demo.javaassist;

public class RpcInvoker implements Invoker{
    private String name;

    @Override
    public Result invoke(Invocation invocation) throws RpcException {
        String name = invocation.getMethodName();
        Result result = new Result();
        result.setData(this.name + ": 你调用了" + name);
        return result;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
