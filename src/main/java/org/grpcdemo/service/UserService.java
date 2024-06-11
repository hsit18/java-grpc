package org.grpcdemo.service;


import com.google.protobuf.Timestamp;
import com.grpcdemo.proto.model.user.*;
import io.grpc.stub.StreamObserver;

import java.util.List;

public class UserService extends UserServiceGrpc.UserServiceImplBase {

    public void getUsers(noParams request, StreamObserver<usersResponse> responseObserver) {
        var user = User.newBuilder()
                .setFirstname("John")
                .setLastname("Doe")
                .setBalance(12354)
                .setEmail("abc@in.com")
                .setEmployed(true)
                .setSalary(123.45)
                .setBankAccountNumber(123234243)
                .setCreated(Timestamp.newBuilder().setNanos(77).build())
                .setAge(30).build();

        responseObserver.onNext(usersResponse.newBuilder().addUsers(user).build());
        responseObserver.onCompleted();
    }

    @Override
    public void getUser(userRequestParam request, StreamObserver<userData> responseObserver) {
        super.getUser(request, responseObserver);
        var user = User.newBuilder()
                .setFirstname("John")
                .setLastname("Doe")
                .setBalance(12354)
                .setEmail("abc@in.com")
                .setEmployed(true)
                .setSalary(123.45)
                .setBankAccountNumber(123234243)
                .setCreated(Timestamp.newBuilder().setNanos(77).build())
                .setAge(30).build();

        responseObserver.onNext(userData.newBuilder().setUser(user).build());
        responseObserver.onCompleted();
    }

    @Override
    public void createUser(userData request, StreamObserver<userData> responseObserver) {
        super.createUser(request, responseObserver);
    }

    @Override
    public void updateUser(userData request, StreamObserver<userData> responseObserver) {
        super.updateUser(request, responseObserver);
    }

    @Override
    public void deleteUser(userRequestParam request, StreamObserver<DeleteUserResponse> responseObserver) {
        super.deleteUser(request, responseObserver);
    }
}
