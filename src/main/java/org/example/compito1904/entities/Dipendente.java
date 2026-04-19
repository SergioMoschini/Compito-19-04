package org.example.compito1904.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(
        name = "dipendenti" ,
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "email"),
                @UniqueConstraint(columnNames = "username")
        }
)
public class Dipendente {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Setter(AccessLevel.NONE)
private UUID id ;
private String username ;
private String name;
private String surname;
private String email;
}
