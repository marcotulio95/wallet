package br.com.marcotulio.wallet.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

@Data
public class UserDto {

    private Long id;
    @Email(message = "Email inválido")
    private String email;
    @NotNull
    @Length(min = 3, max = 50, message = "O nome deve conter entre 3 e 50 caracteres")
    private String name;
    @NotNull
    @Length(min = 6, max = 50, message = "A senha deve conter no minimo 6 caracteres")
    private String password;
}
