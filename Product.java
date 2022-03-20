import java.util.Calendar;

public class Product {
    private String productName;
    private Calendar saleDate;
    private double price;

    public Product(String productName, Calendar saleDate, double price) {
        this.productName = productName;
        this.saleDate = saleDate;
        this.price = price;
    }

    public String getProductName() {
        return this.productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Calendar getSaleDate() {
        return this.saleDate;
    }

    public void setSaleDate(Calendar saleDate) {
        this.saleDate = saleDate;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product [productName=" + productName + ", saleDate=" + saleDate.get(Calendar.DAY_OF_MONTH) + "/"
                + (saleDate.get(Calendar.MONTH) + 1) + "/"
                + saleDate.get(Calendar.YEAR) + ", price=" + price + "]";
    }
}
