package com.busyzero.demo.netty.bio;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;

public class PlainOioServer {
    public void server(int port) throws IOException {
        final ServerSocket serverSocket = new ServerSocket(port);
        try {
            for (;;) {
                final Socket clientSocket = serverSocket.accept();
                System.out.println("accept connection from " + clientSocket);
                new Thread(() ->{
                    OutputStream out;
                    try {
                        out = clientSocket.getOutputStream();
                        out.write("Hi \r\n".getBytes(Charset.forName("UTF-8")));
                        out.flush();
                        clientSocket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            clientSocket.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
            }
        } catch (IOException e) {
             e.printStackTrace();
        }

    }
}
