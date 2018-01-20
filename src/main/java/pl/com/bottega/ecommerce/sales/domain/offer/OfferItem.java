package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;
import java.util.Date;

public class OfferItem {

	// product
	private Product product;
	private Cash productPrice;
	private int quantity;
	private Cash totalCost;

	// discount
	private Discount discount;

	public OfferItem(Product product,Cash productPrice, int quantity) {
		this(product, productPrice, quantity, null);
	}

	public OfferItem(Product product, Cash productPrice, int quantity, Discount discount) {
		this.product = product;
		this.productPrice = productPrice;
		this.quantity = quantity;
		this.discount = discount;

		BigDecimal discountValue = new BigDecimal(0);
		if (discount != null)
			discountValue = discountValue.subtract(discount.getCash().getValue());

		this.totalCost = new Cash(productPrice.getValue().multiply(new BigDecimal(quantity)).subtract(discountValue),
				productPrice.getCurrency());
	}

	public String getProductId() {
		return product.getProductId();
	}

	public Cash getProductPrice() {
		return productPrice;
	}

	public String getProductName() {
		return product.getProductName();
	}

	public Date getProductSnapshotDate() {
		return product.getProductSnapshotDate();
	}

	public String getProductType() {
		return product.getProductType();
	}

	public Cash getTotalCost() {
		return totalCost;
	}

	public String getTotalCostCurrency() {
		return productPrice.getCurrency();
	}

	public Discount getDiscount() {
		return discount;
	}

	public String getDiscountCause() {
		return discount.getCause();
	}

	public int getQuantity() {
		return quantity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((discount == null) ? 0 : discount.hashCode());
		result = prime * result + ((product.getProductName() == null) ? 0 : product.getProductName().hashCode());
		result = prime * result + ((productPrice == null) ? 0 : productPrice.hashCode());
		result = prime * result + ((product.getProductId() == null) ? 0 : product.getProductId().hashCode());
		result = prime * result + ((product.getProductType() == null) ? 0 : product.getProductType().hashCode());
		result = prime * result + quantity;
		result = prime * result + ((totalCost == null) ? 0 : totalCost.hashCode());
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
		OfferItem other = (OfferItem) obj;
		if (discount == null) {
			if (other.discount != null)
				return false;
		} else if (!discount.equals(other.discount))
			return false;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		if (productPrice == null) {
			if (other.productPrice != null)
				return false;
		} else if (!productPrice.equals(other.productPrice))
			return false;
		if (quantity != other.quantity)
			return false;
		if (totalCost == null) {
			if (other.totalCost != null)
				return false;
		} else if (!totalCost.equals(other.totalCost))
			return false;
		return true;
	}

	public boolean sameAs(OfferItem other, double delta) {
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		if (productPrice == null) {
			if (other.productPrice != null)
				return false;
		} else if (!productPrice.equals(other.productPrice))
			return false;
		if (quantity != other.quantity)
			return false;

		BigDecimal max, min;
		if (totalCost.getValue().compareTo(other.totalCost.getValue()) > 0) {
			max = totalCost.getValue();
			min = other.totalCost.getValue();
		} else {
			max = other.totalCost.getValue();
			min = totalCost.getValue();
		}

		BigDecimal difference = max.subtract(min);
		BigDecimal acceptableDelta = max.multiply(new BigDecimal(delta / 100));

		return acceptableDelta.compareTo(difference) > 0;
	}

}