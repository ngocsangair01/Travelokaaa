package com.example.traveloka.base;

import com.example.traveloka.daos.Flight;
import com.example.traveloka.dtos.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Set;

public class BaseController {
    private Integer status;
    private String message;
    private List<?> data;

    public BaseController(Integer status, String message, List<?> data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<?> getData() {
        return data;
    }

    public void setData(List<?> data) {
        this.data = data;
    }

    public BaseController() {
    }
}