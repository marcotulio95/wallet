package br.com.marcotulio.wallet.service.impl;

import br.com.marcotulio.wallet.model.UserModel;
import br.com.marcotulio.wallet.repository.UserRepository;
import br.com.marcotulio.wallet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserModel save(UserModel userModel) {
        return userRepository.save(userModel);
    }

    @Override
    public Optional<UserModel> findUserByEmail(String email) {
        return userRepository.findByEmailEquals(email);
    }
}
