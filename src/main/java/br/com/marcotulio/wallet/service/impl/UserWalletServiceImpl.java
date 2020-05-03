package br.com.marcotulio.wallet.service.impl;

import br.com.marcotulio.wallet.model.UserWalletModel;
import br.com.marcotulio.wallet.repository.UserWalletRepository;
import br.com.marcotulio.wallet.service.UserWalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserWalletServiceImpl implements UserWalletService {

    @Autowired
    UserWalletRepository userWalletRepository;

    @Override
    public UserWalletModel save(UserWalletModel userWalletModel) {
        return userWalletRepository.save(userWalletModel);
    }
}
