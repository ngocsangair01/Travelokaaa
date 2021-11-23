package com.example.traveloka.daos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
@Table(name = "to_airport")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ToAirport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idAirport")
    private Integer idAirport;

    @NotBlank
    @Nationalized
    private String fromWhere;

    @NotBlank
    @Nationalized
    private String toWhere;

    @NotBlank
    private String fromWhen;

    @NotBlank
    private String toWhen;

    @NotBlank
    private Integer numberOfSeat;

    @NotBlank
    private String avatarCar;

    @ManyToMany(mappedBy = "toAirports")
    @JsonIgnore
    private Set<User> users;
}
