package com.example.traveloka.base;

import com.example.traveloka.daos.Flight;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ResponseFlight {
    private Integer status;
    private String message;
    private Flight data;
}
