package com.example.Unisystems.RoleAuthentication;

import com.example.Unisystems.Employee.Employee;
import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name ="role")
        public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "role_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "NAME")
    private RoleAssignment name;

    @Column(name = "DESCRIPTION")
    private String description;
  /*  @Column(name = "CREATED_ON")
    private Long createdOn;
    @Column(name = "MODIFIED_ON")
    private Long modifiedOn;*/

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.MERGE
            },
            mappedBy = "roles")
    private List<Employee> employees;

   /*@ManyToMany
    //@JoinTable(
         //  name = "roles_privileges",
          //  joinColumns = @JoinColumn(
                   // name = "role_id", referencedColumnName = "id"),
          //  inverseJoinColumns = @JoinColumn(
                //   name = "employee_id", referencedColumnName = "id"))*/

           // @JoinTable(name = "role_privileges",
                   // joinColumns = {@JoinColumn(name="role_id")},
                   // inverseJoinColumns ={ @JoinColumn(name = "employee_id") })
  // private List<Employee> employees;*/

    //private List<Privilege> privileges;*/

    public Role() {
    }

    public Role(RoleAssignment name, String description) {
        this.name = name;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RoleAssignment getName() {
        return name;
    }

    public void setName(RoleAssignment name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
