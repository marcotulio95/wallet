package br.com.marcotulio.wallet.repository;

import br.com.marcotulio.wallet.model.WalletItemModel;
import br.com.marcotulio.wallet.model.WalletModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class WalletItemsRepositoryTest {
    private static final Date DATE = new Date();
    private static final String TYPE = "EN";
    private static final String DESCRIPTION = "Conta de luz";
    private static final BigDecimal VALUE = BigDecimal.valueOf(65);

    @Autowired
    WalletItemsRepository walletItemsRepository;
    @Autowired
    WalletRepository walletRepository;
    @Autowired
    ModelMapper modelMapper;

    @Test
    public void testSave(){

        WalletModel walletModel = new WalletModel();
        walletModel.setName("Wallet 1 from test");
        walletModel.setValue(BigDecimal.valueOf(500));
        walletRepository.save(walletModel);

        WalletItemModel walletItemModel = walletItemsRepository.save(new WalletItemModel(1L, walletModel,DATE,TYPE,DESCRIPTION,VALUE));
        assertNotNull(walletItemModel);
        assertEquals(walletItemModel.getDescription(), DESCRIPTION);
        assertEquals(walletItemModel.getType(), TYPE);
        assertEquals(walletItemModel.getDate(), DATE);
        assertEquals(walletItemModel.getValue(), VALUE );

    }

}
