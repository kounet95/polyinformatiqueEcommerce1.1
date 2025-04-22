package org.example.queryblog.entite;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Utilisateurs {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    private String username;
    private String email;
    private String password;
    private String name;
    private String phone;
    private String address;
    @OneToMany
    private List<Comment> commentList;
    @OneToMany
    @JoinColumn(name = "utilisateur")
    private List<Item> items;
}
