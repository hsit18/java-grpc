package org.grpcdemo.service;


import com.google.protobuf.Empty;
import com.google.protobuf.Timestamp;
import com.grpcdemo.proto.model.user.*;
import io.grpc.stub.StreamObserver;
import org.grpcdemo.repository.UserRepository;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class UserService extends UserServiceGrpc.UserServiceImplBase {
    private UserRepository userRepository = new UserRepository();
    public void getUsers(Empty request, StreamObserver<usersResponse> responseObserver) {
        responseObserver.onNext(usersResponse.newBuilder().addAllUsers(userRepository.getAllUsers()).build());
        responseObserver.onCompleted();
    }

    public void getUser(userRequestParam request, StreamObserver<userData> responseObserver) {
        responseObserver.onNext(userData.newBuilder().setUser(userRepository.getUser(request.getID())).build());
        responseObserver.onCompleted();
    }

    public void createUser(userData request, StreamObserver<userData> responseObserver) {
        userRepository.createUser(request.getUser());
        responseObserver.onNext(userData.newBuilder().setUser(request.getUser()).build());
        responseObserver.onCompleted();
    }

    @Override
    public void updateUser(userData request, StreamObserver<userData> responseObserver) {
        userRepository.updateUser(request.getUser());
        responseObserver.onNext(userData.newBuilder().setUser(request.getUser()).build());
        responseObserver.onCompleted();
    }

    @Override
    public void deleteUser(userRequestParam request, StreamObserver<DeleteUserResponse> responseObserver) {
        var status = userRepository.deleteUser(request.getID());
        responseObserver.onNext(DeleteUserResponse.newBuilder().setSuccess(status).build());
        responseObserver.onCompleted();
    }
}
