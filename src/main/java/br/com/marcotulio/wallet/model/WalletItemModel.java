package br.com.marcotulio.wallet.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "wallet_items")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WalletItemModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JoinColumn(name = "wallet", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private WalletModel wallet;
    @NotNull
    private Date date;
    @NotNull
    private String type;
    @NotNull
    private String description;
    @NotNull
    private BigDecimal value;
}
