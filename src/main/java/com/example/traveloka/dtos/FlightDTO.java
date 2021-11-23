package com.example.traveloka.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FlightDTO {
    private String fromWhere;
    private String toWhere;
    private String fromWhen;
    private String toWhen;
    private String classSeat;
    private Integer price;
}
