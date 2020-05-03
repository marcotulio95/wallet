package br.com.marcotulio.wallet.repository;

import br.com.marcotulio.wallet.model.UserWalletModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserWalletRepository extends JpaRepository<UserWalletModel, Long> {
    
}
