package com.example.traveloka.base;

import com.example.traveloka.daos.User;

public class ResponseUser {
    private int status;
    private String message;
    private User data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public User getData() {
        return data;
    }

    public void setData(User data) {
        this.data = data;
    }

    public ResponseUser() {
    }

    public ResponseUser(int status, String message, User data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }
}
