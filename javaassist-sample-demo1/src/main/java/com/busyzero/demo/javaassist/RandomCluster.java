package com.busyzero.demo.javaassist;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class RandomCluster implements Invoker {

    @Override
    public Result invoke(Invocation invocation) throws RpcException {
        return doInvoke(invocation);
    }

    private Result doInvoke(Invocation invocation) {
        List<Invoker> invokerList = doList();
        Invoker invoker =  doSelect(invokerList);
        return invoker.invoke(invocation);
    }

    private Invoker doSelect(List<Invoker> invokerList) {
        if (invokerList == null || invokerList.size() == 0) {
            return null;
        }

        int size = invokerList.size();
        ThreadLocalRandom random = ThreadLocalRandom.current ();
        int index = random.nextInt(size );
        return invokerList.get(index);
    }

    private List<Invoker> doList() {
        List<Invoker> invokerList = new ArrayList<>();
        RpcInvoker rpcInvoker1 = new RpcInvoker();
        rpcInvoker1.setName("invoker-1");
        invokerList.add(rpcInvoker1);

        RpcInvoker rpcInvoker2 = new RpcInvoker();
        rpcInvoker2.setName("invoker-2");
        invokerList.add(rpcInvoker2);

        RpcInvoker rpcInvoker3 = new RpcInvoker();
        rpcInvoker3.setName("invoker-3");
        invokerList.add(rpcInvoker3);

        RpcInvoker rpcInvoker4 = new RpcInvoker();
        rpcInvoker4.setName("invoker-4");
        invokerList.add(rpcInvoker4);
        return invokerList;
    }
}
