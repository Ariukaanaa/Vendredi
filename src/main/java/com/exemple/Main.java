package com.exemple;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

public class Main {
    public static void main(String[] args) throws Exception {
        int port = Integer.parseInt(System.getenv().getOrDefault("PORT", "8080"));
        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);


        server.createContext("/", new HttpHandler() {
            public void handle(HttpExchange exchange) throws IOException {
                // docs/index.html файлыг уншиж байна
                InputStream is = Main.class.getClassLoader().getResourceAsStream("index.html");
                
                String response;
                if (is != null) {
                    response = new String(is.readAllBytes());
                    exchange.getResponseHeaders().set("Content-Type", "text/html; charset=UTF-8");
                } else {
                    response = "<h1>index.html олдсонгүй</h1>";
                }
                
                exchange.sendResponseHeaders(200, response.getBytes().length);
                OutputStream os = exchange.getResponseBody();
                os.write(response.getBytes());
                os.close();
            }
        });

        server.start();
        System.out.println("Server started on port " + port);
    }
}