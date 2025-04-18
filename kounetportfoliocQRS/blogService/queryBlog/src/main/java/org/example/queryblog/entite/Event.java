package org.example.queryblog.entite;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.GenericGenerator;

import java.util.ArrayList;
import java.util.List;


@Entity
@Getter @Setter @ToString @NoArgsConstructor @AllArgsConstructor @SuperBuilder
@DiscriminatorValue("Event")
public class Event extends Item{
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    private String name;
    private String location;


}