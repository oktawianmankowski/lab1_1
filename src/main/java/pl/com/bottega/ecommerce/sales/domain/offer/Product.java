package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;
import java.util.Date;

public class Product {

	private String productId;

	private BigDecimal productPrice;

	private String productName;

	private Date productSnapshotDate;

	private String productType;

	private String currency;

	public String getProductId() {
		return productId;
	}

	public BigDecimal getProductPrice() {
		return productPrice;
	}

	public String getProductName() {
		return productName;
	}

	public Date getProductSnapshotDate() {
		return productSnapshotDate;
	}

	public String getProductType() {
		return productType;
	}

	public String getTotalCostCurrency() {
		return currency;
	}

	@Override
	public int hashCode() {
		int result = 1;
		result = result + ((productName == null) ? 0 : productName.hashCode());
		result = result + ((productPrice == null) ? 0 : productPrice.hashCode());
		result = result + ((productId == null) ? 0 : productId.hashCode());
		result = result + ((productType == null) ? 0 : productType.hashCode());
		return result;
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
		Product other = (Product) obj;
		if (productName == null) {
			if (other.productName != null)
				return false;
		} else if (!productName.equals(other.productName))
			return false;
		if (productPrice == null) {
			if (other.productPrice != null)
				return false;
		} else if (!productPrice.equals(other.productPrice))
			return false;
		if (productId == null) {
			if (other.productId != null)
				return false;
		} else if (!productId.equals(other.productId))
			return false;
		if (productType != other.productType)
			return false;
		return true;
	}

}
