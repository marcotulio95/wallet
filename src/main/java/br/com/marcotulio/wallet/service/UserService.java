package br.com.marcotulio.wallet.service;

import br.com.marcotulio.wallet.model.UserModel;

import java.util.Optional;

public interface UserService {

    UserModel save(UserModel userModel);

    Optional<UserModel> findUserByEmail(String email);
}
