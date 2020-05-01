package br.com.marcotulio.wallet.repository;

import br.com.marcotulio.wallet.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserModel, Long> {
    Optional<UserModel> findByEmailEquals(String email);
}
