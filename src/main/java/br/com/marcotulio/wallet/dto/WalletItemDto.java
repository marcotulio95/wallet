package br.com.marcotulio.wallet.dto;

import br.com.marcotulio.wallet.model.WalletModel;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class WalletItemDto {
    private Long id;
    @NotNull(message = "Informe o id da carteira")
    private WalletModel wallet;
    @NotNull(message = "Informe uma data")
    private Date date;
    @NotNull(message = "Informe o tipo")
    private String type;
    @NotNull(message = "Informe uma descrição")
    @Length(min = 5, message = "A descrição deve possuir no minimo 5 caracteres")
    private String description;
    @NotNull(message = "Informe o valor")
    private BigDecimal value;
}
