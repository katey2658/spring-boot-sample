package com.busyzero.demo.javaassist;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class HttpProtocol implements Protocol{
    protected final Map<String, Exporter<?>> exporterMap = new ConcurrentHashMap<>();
    private final Map<String, ExchangeServer> serverMap = new ConcurrentHashMap<>();

    @Override
    public <T> Exporter<T> export(Invoker<T> invoker) {
        String url = String.valueOf(invoker.getUrl());
        Exporter<T> exporter = (Exporter<T>) exporterMap.get(url);
        if (exporter != null) {
            return exporter;
        }

        String key = invoker.getInterface().getName() +  ":" + "v1" + ":" + "6678";
        exporter = new KrExporter<T>(invoker, key, exporterMap);
        exporterMap.put(key, exporter);

        openServer(invoker.getUrl());
        return exporter;
    }

    private void openServer(URL url) {
        String key = "192.165.103.149";
        ExchangeServer server = serverMap.get(key);
        server.reset(url);
    }

    @Override
    public <T> Invoker<T> refer(Class<T> type, URL url) {
        return null;
    }
}
