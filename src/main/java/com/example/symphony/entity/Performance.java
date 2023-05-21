package com.example.symphony.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "performance")
@NoArgsConstructor @AllArgsConstructor @Data
public class Performance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "duration")
    private Integer duration;
    @Column(name = "description", columnDefinition = "text")
    private String description;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    private Author author;
}
