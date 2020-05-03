package br.com.marcotulio.wallet.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WalletDto {
    private Long id;
    @Length(min=3, message = "O nome deve possuir mais que 3 caracteres")
    private String name;
    @NotNull(message = "O valor não pode ser vazio")
    private BigDecimal value;
}
