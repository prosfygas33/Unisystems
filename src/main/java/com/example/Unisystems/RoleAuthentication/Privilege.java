package com.example.Unisystems.RoleAuthentication;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
public class Privilege {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

   // @ManyToMany(mappedBy = "privileges")
 //   private List<Role> roles;


    public Privilege(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
