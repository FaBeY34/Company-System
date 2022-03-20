import java.util.Calendar;

public class Project {
    private String projectName;
    private Calendar startDate;
    private boolean state;

    public Project(String projectName, Calendar startDate, String state) {
        setProjectName(projectName);
        setStartDate(startDate);
        setState(state);
    }

    public Calendar getStartDate() {
        return startDate;
    }

    public void setStartDate(Calendar startDate) {
        this.startDate = startDate;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public void setState(String state) {
        switch (state) {
            case "Open":
                this.state = true;
                break;
            case "Close":
                this.state = false;
                break;
        }
    }

    public String getState() {
        if (state) {
            return "Open";
        }
        return "Close";
    }

    public void close() {
        if (state) {
            state = false;
        }
    }

    @Override
    public String toString() {
        return "Project [projectName=" + projectName + ", startDate=" + startDate.get(Calendar.DAY_OF_MONTH) + "/"
                + (startDate.get(Calendar.MONTH) + 1) + "/"
                + startDate.get(Calendar.YEAR) + ", state=" + getState() + "]";
    }
}
