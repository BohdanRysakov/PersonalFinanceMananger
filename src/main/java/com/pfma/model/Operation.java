package com.pfma.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.UUID;

@Entity
@Table(name = "operations")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Operation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @Column(nullable = false)
    @Size(min = 3, max = 300)
    private String description;

    @Column(nullable = false)
    private double money;

    @Lob
    @Column(nullable = false)
    private byte[] file;

    @Column(nullable = false)
    private String fileType;  // for example "application/pdf", "image/jpeg"

}