import java.util.Calendar;

public class Person {
    private int id;
    private String firstName;
    private String lastName;
    private byte gender;
    private Calendar birthDate;
    private byte maritalStatus;
    private boolean hasDriverLicence;

    public Person(int id, String firstName, String lastName, String gender, Calendar birthDate, String maritalStatus,
            String hasDriverLicence) {
        setId(id);
        setFirstName(firstName);
        setLastName(lastName);
        setBirthDate(birthDate);
        setMaritalStatus(maritalStatus);
        setGender(gender);
        setHasDriverLicence(hasDriverLicence);
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        switch (gender) {
            case 1:
                return "Woman";
            case 2:
                return "Man";
            default:
                // TODO: Throw ex
                return null;
        }
    }

    public void setGender(String gender) {
        switch (gender) {
            case "Woman":
                this.gender = 1;
                return;
            case "Man":
                this.gender = 2;
                return;
            default:
                // TODO: Throw ex
                return;
        }
    }

    public Calendar getBirthDate() {
        return this.birthDate;
    }

    public void setBirthDate(Calendar birthDate) {
        this.birthDate = birthDate;
    }

    public String getMaritalStatus() {
        switch (maritalStatus) {
            case 1:
                return "Single";
            case 2:
                return "Married";
            default:
                // TODO: Throw ex
                return null;
        }
    }

    public void setMaritalStatus(String maritalStatus) {
        switch (maritalStatus) {
            case "Single":
                this.maritalStatus = 1;
            case "Married":
                this.maritalStatus = 2;
            default:
                // TODO: Throw ex
                return;
        }
    }

    public String getHasDriverLicence() {
        return hasDriverLicence ? "Yes" : "No";
    }

    public void setHasDriverLicence(String hasDriverLicence) {
        switch (hasDriverLicence) {
            case "Yes":
                this.hasDriverLicence = true;
                break;
            case "No":
                this.hasDriverLicence = false;
                break;
            default:
                // TODO: Throw ex
                return;
        }
    }

    @Override
    public String toString() {
        return "Person [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", gender=" + getGender()
                + ", birthDate=" + getBirthDate().get(Calendar.DAY_OF_MONTH) + "/"
                + (getBirthDate().get(Calendar.MONTH) + 1)
                + "/" + getBirthDate().get(Calendar.YEAR) + ", maritalStatus=" + getMaritalStatus()
                + ", hasDriverLicence="
                + getHasDriverLicence() + "]";
    }
}