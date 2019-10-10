package com.bds.tokenTest.httpserver;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

public class Server {
	public static void main(String[] args) throws IOException {
		HttpServer server = HttpServer.create(new InetSocketAddress(8008), 0);
        server.createContext("/test", new TestHandler());
        server.start();
	}
	static  class TestHandler implements HttpHandler{
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            String response = "hello world";
            exchange.sendResponseHeaders(200, 0);
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }
}
