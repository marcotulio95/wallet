package br.com.marcotulio.wallet.service.impl;

import br.com.marcotulio.wallet.model.WalletModel;
import br.com.marcotulio.wallet.repository.WalletRepository;
import br.com.marcotulio.wallet.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WalletServiceImpl implements WalletService {

    @Autowired
    WalletRepository walletRepository;

    @Override
    public WalletModel save(WalletModel walletModel) {
        return walletRepository.save(walletModel);
    }
}
