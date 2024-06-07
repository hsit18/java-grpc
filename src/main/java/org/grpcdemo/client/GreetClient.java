package org.grpcdemo.client;

import io.grpc.ManagedChannelBuilder;
import org.grpcdemo.proto.model.greet.GreetGrpc;
import org.grpcdemo.proto.model.greet.GreetRequest;

public class GreetClient {
    private static int grpcPort = 9900;
    public static void main(String[] args) {
        System.out.println("Hello from GreetClient");
        var channel = ManagedChannelBuilder.forAddress("localhost", grpcPort).usePlaintext().build();
        var stub = GreetGrpc.newBlockingStub(channel);
        var request = GreetRequest.newBuilder().setName("Harpreet").build();
        var response = stub.greet(request);
        System.out.println(response);

    }
}
