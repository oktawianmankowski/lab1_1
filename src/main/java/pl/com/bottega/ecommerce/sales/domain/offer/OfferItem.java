/*
 * Copyright 2011-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;
import java.util.Date;

public class OfferItem {

    private Discount discount = new Discount();

    private Product product = new Product();

    private Money money = new Money();

    private int quantity;

    public OfferItem(String productId, Money productPrice, String productName, Date productSnapshotDate,
	    String productType, int quantity) {
	this(productId, productPrice, productName, productSnapshotDate, productType, quantity, null, null);
    }

    public OfferItem(String productId, Money productPrice, String productName, Date productSnapshotDate,
	    String productType, int quantity, Discount discount_arg, String discountCause) {
	this.product.setProductId(productId);
	this.product.setProductPrice(productPrice);
	this.product.setProductName(productName);
	this.product.setProductSnapshotDate(productSnapshotDate);
	this.product.setProductType(productType);

	this.quantity = quantity;
	this.discount = discount_arg;
	this.discount.setDiscountCause(discountCause);

	BigDecimal discountValue = new BigDecimal(0);
	if (discount_arg != null) {
	    discountValue = discount_arg.getDiscount().getTotalCost();
	}

	this.money.setTotalCost(
		product.getProductPrice().getTotalCost().multiply(new BigDecimal(quantity)).subtract(discountValue));
	this.money.setCurrency(product.getProductPrice().getCurrency());

    }

    public OfferItem(Product product, int quantity) {
	super();
	this.product = product;
	this.quantity = quantity;
    }

    public String getProductId() {
	return product.getProductId();
    }

    public Money getProductPrice() {
	return product.getProductPrice();
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

    public BigDecimal getTotalCost() {
	return money.getTotalCost();
    }

    public Product getProduct() {
	return this.product;
    }

    public Money getMoney() {
	return this.money;
    }

    public String getTotalCostCurrency() {
	return money.getCurrency();
    }

    public BigDecimal getDiscount() {
	return discount.getDiscount().getTotalCost();
    }

    public String getDiscountCause() {
	return discount.getDiscountCause();
    }

    public int getQuantity() {
	return quantity;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + (discount.getDiscount() == null ? 0 : discount.getDiscount().hashCode());
	result = prime * result + (product.getProductName() == null ? 0 : product.getProductName().hashCode());
	result = prime * result + (product.getProductPrice() == null ? 0 : product.getProductPrice().hashCode());
	result = prime * result + (product.getProductId() == null ? 0 : product.getProductId().hashCode());
	result = prime * result + (product.getProductType() == null ? 0 : product.getProductType().hashCode());
	result = prime * result + quantity;
	result = prime * result + (money.getTotalCost() == null ? 0 : money.getTotalCost().hashCode());
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
	OfferItem other = (OfferItem) obj;
	if (discount.getDiscount() == null) {
	    if (other.discount.getDiscount() != null) {
		return false;
	    }
	} else if (!discount.getDiscount().equals(other.discount.getDiscount())) {
	    return false;
	}
	if (product.getProductName() == null) {
	    if (other.product.getProductName() != null) {
		return false;
	    }
	} else if (!product.getProductName().equals(other.product.getProductName())) {
	    return false;
	}
	if (product.getProductPrice() == null) {
	    if (other.product.getProductPrice() != null) {
		return false;
	    }
	} else if (!product.getProductPrice().equals(other.product.getProductPrice())) {
	    return false;
	}
	if (product.getProductId() == null) {
	    if (other.product.getProductId() != null) {
		return false;
	    }
	} else if (!product.getProductId().equals(other.product.getProductId())) {
	    return false;
	}
	if (product.getProductType() != other.product.getProductType()) {
	    return false;
	}
	if (quantity != other.quantity) {
	    return false;
	}
	if (money.getTotalCost() == null) {
	    if (other.money.getTotalCost() != null) {
		return false;
	    }
	} else if (!money.getTotalCost().equals(other.money.getTotalCost())) {
	    return false;
	}
	return true;
    }

    /**
     *
     * @param item
     * @param delta
     *            acceptable percentage difference
     * @return
     */
    public boolean sameAs(OfferItem other, double delta) {
	if (product.getProductName() == null) {
	    if (other.product.getProductName() != null) {
		return false;
	    }
	} else if (!product.getProductName().equals(other.product.getProductName())) {
	    return false;
	}
	if (product.getProductPrice() == null) {
	    if (other.getProductPrice() != null) {
		return false;
	    }
	} else if (!product.getProductPrice().equals(other.product.getProductPrice())) {
	    return false;
	}
	if (product.getProductId() == null) {
	    if (other.product.getProductId() != null) {
		return false;
	    }
	} else if (!product.getProductId().equals(other.product.getProductId())) {
	    return false;
	}
	if (product.getProductType() != other.product.getProductType()) {
	    return false;
	}

	if (quantity != other.quantity) {
	    return false;
	}

	BigDecimal max, min;
	if (money.getTotalCost().compareTo(other.money.getTotalCost()) > 0) {
	    max = money.getTotalCost();
	    min = other.money.getTotalCost();
	} else {
	    max = other.money.getTotalCost();
	    min = money.getTotalCost();
	}

	BigDecimal difference = max.subtract(min);
	BigDecimal acceptableDelta = max.multiply(new BigDecimal(delta / 100));

	return acceptableDelta.compareTo(difference) > 0;
    }

}
