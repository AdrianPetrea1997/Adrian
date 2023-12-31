package org.example;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws IOException {
        HttpServer httpServer = HttpServer.create(new InetSocketAddress("localhost", 4040),0);
        // hostname, port, backlog
        // http:localhost:4040/movies
        httpServer.createContext("/movies", null);
        httpServer.setExecutor(Executors.newSingleThreadExecutor());
        httpServer.start();
    }
    public class MovieHandler implements HttpHandler {
        @Override
        public void handle (HttpExchange exchange) throws IOException{
            // post -> create
            // get -> read
            // put -> update
            //delete -> delete
            // crud

            if ("get". equals(exchange.getRequestMethod())){
                // send something to the user
               OutputStream outputStream = exchange.getResponseBody();
                String responseToBeSentBack = " Hello from the other side";
                exchange.sendResponseHeaders(200,responseToBeSentBack.length());

                outputStream.write(responseToBeSentBack.getBytes());
                outputStream.flush();
                outputStream.close();
            }
        }

    }
}