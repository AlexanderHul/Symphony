package com.example.symphony.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "theatre")
@NoArgsConstructor @AllArgsConstructor @Data
public class Theatre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;
    @Column(name = "city")
    private String city;
    @Column(name = "description")
    private String description;
}
