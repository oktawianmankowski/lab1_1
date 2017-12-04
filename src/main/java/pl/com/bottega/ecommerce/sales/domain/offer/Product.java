package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;
import java.util.Date;

public class Product {

    private String productId;

    private BigDecimal productPrice;

    private String productName;

    private Date productSnapshotDate;

    private String productType;

    private int quantity;

    public Product(String productId, BigDecimal productPrice, String productName, Date productSnapshotDate,
            String productType, int quantity) {
        super();
        this.productId = productId;
        this.productPrice = productPrice;
        this.productName = productName;
        this.productSnapshotDate = productSnapshotDate;
        this.productType = productType;
        this.quantity = quantity;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Date getProductSnapshotDate() {
        return productSnapshotDate;
    }

    public void setProductSnapshotDate(Date productSnapshotDate) {
        this.productSnapshotDate = productSnapshotDate;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
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
        if (productName != null && other.getProductName() != null) {
            if (!productName.equals(other.getProductName())) {
                return false;
            }
        } else {
            return false;
        }
        if (productPrice != null && other.getProductPrice() != null) {
            if (!productPrice.equals(other.getProductPrice())) {
                return false;
            }
        } else {
            return false;
        }
        if (productId != null && other.getProductId() != null) {
            if (!productId.equals(other.getProductId())) {
                return false;
            }
        } else {
            return false;
        }
        if (productType != other.getProductType()) {
            return false;
        }
        if (quantity != other.getQuantity()) {
            return false;
        }
        return true;
    }
}
