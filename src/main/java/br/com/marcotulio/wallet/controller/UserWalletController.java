package br.com.marcotulio.wallet.controller;

import br.com.marcotulio.wallet.dto.UserWalletDto;
import br.com.marcotulio.wallet.model.UserWalletModel;
import br.com.marcotulio.wallet.service.UserWalletService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("user-wallet")
public class UserWalletController {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UserWalletService userWalletService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserWalletDto create(@Valid @RequestBody UserWalletDto userWalletDto) {
        UserWalletModel userWalletModel = modelMapper.map(userWalletDto, UserWalletModel.class);
        return modelMapper.map(userWalletService.save(userWalletModel), UserWalletDto.class);
    }
}
