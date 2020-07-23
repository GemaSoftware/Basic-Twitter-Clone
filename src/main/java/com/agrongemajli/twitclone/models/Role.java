package com.agrongemajli.twitclone.models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@Table(name = "roles")
@Data
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer roleID;
    @Column(nullable = false, unique = true)
    @NotEmpty
    private String name;

    @ManyToMany(mappedBy = "roles")
    private List< AuthUser > users;

}