package com.busyzero.demo.javaassist;

import java.util.ArrayList;
import java.util.List;

public class RandomCluster {
    private Class<?> type;

    public RandomCluster(Class type) {
        this.type = type;
    }

    public Invoker join() throws RpcException {
        List<Invoker> invokerList = doList();
        LoadBalance loadBalance = new RandomLoadBalance();
        Invoker invoker =  loadBalance.select(invokerList, null, null);
        return invoker;
    }

    private List<Invoker> doList() {
        List<Invoker> invokerList = new ArrayList<>();
        RpcInvoker rpcInvoker1 = new RpcInvoker();
        rpcInvoker1.setIface(type);
        rpcInvoker1.setName("invoker-1");
        invokerList.add(rpcInvoker1);

        RpcInvoker rpcInvoker2 = new RpcInvoker();
        rpcInvoker2.setName("invoker-2");
        rpcInvoker2.setIface(type);
        invokerList.add(rpcInvoker2);

        RpcInvoker rpcInvoker3 = new RpcInvoker();
        rpcInvoker3.setName("invoker-3");
        rpcInvoker3.setIface(type);
        invokerList.add(rpcInvoker3);

        RpcInvoker rpcInvoker4 = new RpcInvoker();
        rpcInvoker4.setName("invoker-4");
        rpcInvoker4.setIface(type);
        invokerList.add(rpcInvoker4);
        return invokerList;
    }
}
