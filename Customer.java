import java.util.ArrayList;
import java.util.Calendar;

public class Customer extends Person {
    private ArrayList<Product> products;

    public Customer(int id, String firstName, String lastName, String gender, Calendar birthDate, String maritalStatus,
            String hasDriverLicence, ArrayList<Product> products) throws Exception {
        super(id, firstName, lastName, gender, birthDate, maritalStatus, hasDriverLicence);

        this.products = products;
    }

    public Customer(Person person, ArrayList<Product> products) throws Exception {
        this(person.getId(), person.getFirstName(), person.getLastName(), person.getGender(), person.getBirthDate(),
                person.getMaritalStatus(), person.getHasDriverLicence(), products);
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        var productDetails = "";
        for (Product product : products) {
            productDetails += "Product [productName=" + product.getProductName() + ", transactionDate="
                    + product.getSaleDate().get(Calendar.DAY_OF_MONTH) + "/"
                    + (product.getSaleDate().get(Calendar.MONTH) + 1)
                    + "/" + product.getSaleDate().get(Calendar.YEAR) + ", price=" + product.getPrice() + "] ";
        }
        return "Customer [id=" + getId() + ", products=[" + productDetails + "]]";
    }
}