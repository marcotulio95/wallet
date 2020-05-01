package br.com.marcotulio.wallet.repository;


import br.com.marcotulio.wallet.models.UserModel;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class UserRepositoryTest {

    private static final String EMAIL = "setupuser@setupuser.com.br";
    @Autowired
    UserRepository userRepository;

    @Before
    public void setUp(){
        UserModel user = new UserModel();
        user.setName("Set up user");
        user.setPassword("123456");
        user.setEmail(EMAIL);

        userRepository.save(user);
    }

    @After
    public void tearDown(){
        userRepository.deleteAll();
    }


    @Test
    public void testSave(){
        UserModel user = new UserModel();
        user.setName("Test");
        user.setPassword("123456");
        user.setEmail("test@test.com.br");

        UserModel userResponse = userRepository.save(user);
        assertNotNull(userResponse);
    }

    @Test
    public void testFindByEmail(){
        Optional<UserModel> userResponse = userRepository.findByEmailEquals(EMAIL);
        assertEquals(userResponse.isPresent(), true);
        assertEquals(userResponse.get().getEmail(), EMAIL);
    }


}
