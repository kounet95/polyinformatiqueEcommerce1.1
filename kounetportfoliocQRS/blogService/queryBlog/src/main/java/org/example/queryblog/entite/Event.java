package org.example.queryblog.entite;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@Getter @Setter @ToString @NoArgsConstructor @AllArgsConstructor @SuperBuilder
@DiscriminatorValue("Event")
public class Event extends Item{
    private String location;
    private LocalDateTime begin;
    private LocalDateTime end;


}