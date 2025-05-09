package org.example.queryblog.entite;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.GenericGenerator;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Getter
@Setter
@DiscriminatorValue("News")
public class News extends Item{
    private String summary;

}
