package pl.com.bottega.ecommerce.sales.domain.offer;

public class Discount {

    private Cash cash;
    private String cause;

    public Discount(Cash cash, String cause) {
        this.cash = cash;
        this.cause = cause;
    }

    public Cash getCash() {
        return cash;
    }

    public String getCause() {
        return cause;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Discount other = (Discount) obj;
        if (cash == null) {
            if (other.cash != null)
                return false;
        } else if (!cash.equals(other.cash))
            return false;
        if (cause == null) {
            if (other.cause != null)
                return false;
        } else if (!cause.equals(other.cause))
            return false;
        return true;
    }
}