package com.example.traveloka.dtos;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FindFlightDTO {
    private String fromWhere;
    private String toWhere;
    private String classSeat;
}
