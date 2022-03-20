import java.util.ArrayList;
import java.util.Calendar;

public class Developer extends RegularEmployee {
    private ArrayList<Project> projects;
    public static int numberOfDevelopers;

    public Developer(int id, String firstName, String lastName, String gender, Calendar birthDate, String maritalStatus,
            String hasDriverLicence, double salary, Calendar hireDate, Department department, double pScore,
            ArrayList<Project> p) {
        super(id, firstName, lastName, gender, birthDate, maritalStatus, hasDriverLicence, salary, hireDate, department,
                pScore);

        projects = p;
        numberOfDevelopers++;
    }

    public Developer(RegularEmployee re, ArrayList<Project> p) {
        this(re.getId(), re.getFirstName(), re.getLastName(), re.getGender(), re.getBirthDate(), re.getMaritalStatus(),
                re.getHasDriverLicence(), re.getSalary(), re.getHireDate(), re.getDepartment(),
                re.getPerformanceScore(), p);
    }

    public ArrayList<Project> getProjects() {
        return projects;
    }

    public void setProjects(ArrayList<Project> projects) {
        this.projects = projects;
    }

    public boolean addProject(Project s) {
        if (!projects.contains(s)) {
            return projects.add(s);
        }
        return false;
    }

    public boolean removeProject(Project s) {
        if (projects.contains(s)) {
            return projects.remove(s);
        }
        return false;
    }

    @Override
    public String toString() {
        String projectDetails = "";
        for (Project project : projects) {
            projectDetails += "Project [projectName=" + project.getProjectName() + ", startDate="
                    + project.getStartDate().get(Calendar.DAY_OF_MONTH) + "/"
                    + (project.getStartDate().get(Calendar.MONTH) + 1)
                    + "/" + project.getStartDate().get(Calendar.YEAR) + ", state=" + project.getState() + "] ";
        }
        return "Developer\n\t\t\t\tPerson Info [id=" + getId() + ", firstName=" + getFirstName() + ", firstName="
                + getLastName() + ", gender=" + getGender() + "]\n\t\t\t\tEmployee Info [salary=" + getSalary()
                + ", hireDate=" + getHireDate().get(Calendar.DAY_OF_MONTH) + "/"
                + (getHireDate().get(Calendar.MONTH) + 1)
                + "/" + getHireDate().get(Calendar.YEAR) + "]\n\t\t\t\tRegularEmployee Info [performanceScore="
                + getPerformanceScore() + ", bonus=" + getBonus() + "]\n\t\t\t\t[" + projectDetails + "]\n\t\t\t";
    }
}