package org.grpcdemo.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.grpcdemo.service.GreetService;

public class GrpcServer {
    public static void intializeServer() throws Exception {
        Server server = ServerBuilder.forPort(9900)
                .addService(new GreetService())
                .build();
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Shutting down the server");
            server.shutdown();
        }));
        server.start();
        System.out.println("Started the server on: " + server.getPort());
        server.awaitTermination();
    }
}
