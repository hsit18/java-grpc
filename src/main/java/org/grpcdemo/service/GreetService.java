package org.grpcdemo.service;

import io.grpc.stub.StreamObserver;
import org.grpcdemo.proto.model.greet.GreetGrpc;
import org.grpcdemo.proto.model.greet.GreetRequest;
import org.grpcdemo.proto.model.greet.GreetResponse;

public class GreetService extends GreetGrpc.GreetImplBase {
    @Override
    public void greet(GreetRequest request, StreamObserver<GreetResponse> responseObserver) {
        System.out.println("Received request: " + request);
        var response = GreetResponse.newBuilder()
                .setMessage("Hello how are you " + request.getName())
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
