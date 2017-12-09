package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;

public class Price implements Comparable<Price> {

	private BigDecimal price;
	
	private Currency currency;
	
	public Price(BigDecimal price, Currency currency)  {
		this.price = price;
		this.currency = currency;
	}
	
	public BigDecimal getPrice() {
		return price;
	}
	
	public Currency getCurrency() {
		return currency;
	}

	public int compareTo(Price arg0) {
		return price.compareTo(arg0.price);
	}

	
}
