package br.com.marcotulio.wallet.dto;

import br.com.marcotulio.wallet.model.UserModel;
import br.com.marcotulio.wallet.model.WalletModel;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserWalletDto {
    private Long id;
    @NotNull(message = "Informe o ID do usuário")
    private UserModel users;
    @NotNull(message = "Informe o ID da wallet")
    private WalletModel wallet;
}
