package br.com.likwi.sso.subContext.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Role {

    @Id
    @GeneratedValue
    private long id;

    private String role;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
