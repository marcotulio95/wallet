package br.com.marcotulio.wallet.repository;

import br.com.marcotulio.wallet.model.WalletModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletRepository extends JpaRepository<WalletModel, Long> {

}
