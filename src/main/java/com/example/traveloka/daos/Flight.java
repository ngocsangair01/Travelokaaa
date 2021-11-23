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
@Table(name = "flight")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idFlight")
    private Integer idFlight;

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
    @Nationalized
    private String classSeat;

    @NotBlank
    private Integer price;

    @ManyToMany(mappedBy = "flights")
    @JsonIgnore
    private Set<User> users;

    public Flight(Integer idFlight, String fromWhere, String toWhere, String fromWhen, String toWhen, String classSeat, Integer price) {
        this.idFlight = idFlight;
        this.fromWhere = fromWhere;
        this.toWhere = toWhere;
        this.fromWhen = fromWhen;
        this.toWhen = toWhen;
        this.classSeat = classSeat;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "idFlight=" + idFlight +
                ", fromWhere='" + fromWhere + '\'' +
                ", toWhere='" + toWhere + '\'' +
                ", fromWhen='" + fromWhen + '\'' +
                ", toWhen='" + toWhen + '\'' +
                ", classSeat='" + classSeat + '\'' +
                ", price=" + price +
                ", users=" + users +
                '}';
    }
}
