package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;

public class Cash {

    private BigDecimal value;
    private String currency;

    public Cash(BigDecimal value, String currency) {
        this.value = value;
        this.currency = currency;
    }

}