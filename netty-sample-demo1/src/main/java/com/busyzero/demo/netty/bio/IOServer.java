package com.busyzero.demo.netty.bio;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class IOServer {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8899);
        while (true) {
            Socket socket = server.accept();
            new Thread(() -> {
                try {
                    BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
                    String request, response;
                    while ((request = reader.readLine()) !=  null) {
                        if ("Done".equals(request)) {
                            break;
                        }
                        response = "request:" + request;
                        writer.println(response);
                    }
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();

        }

    }
}
