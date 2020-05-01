package br.com.marcotulio.wallet.controller;

import br.com.marcotulio.wallet.dto.UserDto;
import br.com.marcotulio.wallet.model.UserModel;
import br.com.marcotulio.wallet.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public UserDto create(@Valid @RequestBody UserDto userDto, BindingResult bindingResult){
        UserModel userModel = new UserModel();
        modelMapper.map(userDto,userModel);
        UserModel userModelResponse = userService.save(userModel);

        return modelMapper.map(userModelResponse, UserDto.class);
    }

}
