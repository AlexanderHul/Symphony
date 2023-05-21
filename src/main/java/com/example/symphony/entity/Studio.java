package com.example.symphony.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "studio")
@NoArgsConstructor @AllArgsConstructor @Data
public class Studio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "studio", fetch = FetchType.EAGER)
    private List<StudioLink> studioLinks;
}
