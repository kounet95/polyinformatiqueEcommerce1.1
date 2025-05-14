package org.example.queryblog.entite;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.GenericGenerator;
import com.example.polyinformatiquecommon.blog.Item;

@Entity(name = "blogarticle")
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
