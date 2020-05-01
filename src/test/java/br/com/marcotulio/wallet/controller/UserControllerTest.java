package br.com.marcotulio.wallet.controller;

import br.com.marcotulio.wallet.dto.UserDto;
import br.com.marcotulio.wallet.model.UserModel;
import br.com.marcotulio.wallet.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class UserControllerTest {

    private static final String EMAIL = "email@teste.com.br";
    private static final String NAME = "User test";
    private static final String PASSWORD = "123456";
    private static final String URL = "/user";

    @MockBean
    UserService userService;

    @Autowired
    MockMvc mockMvc;

    @Before
    public void setUp(){

    }

    @Test
    public void testSave() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post(URL).content(getUserDtoPayload()).
                contentType(MediaType.APPLICATION_JSON).
                accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isCreated());
    }

    public UserModel getUser(){
        UserModel userModel = new UserModel();
        userModel.setEmail(EMAIL);
        userModel.setName(NAME);
        userModel.setPassword(PASSWORD);
        return userModel;
    }

    public String getUserDtoPayload() throws JsonProcessingException {
        UserDto userDto = new UserDto();

        userDto.setEmail(EMAIL);
        userDto.setName(NAME);
        userDto.setPassword(PASSWORD);

        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(userDto);
    }

}
