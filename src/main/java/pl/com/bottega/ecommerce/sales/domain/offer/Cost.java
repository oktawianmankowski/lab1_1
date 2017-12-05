package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;

public class Cost {

    private BigDecimal totalCost;
    private String currency;

    public Cost(Product product, Discount discount, String currency) {
        super();
        this.currency = currency;
        BigDecimal discountValue = new BigDecimal(0);
        if (discount != null) {
            discountValue = discountValue.subtract(discount.getDiscount());
        }

        BigDecimal productPrice = product.getProductPrice();
        BigDecimal productQuantity = new BigDecimal(product.getQuantity());
        this.totalCost = productPrice.multiply(productQuantity).subtract(discountValue);
    }

    public BigDecimal getTotalCost() {
        return totalCost;
    }

    public String getCurrency() {
        return currency;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }

        Cost other = (Cost) obj;
        if (totalCost != null && other.getTotalCost() != null) {
            if (!totalCost.equals(other.getTotalCost())) {
                return false;
            }
        } else {
            return false;
        }
        return true;
    }

}
