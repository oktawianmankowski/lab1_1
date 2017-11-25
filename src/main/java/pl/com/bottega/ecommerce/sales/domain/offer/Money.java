package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;

public class Money implements Comparable<Money> {

	private BigDecimal value;
	private String currency;

	public Money() {
	}

	public Money(BigDecimal price, String currency) {
		super();
		this.value = price;
		this.currency = currency;
	}

	public BigDecimal getPrice() {
		return value;
	}

	public void setPrice(BigDecimal price) {
		this.value = price;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Money other = (Money) obj;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		if (currency == null) {
			if (other.currency != null)
				return false;
		} else if (!currency.equals(other.currency))
			return false;
		return true;
	}

	public int compareTo(Money other) {
		return value.compareTo(other.value);
	}
}
