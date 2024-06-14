package org.grpcdemo.client;

import com.google.protobuf.Empty;
import com.google.protobuf.Timestamp;
import com.grpcdemo.proto.model.car.Car;
import com.grpcdemo.proto.model.car.Type;
import com.grpcdemo.proto.model.user.*;
import com.grpcdemo.proto.model.user.UserServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class UserClient {
    private static int grpcPort = 9900;
    private static ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", grpcPort).usePlaintext().build();
    public static void main(String[] args) {
        System.out.println("Hello from UserClient");
        createUser();
        updateUser();
        getUsers();
        deleteUser();
        getUsers();
    }

    public static void getUsers() {
        var stub = UserServiceGrpc.newBlockingStub(channel);
        var response = stub.getUsers(Empty.newBuilder().build());
        System.out.println(response);
    }
    public static void createUser() {
        var stub = UserServiceGrpc.newBlockingStub(channel);
        var user = User.newBuilder()
                .setID(1)
                .setFirstname("John")
                .setLastname("Doe")
                .setBalance(12354)
                .setEmail("abc@in.com")
                .setEmployed(true)
                .setSalary(123.45)
                .setBankAccountNumber(123234243)
                .setCreated(Timestamp.newBuilder().setNanos(77).build())
                .setAge(30)
                .setCar(Car.newBuilder().setMake("Toyota").build())
                .build();
        var response = stub.createUser(userData.newBuilder().setUser(user).build());
        System.out.println(response);
    }

    public static void updateUser() {
        var stub = UserServiceGrpc.newBlockingStub(channel);
        var userResponse = stub.getUser(userRequestParam.newBuilder().setID(1).build());
        var user = userResponse.getUser().toBuilder()
                .setFirstname("Harpreet")
                .setCar(Car.newBuilder().setMake(userResponse.getUser().getCar().getMake()).setType(Type.XUV).build())
                .build();
        var response = stub.updateUser(userData.newBuilder().setUser(user).build());
        System.out.println(response);
    }
    public static void deleteUser() {
        var stub = UserServiceGrpc.newBlockingStub(channel);
        var response = stub.deleteUser(userRequestParam.newBuilder().setID(1).build());
        System.out.println(response);
    }
}
