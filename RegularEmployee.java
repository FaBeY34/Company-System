import java.util.Calendar;

public class RegularEmployee extends Employee {
    private double performanceScore;
    private double bonus;

    public RegularEmployee(int id, String firstName, String lastName, String gender, Calendar birthDate,
            String maritalStatus, String hasDriverLicence, double salary, Calendar hireDate, Department department,
            double performanceScore) throws Exception {
        super(id, firstName, lastName, gender, birthDate, maritalStatus, hasDriverLicence, salary, hireDate,
                department);

        this.performanceScore = performanceScore;
    }

    public RegularEmployee(Employee employee, double perfScore) throws Exception {
        this(employee.getId(), employee.getFirstName(), employee.getLastName(), employee.getGender(),
                employee.getBirthDate(), employee.getMaritalStatus(), employee.getHasDriverLicence(),
                employee.getSalary(), employee.getHireDate(), employee.getDepartment(), perfScore);
    }

    public double getPerformanceScore() {
        return this.performanceScore;
    }

    public void setPerformanceScore(double performanceScore) {
        this.performanceScore = (int) (100 * performanceScore) / 100.0;
    }

    public double getBonus() {
        return this.bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = (int) (100 * bonus) / 100.0;
    }

    @Override
    public String toString() {
        return "RegularEmployee\n\t\t\t\tPerson Info [id=" + getId() + ", firstName=" + getFirstName()
                + ", firstName="
                + getLastName() + ", gender=" + getGender() + "]\n\t\t\t\tEmployee Info [salary=" + getSalary()
                + ", hireDate=" + getHireDate().get(Calendar.DAY_OF_MONTH) + "/"
                + (getHireDate().get(Calendar.MONTH) + 1)
                + "/" + getHireDate().get(Calendar.YEAR) + "]\n\t\t\t\tRegularEmployee Info [performanceScore="
                + getPerformanceScore() + ", bonus=" + getBonus() + "]\n\t\t\t";
    }
}