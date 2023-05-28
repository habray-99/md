package student.entry.gui;

/**
 * Created by erspaudel on 7:10 AM, April 10, 2022
 */
public class FinalYear extends Student {
    private String projectName;
    private String supervisorName;
    private boolean submitted;

    public FinalYear(int id, String name, String projectName) {
        super(id, name);
        this.submitted = false;
        this.projectName = projectName;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getSupervisorName() {
        return supervisorName;
    }

    public void setSupervisorName(String supervisorName) {
        this.supervisorName = supervisorName;
    }

    public boolean isSubmitted() {
        return submitted;
    }

    public void setSubmitted(boolean submitted) {
        this.submitted = submitted;
    }

    public void submit(String supervisorName) {
        this.supervisorName = supervisorName;
        this.submitted = true;
    }

    public void display() {
        super.display();
        System.out.println("Project Name: " + this.projectName);
        System.out.println("Supervisor Name: " + this.supervisorName);
        System.out.println("Submitted: " + this.submitted);
    }
}
