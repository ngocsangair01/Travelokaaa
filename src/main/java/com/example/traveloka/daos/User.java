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
@Table(name = "user")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUser")
    private Integer idUser;

    @Column(unique = true)
    @NotBlank
    private String account;

    @NotBlank
    private String password;

    @NotBlank
    @Nationalized
    private String name;

    @NotBlank
    private String age;

    @NotBlank
    private String email;

    @Nationalized
    @NotBlank
    private String address;

    @Nationalized
    @NotBlank
    private String sex;

    @NotBlank
    private String birthday;

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JsonIgnore
    @JoinTable(name = "flight_schedule",
            joinColumns = @JoinColumn(name = "idUser",referencedColumnName = "idUser"),
            inverseJoinColumns = @JoinColumn(name = "idFlight",referencedColumnName = "idFlight"))
    private Set<Flight> flights;

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JsonIgnore
    @JoinTable(name = "car_schedule",
            joinColumns = @JoinColumn(name = "idUser",referencedColumnName = "idUser"),
            inverseJoinColumns = @JoinColumn(name = "idAirport",referencedColumnName = "idAirport"))
    private Set<ToAirport> toAirports;


}
