package org.grpcdemo.client;

import com.grpcdemo.proto.model.user.UserServiceGrpc;
import com.grpcdemo.proto.model.user.noParams;
import io.grpc.ManagedChannelBuilder;

public class UserClient {
    private static int grpcPort = 9900;
    public static void main(String[] args) {
        System.out.println("Hello from UserClient");
        var channel = ManagedChannelBuilder.forAddress("localhost", grpcPort).usePlaintext().build();
        var stub = UserServiceGrpc.newBlockingStub(channel);
        var response = stub.getUsers(noParams.newBuilder().build());
        System.out.println(response);
    }
}
