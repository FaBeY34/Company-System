import java.util.ArrayList;
import java.util.Calendar;

public class SalesEmployee extends RegularEmployee {
    private ArrayList<Product> sales;
    public static int numberOfSalesEmployees;
    private double totalValuesFromSales;// extra field

    public SalesEmployee(int id, String firstName, String lastName, String gender, Calendar birthDate,
            String maritalStatus, String hasDriverLicence, double salary, Calendar hireDate, Department department,
            double pScore, ArrayList<Product> s) {
        super(id, firstName, lastName, gender, birthDate, maritalStatus, hasDriverLicence, salary, hireDate, department,
                pScore);
        sales = s;
        numberOfSalesEmployees++;
        calculateTotalValuesFromSales(sales);
    }

    public SalesEmployee(RegularEmployee re, ArrayList<Product> s) {
        this(re.getId(), re.getFirstName(), re.getLastName(), re.getGender(), re.getBirthDate(), re.getMaritalStatus(),
                re.getHasDriverLicence(), re.getSalary(), re.getHireDate(), re.getDepartment(),
                re.getPerformanceScore(), s);
    }

    public double getTotalValuesFromSales() {
        return totalValuesFromSales;
    }

    public void setTotalValuesFromSales(double totalValuesFromSales) {
        this.totalValuesFromSales = totalValuesFromSales;
    }

    public ArrayList<Product> getSales() {
        return sales;
    }

    public void setSales(ArrayList<Product> sales) {
        this.sales = sales;
    }

    public boolean addSale(Product s) {
        if (!sales.contains(s)) {
            return sales.add(s);
        }
        return false;
    }

    public boolean removeSale(Product s) {
        if (sales.contains(s)) {
            return sales.remove(s);
        }
        return false;
    }

    public void calculateTotalValuesFromSales(ArrayList<Product> sales) {
        double total = 0;
        for (Product sale : sales) {
            total += sale.getPrice();
        }
        setTotalValuesFromSales(total);
    }

    @Override
    public String toString() {
        String productDetails = "";
        for (Product product : getSales()) {
            productDetails += "Product [productName=" + product.getProductName() + ", transactionDate="
                    + product.getSaleDate().get(Calendar.DAY_OF_MONTH) + "/"
                    + (product.getSaleDate().get(Calendar.MONTH) + 1)
                    + "/" + product.getSaleDate().get(Calendar.YEAR) + ", price=" + product.getPrice() + "] ";
        }
        return "SalesEmployee\n\t\t\t\tPerson Info [id=" + getId() + ", firstName=" + getFirstName() + ", firstName="
                + getLastName() + ", gender=" + getGender() + "]\n\t\t\t\tEmployee Info [salary=" + getSalary()
                + ", hireDate=" + getHireDate().get(Calendar.DAY_OF_MONTH) + "/"
                + (getHireDate().get(Calendar.MONTH) + 1)
                + "/" + getHireDate().get(Calendar.YEAR) + "]\n\t\t\t\tRegularEmployee Info [performanceScore="
                + getPerformanceScore() + ", bonus=" + getBonus() + "]\n\t\t\t\t[" + productDetails + "]\n\t\t\t";
    }
}
