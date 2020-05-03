package br.com.marcotulio.wallet.repository;

import br.com.marcotulio.wallet.model.WalletItemModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletItemsRepository extends JpaRepository<WalletItemModel,Long> {
}
