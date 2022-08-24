package com.lld.splitwise;

import java.util.HashMap;

class UserManagementService{
    static HashMap<Long, Application.User> userDataSet = new HashMap<>();

    static void makeUserEntry(Application.User newUser){
        userDataSet.put(newUser.getId() , newUser);
    }

    static Application.User getUserForId(long userId){
        return userDataSet.getOrDefault(userId, null);
    }


}