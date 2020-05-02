package br.com.marcotulio.wallet.controller;

import br.com.marcotulio.wallet.dto.WalletDto;
import br.com.marcotulio.wallet.model.WalletModel;
import br.com.marcotulio.wallet.service.WalletService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("wallet")
public class WalletController {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private WalletService walletService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public WalletDto create(@Valid @RequestBody WalletDto walletDto){
        WalletModel walletModel = modelMapper.map(walletDto, WalletModel.class);
        return modelMapper.map(walletService.save(walletModel), WalletDto.class);
    }
}
