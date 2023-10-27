package demo.modelo;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "empleados")
public class EmpleadoDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column (name = "name")
    private String name;

    @Column (name = "lastname")
    private String lastname;

    @Column (name = "created_at")
    private Timestamp created_at;

    public EmpleadoDTO() {}

    public EmpleadoDTO(String name, String lastname) {
        this.name = name;
        this.lastname = lastname;
    }

    public EmpleadoDTO(String name, String lastname, Timestamp fullDate) {
        this.name = name;
        this.lastname = lastname;
        this.created_at = fullDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_on(Timestamp created_at) {
        this.created_at = created_at;
    }

}
