package com.exemple;

import java.util.HashMap;
import java.util.Map;

public class UserService {
    private Map<Integer, String> database = new HashMap<>();

    public void save(int id, String name) {
        database.put(id, name);
    }

    public String findById(int id) {
        return database.get(id);
    }

    public boolean exists(int id) {
        return database.containsKey(id);
    }
}