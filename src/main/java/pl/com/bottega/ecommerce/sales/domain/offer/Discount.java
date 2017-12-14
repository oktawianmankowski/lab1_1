package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;

/**
 * Created by Lukasz on 2017-12-08.
 */
public class Discount {

    private String discountCause;

    private BigDecimal discountValue;

    public Discount(String discountCause, BigDecimal discountValue) {
        this.discountCause = discountCause;
        this.discountValue = discountValue;
    }

    public String getDiscountCause() {
        return discountCause;
    }

    public void setDiscountCause(String discountCause) {
        this.discountCause = discountCause;
    }

    public BigDecimal getDiscountValue() {
        return discountValue;
    }

    public void setDiscountValue(BigDecimal discountValue) {
        this.discountValue = discountValue;
    }
}
