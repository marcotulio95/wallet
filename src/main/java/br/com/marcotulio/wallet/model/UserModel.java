package br.com.marcotulio.wallet.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Data
@Table(name = "users")
public class UserModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String email;
}
