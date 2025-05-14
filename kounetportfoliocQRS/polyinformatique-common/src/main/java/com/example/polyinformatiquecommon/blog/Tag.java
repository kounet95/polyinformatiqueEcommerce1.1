package com.example.polyinformatiquecommon.blog;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "common.blog.Tag")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Table(name = "Tag")
public class Tag {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    private String name;
    @ManyToMany(mappedBy = "tags")
    private List<Item> tag_items=new ArrayList<>();
}