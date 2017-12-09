package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;

public class Discount {

	private String discountCause;

	private BigDecimal discount;

	public Discount(String discountCause, BigDecimal discount) {
		this.discountCause = discountCause;
		this.discount = discount;
	}

	public BigDecimal getDiscount() {
		return discount;
	}

	public String getDiscountCause() {
		return discountCause;
	}

	@Override
	public int hashCode() {
		return discount.hashCode();
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
		Discount other = (Discount) obj;
		return discount.equals(other.discount);
	}

}
