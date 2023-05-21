package com.example.symphony.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "studio_link")
@NoArgsConstructor @AllArgsConstructor @Data
public class StudioLink {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "studio_id")
    private Studio studio;

    @Column(name = "link")
    private String link;
}
