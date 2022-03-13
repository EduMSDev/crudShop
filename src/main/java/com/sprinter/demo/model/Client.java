package com.sprinter.demo.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class Client extends GenericEntity {

    @JsonManagedReference
    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Order> orders;
    @NotBlank(message = "El campo dni no puede estar vacio")
    @Pattern(regexp = "[0-9]{7,8}[A-Za-z]", flags = Pattern.Flag.CASE_INSENSITIVE)
    private String dni;
    private String surname;
    private String address;
    @NotBlank(message = "El campo email no puede estar vacio")
    @Email(message = "El correo no sigue el formato correcto.")
    @Pattern(regexp = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", flags = Pattern.Flag.CASE_INSENSITIVE)
    private String email;

    @Builder
    public Client(Long id, String name, Date modifiedAt, Date createdAt, String dni, String surname, String address, String email) {
        super(id, name, modifiedAt, createdAt);
        this.dni = dni;
        this.surname = surname;
        this.address = address;
        this.email = email;
    }

    public Client() {
        super();
    }

}
