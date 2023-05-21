package com.example.symphony.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Entity
@Table(name = "theatre_performance")
@NoArgsConstructor @AllArgsConstructor @Data
public class TheatrePerformance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "theatre_id")
    private Theatre theatre;

    @ManyToOne
    @JoinColumn(name = "studio_id")
    private Studio studio;

    @ManyToOne
    @JoinColumn(name = "performance_id")
    private Performance performance;

    @Column(name = "perform_date")
    private Date performDate;

    @Column(name = "price")
    private Float price;
}

