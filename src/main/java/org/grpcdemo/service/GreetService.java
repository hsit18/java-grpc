package org.grpcdemo.service;

import org.grpcdemo.proto.model.greet.GreetGrpc;
import org.grpcdemo.proto.model.greet.GreetRequest;
import org.grpcdemo.proto.model.greet.GreetResponse;

public class GreetService extends GreetGrpc.GreetImplBase {
    public void Greet(GreetRequest request, GreetResponse responseObserver) {
        System.out.println("Received request: " + request);
        var response = GreetResponse.newBuilder()
                .setMessage("Hello how are you " + request.getName())
                .build();
    }
}
