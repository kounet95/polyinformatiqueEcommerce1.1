package org.example.queryblog.entite;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.GenericGenerator;

@Entity
@AllArgsConstructor @NoArgsConstructor
@SuperBuilder
@Getter
@Setter
@DiscriminatorValue("Article")
public class Article extends Item{

    @ManyToOne
    @JoinColumn(name = "domain_id")
    private Domain domain;
}

