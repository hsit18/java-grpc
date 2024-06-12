package org.grpcdemo.repository;

import com.grpcdemo.proto.model.user.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserRepository {
    Map<Integer, User> UsersMap = new HashMap<>();

    public User createUser(User user) {
        UsersMap.put((Integer) user.getID(), user);
        return user;
    }


    public User updateUser(User user) {
        UsersMap.put(user.getID(), user);
        return user;
    }

    public List<User> getAllUsers(){
        List<User> userList = UsersMap.values().stream().collect(Collectors.toList());
        return userList;
    }

    public User getUser(int userId) {
        System.out.println(UsersMap.values());
        return UsersMap.get(userId);
    }

    public boolean deleteUser(int userId) {
        UsersMap.remove(userId);
        return true;
    }
}
