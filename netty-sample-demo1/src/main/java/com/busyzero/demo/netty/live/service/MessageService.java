package com.busyzero.demo.netty.live.service;

import com.busyzero.demo.netty.live.dto.Response;
import com.busyzero.demo.netty.live.entity.Client;

public class MessageService {
    public static Response sendMessage(Client client, String message) {
        Response res = new Response();
        res.getData().put("id", client.getId());
        res.getData().put("message", message);
        res.getData().put("ts", System.currentTimeMillis());
        return res;
    }
}
