/*
 * Copyright 2011-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;

public class OfferItem {

    private Product product;

    private Cost costs;

    private Discount discount;

    private String currency;

    public OfferItem(Product product, String currency) {
        this(product, null, currency);
    }

    public OfferItem(Product product, Discount discount, String currency) {
        this.product = product;
        this.discount = discount;
        this.currency = currency;
        this.costs = new Cost(product, discount);
    }

    public BigDecimal getTotalCosts() {
        return costs.getTotalCost();
    }

    public String getTotalCostsCurrency() {
        return currency;
    }

    public Discount getDiscount() {
        return discount;
    }

    public Product getProduct() {
        return product;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result +
                (discount == null || discount.getDiscount() == null ? 0 : discount.getDiscount().hashCode());
        result = prime * result +
                (product == null || product.getProductName() == null ? 0 : product.getProductName().hashCode());
        result = prime * result +
                (product == null || product.getProductPrice() == null ? 0 : product.getProductPrice().hashCode());
        result = prime * result +
                (product == null || product.getProductId() == null ? 0 : product.getProductId().hashCode());
        result = prime * result +
                (product == null || product.getProductType() == null ? 0 : product.getProductType().hashCode());
        result = prime * result + (product == null ? 0 : product.getQuantity());
        result = prime * result + (costs == null || costs.getTotalCost() == null ? 0 : costs.getTotalCost().hashCode());
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
        if (discount != null && other.getDiscount() != null) {
            if (!discount.equals(other.discount)) {
                return false;
            }
        } else {
            return false;
        }
        if (product != null && other.getProduct() != null) {
            if (!product.equals(other.getProduct())) {
                return false;
            }
        } else {
            return false;
        }
        if (costs != null && other.getTotalCosts() != null) {
            if (!product.equals(other.getTotalCosts())) {
                return false;
            }
        } else {
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
        if (product != null && other.getProduct() != null) {
            if (!product.equals(other.getProduct())) {
                return false;
            }
        } else {
            return false;
        }

        BigDecimal max, min;
        if (costs.getTotalCost().compareTo(other.getTotalCosts()) > 0) {
            max = costs.getTotalCost();
            min = other.getTotalCosts();
        } else {
            max = other.getTotalCosts();
            min = costs.getTotalCost();
        }

        BigDecimal difference = max.subtract(min);
        BigDecimal acceptableDelta = max.multiply(new BigDecimal(delta / 100));

        return acceptableDelta.compareTo(difference) > 0;
    }

}
